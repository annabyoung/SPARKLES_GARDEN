/**
 * 
 */
package com.qac.sparkles_accounts.controllers;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkles_accounts.entities.CreditCheck;

/**
 * @author Annabelle Young
 *
 */
public class CreditCheckController implements Controller<Customer>{
	
	
	
	public void handleMessage(Customer messagedCustomer){
		System.out.println("Customer's Name is: " + messagedCustomer.getFirstName() + " "+ messagedCustomer.getLastName());
		//TODO set logged in customer to be the received customer
		//TODO display a confirmation message to the customer 
	}
}
