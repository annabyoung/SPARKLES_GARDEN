package com.qac.sparkle_gardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.repositories.offline.CustomerRepositoryOffline;
import com.qac.sparkle_gardens.util.CreditStatus;

/**
 * 
 * @author James Thompson
 *
 */
@Stateless
public class CustomerService {
	@Inject private CustomerRepository customerRepository = new CustomerRepositoryOffline();
	
	
	
	
	/**
	 * Takes in customer registration details. 
	 * Returns false if a customer with that e-mail already exists or if other data isn't in valid format. 
	 * 
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 * @param phone
	 * @return
	 */
	public boolean validateRegistrationDetails(String firstName, String lastName, String password, String email, String phone) {
	//	if(customerRepository.findByEmail(email).equals(null)) {
		Customer c = customerRepository.findByEmail(email);
		if(!customerRepository.isEmail(email)) {
			// need to check is email is valid user@domain.com format?
			
					if(firstName.length() >= 3 && firstName.length() < 255 ){
						if(lastName.length() >= 3 && lastName.length() < 255){
							if(phone.length() == 10){
								if(password.length() >= 6 && password.length() < 255){
									
								return true; // all information is valid?
							
								}//password
							}//phone
						}//last name	
					}//first name 
					 
		}//email 
		return false;
	
	}
	
	
	
	/**
	 * make sure email is proper
	 * user@domain.com format
	 *  need to look up how to properly parse a string in java
	 *   
	 *   
	 * @param email
	 * @return
	 */
	
	public boolean validateEmailInputs(String email)
	{
		boolean valid = false;
		try{
		InternetAddress internetAddress = new InternetAddress(email);
		valid= true;
		}catch(AddressException e) {
			//false 
		}
		return valid;
	}
	
	
	
	/**
	 * Checks to make sure the login details are correct.
	 * If account does not exist -1
	 * If password doesnt match -2
	 * If account cannot be accessed -3
	 * If valid returns the Account ID
	 * 
	 *keep getting null pointers in testting.
	 *not sure WHEN this comes up so deprecating for now and coming 
	 *back later 
	 *
	 * @param email
	 * @param password
	 * @return
	 */
//	@Deprecated 
	public long getUserIDAtLogin(String email, String password) {
		Customer customer = customerRepository.findByEmail(email);
		if(customer != null) {
			if(customer.getPassword().equals(password)) {
				if(customer.getCreditStatus().equals(CreditStatus.REJECTED) || customer.getCreditStatus().equals(CreditStatus.VALIDATING) || customer.getCreditStatus().equals(CreditStatus.DEACTIVATED))
					return -3;
				return customer.getAccountID();
				}
			return -2;
		}
		return -1;
	}
	
	/**
	 * creates a new customer from input given 
	 * 
	 * 
	 */
	
	public boolean makeNewCustomer(String firstName, String lastName, String email, CreditStatus creditStatus, String password, String phone){

		Customer customer= new Customer(firstName, lastName, email, CreditStatus.VALIDATING, password, phone);
		
		try{
		 customerRepository.persistCustomer(customer);
		 return true; 
		 
		} catch (NullPointerException e){
			System.out.println("Failed to add. NO VALID INPUT Something dark side ");
		} finally {
			// nothing to do 
		}
		 return false; 
		
		 
	}
	
	
	 
	/**
	 * takes a customer from paper account and creates an new customer account for them
	 * 
	 * I have absolutely no idea where the data comes from for this.
	 * lets say its a database, then should i just take in a customer object?
	 *  come to think of it this may just create a new customer service?
	 * 
	 * @param firstName
	 * @return
	 */
	public boolean upgradeAccount(String firstName, String lastName, String email, CreditStatus creditstatus, String password, String phone)
	{
		try{
		Customer upgradedCustomer = new Customer(firstName, lastName, email, CreditStatus.VALIDATING, password, phone);		
		customerRepository.persistCustomer(upgradedCustomer); 
		return true;
		}catch(NullPointerException e){
			System.out.println("ERROR: INVALID INPUT CANNOT UPGRADE ACCOUNT");
		}
		return false;
	}

	
	
	//updating details
	/**
	 *  updates a specific item in a users details. may need to make multiple functoins
	 *  does not work for creditStatus but should credit status 
	 *  even be updated here? 
	 *  for addresses updates or card see their respective service 
	 *  
	 *  assumes valid information set in currently. 
	 *  returns true if update is successful.
	 *  
	 * @param userID
	 * @param updatedField
	 * @param newInformation
	 * @return
	 */
	
	public boolean updateAccountDetails(Customer customer){
		// make a validate function;
		try {
		customerRepository.updateCustomer(customer);
		return true;
		} catch(NullPointerException e){
			System.out.println("ERROR INVALID INPUT. cannot update customer");
			return false;
		}
		
		}
	
	
	
	public Customer getCustomerByID(long userID){
		
		return customerRepository.findByID(userID);
		
 	}

	
   //validates login details. 
	public boolean validateDetails(String username, String password) {
		Customer user  = customerRepository.findByEmail(username);
		
		if (user == null)
			return false; 
			
		
		if(user.getPassword().equals(password))
			return true;
		else 		
		return false;
	}



	public Customer getUserID(String email) {
		
		Customer customer = customerRepository.findByEmail(email);
		
		return customer;
	}
	
	//need to make one for cards as well. 
	/*
	 * add an address associated with customer. need to make silimar function to card
	 * but allen is still working on card.  
	 */
	public boolean updateCustomerAddress(Customer customer , Address newAddress){
		
		try{
		CustomerHasAddress cha = new CustomerHasAddress(customer, newAddress);
		return true;
		} catch(NullPointerException e){
			System.out.println("ERROR WRONG THING HAPPENED. UNABLE TO UPDATE ADDRESS");
			return false;
		}
		// should persist this SOMEWHERE 
	}
	
}