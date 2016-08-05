package com.qac.sparkle_gardens.services;

import java.util.ArrayList;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;

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
	
	public long getUserIDAtLogin(String email, String password) {
		Customer customer = customerRepository.findByEmail(email);
		if(!customer.equals(null)) {
			if(customer.getPassword().equals(password))
				return customer.getAccountID();
			return -2;
		}
		else {
			return -1;
		}
		
	}
	
	//account conversion
	
	//logging out
	
	//request catalogue
	
	//updating details
	
	//changing address
}