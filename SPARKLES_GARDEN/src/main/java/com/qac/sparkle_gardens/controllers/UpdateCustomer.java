package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
<<<<<<< HEAD:SPARKLES_GARDEN/src/main/java/com/qac/sparkle_gardens/controllers/UpdateCustomer.java
public class UpdateCustomer 
=======


public class updateCustomer implements Controller<Customer> 
>>>>>>> 2caba8f9bcaccf1df93b3bb549ba8e67c68fc975:SPARKLES_GARDEN/src/main/java/com/qac/sparkle_gardens/controllers/updateCustomer.java
{
	@Inject
	CustomerService service;

	private long userID;
	private String errors="unable to update information";
	
	// update cards and address need to be thier own controllers 
	
	public String updateCustomer(long customerID)
	{
		
		Customer customer = service.getCustomerByID(userID);
		
		//change value here with science 
		//do thing
		//validate stuff
		
	
		if (service.updateAccountDetails(customer))		
		return "home";
		else
			return errors;
	
	}
	@Override
	public void handleMessage(Customer messagedCustomer){
		//TODO set logged in customer to be the received customer
		//TODO display a confirmation message to the customer 
	}
}


