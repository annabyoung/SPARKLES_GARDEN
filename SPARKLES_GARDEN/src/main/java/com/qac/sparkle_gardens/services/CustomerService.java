package com.qac.sparkle_gardens.services;

import java.util.ArrayList;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.util.CreditStatus;

/**
 * 
 * @author James Thompson
 *
 */
public class CustomerService {
	@Inject CustomerRepository customerRepository;
	
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
		if(customerRepository.findByEmail(email).equals(null)) {
			// need to check is email is valid user@domain.com format?
			
					if(firstName.length() >= 3 && firstName.length() < 255 ){
						if(lastName.length() >= 3 && lastName.length() < 255){
							if(password.length() >= 6 && password.length() < 255){
									
								return true; // all information is valid?
							
							}//password
						}//last name	
					}//first name 
					 
		}//email 
		return false;
	
	}
	
	/**
	 * Checks to make sure the login details are correct.
	 * If account does not exist -1
	 * If password doesnt match -2
	 * If account cannot be accessed -3
	 * If valid returns the Account ID
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public long getUserIDAtLogin(String email, String password) {
		Customer customer = customerRepository.findByEmail(email);
		if(!customer.equals(null)) {
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
	
	public void makeNewCustomer(String firstName, String lastName, String email, CreditStatus creditStatus, Address address, String password, String phone){

		Customer customer= new Customer();
		
		customerRepository.persistCustomer(customer);
		
	}
	
	
	 
	/**
	 * takes a customer from paper account and creates an new customer account for them
	 * 
	 * I have absolutely no idea where the data comes from for this.
	 * lets say its a database, then should i just take in a customer object?
	 *  
	 * 
	 * @param firstName
	 * @return
	 */
	public void upgradeAccount(String firstName, String lastName, String email, CreditStatus creditstatus, String address, String password  )
	{
		Customer upgradedCustomer = new Customer();
		
		customerRepository.persistCustomer(upgradedCustomer); 
		
	}

	
	
	//updating details
	/**
	 *  updates a specific item in a users details. may need to make multiple functoins
	 *  does not work for creditStatus (yet?)
	 *  assumes valid information set in currently. 
	 *  returns true if update is successful.
	 * @param userID
	 * @param updatedField
	 * @param newInformation
	 * @return
	 */
	
	public boolean updateAccountDetails(long userID, String updatedField, String newInformation){
		
		
		switch(updatedField){
		case "firstName":
			customerRepository.findByID(userID).setFirstName(newInformation);
			return true;
		case "lastName":
			customerRepository.findByID(userID).setLastName(newInformation);
			return true;
		case "email":
			customerRepository.findByID(userID).setEmail(newInformation);
			return true;
		case "password":
			customerRepository.findByID(userID).setPassword(newInformation);
			return true;
		case "phone":
			customerRepository.findByID(userID).setPhone(newInformation);
			default: 
				return false;
		}
	}
	
	
	
}