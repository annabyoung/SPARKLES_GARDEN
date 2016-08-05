package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;
import com.qac.sparkle_gardens.entities.Customer;

/**
 * 
 * @author Sean Connelly 
 *
 */

public interface CustomerRepository {
	
	public void persistCustomer(Customer customer);
	public void persistCustomer(ArrayList<Customer> customers);
	
	public Customer findByID(Long accountID);
	
	public Customer getCustomer(Customer c); //get customer
	public void updateCustomer(Customer c); //update customer what am i updating tho? I may need more of these 
	public void removeCustomer(Customer c); //remove customer

}
