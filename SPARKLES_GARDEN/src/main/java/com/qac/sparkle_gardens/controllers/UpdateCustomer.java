package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.services.CustomerService;


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
public class UpdateCustomer implements Controller<Customer> 
{
	@Inject
	CustomerService service;

	private long userID;
	private String errors="unable to update information";
	
	
	//form inputs
	
	
	// update cards and address need to be their own controllers 
	
	public String updateCustomers(long customerID)
	{
		
		
		Customer customer = service.getCustomerByID(userID);
		
		//change value here with science 
		//display values
	
		//validate stuff
		
	
		if (service.updateAccountDetails(customer))		
		return "home"; // successfully added a customer 
		else
			return errors;
	
	}
	@Override
	public void handleMessage(Customer messagedCustomer){
		//TODO set logged in customer to be the received customer
		//TODO display a confirmation message to the customer 
	}
}


