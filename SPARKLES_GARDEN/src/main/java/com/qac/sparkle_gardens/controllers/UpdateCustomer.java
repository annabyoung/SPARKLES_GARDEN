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
public class UpdateCustomer 
{
	@Inject
	CustomerService service;

	private String userID="";
	private String updatedInformation=""; // should this maybe be an enum?
	private String newInformation="";

	public String updateCustomer(long customerID)
	{
		/*if(customerService.updateAccountDetails(username, updatedField, newInformation))
		{
			String output= "successful updated information";
		}*/
		//service.updateAccountDetails(userID, updatedField, newInformation);
		return "home";
	}
}
