package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.services.CustomerService;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.qac.sparkle_gardens.services.AddressService;


/**
 * 
 * @author Sean Connelly 
 *
 * modify existing customer's information
 *
 *still need to figure out how i'm getting exsisting inputs 
 */

@Named(value= "updateCustomer")
@RequestScoped 


public class updateCustomer {
	
	@Inject
	CustomerService customerService;

	
	
	private long username;
	// dummy data

	//	
	

		customerService.updateAccountDetails(username, updatedField, newInformation);
	

}
