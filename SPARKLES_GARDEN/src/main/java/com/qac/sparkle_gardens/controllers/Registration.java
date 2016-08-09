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
	AddressService addressService;
	
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
	  private CreditStatus creditStatus= CreditStatus.VALIDATING; // this wouldn't be inputted
	  private Address address=""; /// and this // this no no bueno.
	  private String password="";
	  private String phone="";
	  	  
	  public String error="";
	  
	 
	
	public String makeNewCustomer(){
		// i think i need to call address and credit controllers to make work
		
		//validate the addressfunction 	
		address = addressService.createAddress(customerId, buildingNum, streetName, city, county, country, postCode);
		
		
		
		if (customerService.validateRegistrationDetails(firstName, lastName, password, email, phone)){
			customerService.makeNewCustomer(firstName, lastName, email, creditStatus, address, password, phone);
			// doens't work because it wanst a credit status and address object. have to make nice and shiny; 
		}
		else
			error= "Invalid Registration details. Try again.";
		
		
		return "home";
	}
	
}
