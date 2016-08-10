package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.util.MethodAuthor;

/**
 * 
 * @author Sean Connelly 
 *
 */

public interface CustomerRepository {
	
	public void persistCustomer(Customer customer);
	public void persistCustomer(ArrayList<Customer> customers);
	
	public Customer findByID(long accountID);
	
	public Customer getCustomer(Customer c); //get customer
	public void updateCustomer(Customer c); //update customer what am i updating tho? I may need more of these 
	public void removeCustomer(Customer c); //remove customer
	public void findCustomerAdresses(Customer c);
	public void findCustomerCards(Customer c);
	
	/**
	 * Finds a customer by their email address and returns null is no customer is found
	 * 
	 * @param email
	 * @return
	 */
	@MethodAuthor(author="James")
	public Customer findByEmail(String email);

}
