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


@Named(value= "Register")
@RequestScoped

// or maybe conversation scoped ?

/**
 * 
 * @author Sean connelly 
 * 
 * creates a new customer 
 *
 */

public class Registration { 
	
	@Inject 
	CustomerService customerService;
	@Inject 
	AddressService addressService; // do i still need this?
	
	//how do i get data from front end? what does that look like 
	/**
	 *  makes a new customer data you get from front end
	 *  I will probably need to rewrite this to make 
	 *  it nice with front end
	 *  
	 *@author Sean Connelly 
	 *@param firstname 
	 *@param lastname
	 *@param email
	 *@param creditStatus
	 *@param address
	 *@param password 
	 *@param phone 
	 *@return
	 */
	
	  private String firstName=""; 
	  private String lastName="";
	  private String email="";
	  private CreditStatus creditStatus= CreditStatus.VALIDATING; // shouldn't be inputted here but will need external thingamjob to check it
	  private String password="";
	  private String phone=""; 
	  public String error="";
	  
	   private Address address; 
	  //address variables 
	  
	  
	
	public String makeNewCustomer(){
		
		//address = addressService.createAddress();
		//don't know what i'm doing here yet. this is probably its own controller 
		
		
		if (customerService.validateRegistrationDetails(firstName, lastName, password, email, phone)){
			customerService.makeNewCustomer(firstName, lastName, email, creditStatus, password, phone);
			 
		}
		else
			error= "Invalid Registration details. Try again.";
		
		
		return "home";
	}
	
}
