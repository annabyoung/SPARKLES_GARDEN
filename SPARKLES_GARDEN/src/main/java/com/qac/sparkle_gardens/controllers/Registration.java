package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.services.CustomerService;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.qac.sparkle_gardens.services.AddressService;


@Named(value= "Register")
@SessionScoped 
// or maybe conversation scoped ?

/**
 * 
 * @author sean connelly 
 * 
 * creates a new customer 
 *
 */

public class Registration {
	
	@Inject 
	CustomerService customerService;
	
	
	//how do i get data from front end? what does that look like 
	/**
	 *  makes a new customer data you get from front end
	 *  I will probably need to rewrite this to make 
	 *  it nice with front end
	 *    @author Sean Connelly 
	 *@param firstname 
	 *@param lastname
	 *@param email
	 *@param creditStatus
	 *@param address
	 *@param password 
	 *@param phone 
	 *@return
	 */
	
	public String makeNewCustomer(String firstName, String lastName, String email, CreditStatus creditStatus, Address address, String password , String phone){
		
		if (customerService.validateRegistrationDetails(firstName, lastName, password, email, phone)){
			customerService.makeNewCustomer(firstName, lastName, email, creditStatus, address, password, phone);
		}
		
		
		return "home";
	}
	
	
	
	

}
