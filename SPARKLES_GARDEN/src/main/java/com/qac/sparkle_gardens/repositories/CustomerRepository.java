package com.qac.sparkle_gardens.repositories;

import java.util.List;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.util.MethodAuthor;

/**
 * 
 * @author Sean Connelly 
 *
 */

public interface CustomerRepository {
	
	public void persistCustomer(Customer customer);
	public void persistCustomer(List<Customer> customers);
	
	public Customer findByID(long accountID);
	
	public Customer getCustomer(Customer c); //get customer
	public boolean updateCustomer(Customer c); //update customer what am i updating tho? I may need more of these 
	public boolean removeCustomer(Customer c); //remove customer
	public List<CustomerHasAddress> findCustomerAddresses(Customer c);
	public List<CustomerHasCard> findCustomerCards(Customer c); //maybe get composite class? 
//	public void updateCustomer(Customer c); //update customer what am i updating tho? I may need more of these 
//	public void removeCustomer(Customer c); //remove customer
	public void findCustomerAdresses(Customer c);
//	public Card findCustomerCards(Customer c);
	
	/**
	 * Finds a customer by their email address and returns null is no customer is found
	 * 
	 * @param email
	 * @return
	 */
	@MethodAuthor(author="James")
	public Customer findByEmail(String email);
	boolean isEmail(String email);

}
