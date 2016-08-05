package com.qac.sparkle_gardens.services;

import java.util.ArrayList;

import javax.inject.Inject;

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
	 * Takes in customer registration details and returns false if a customer with that e-mail already exists.
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
			return true;
		}
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
				if(customer.getCreditStatus().equals(CreditStatus.REGECTED) || customer.getCreditStatus().equals(CreditStatus.VALIDATING) || customer.getCreditStatus().equals(CreditStatus.DEACTIVATED))
					return -3;
				return customer.getAccountID();
				}
			return -2;
		}
		return -1;
	}
	
	//account conversion
	
	//updating details
	
}