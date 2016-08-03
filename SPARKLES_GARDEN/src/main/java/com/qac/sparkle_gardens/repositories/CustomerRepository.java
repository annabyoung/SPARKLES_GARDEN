package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;
import com.qac.sparkle_gardens.entities.Customer;

public interface CustomerRepository {
	
	public void persistCustomer(Customer customer);
	public void persistCustomer(ArrayList<Customer> customers);
	
	public Customer getCustomer();
	public void updateCustomer();
	public void removeCustomer(); 

}
