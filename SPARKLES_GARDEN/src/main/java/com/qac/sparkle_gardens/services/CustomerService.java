package com.qac.sparkle_gardens.services;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;

/**
 * 
 * @author Damien Lloyd
 *
 */
public class CustomerService 
{
	@Inject
	CustomerRepository repository;
	
	boolean isNameValid(Customer c)
	{
		if (c.getFirstName().isEmpty() || c.getLastName().isEmpty())
			return false;
		return true;
	}
	
	boolean isAgeNegative(Customer c)
	{
		// TODO: Add Date of birth field/methods in Customer
		return true;
	}
	

}
