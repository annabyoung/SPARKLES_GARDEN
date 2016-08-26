package com.qac.sparkle_gardens.repositories;

import java.util.List;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;

/**
 * 
 * @author Allen Su
 * updated by Tyler Deans
 * I needed to be able to get a specific customer has address object
 */
public interface CustomerHasAddressRepository {
	/**
	 * Keeps CustomerHasAddresss in database.
	 * @param CustomerHasAddress c
	 */
	public void persistCustomerHasAddress(CustomerHasAddress c);

	/**
	 * Keeps ArrayList of CustomerHasAddresss.
	 * @param ArrayList<CustomerHasAddress> c
	 */
	public void persistCustomerHasAddresses(List<CustomerHasAddress> c);


	/**
	 * Gets all of the CustomerHasAddresss in the repository
	 * @return
	 */
	public List<CustomerHasAddress> getCustomerHasAddresses();
	
	/**
	 * Adds a new CustomerHasAddress into repository. Might be useless because persist CustomerHasAddress.
	 * @param c
	 */
	public void addCustomerHasAddress(CustomerHasAddress c);

	/**
	 * Updates a CustomerHasAddress.
	 * @param C 
	 */
	public void updateCustomerHasAddress(CustomerHasAddress C);

	/**
	 * Removes a CustomerHasAddress.
	 * @param c
	 */
	public void removeCustomerHasAddress(CustomerHasAddress c);
	
	/**
	 * Retrieves a specific instance of Customer Has Address
	 * @param address
	 * @param customer
	 * @return
	 */
	public CustomerHasAddress getCustomerHasAddress(Address address, Customer customer);

	/**
	 * Finds instances of Customer Owning Addresss by Customers.
	 * @param customerID
	 * @return
	 */
	public List<CustomerHasAddress> findByAccountId(long accountId);
	
	/**
	 * Finds instances of Customer Owning Addresss by Address.
	 * @param AddressID
	 * @return
	 */
	public List<CustomerHasAddress> findByAddressId(long addressId);
	
	/**
	 * @MethodAuthor Tyler Deans
	 * Checks if there are any customer addresses associated with an given address
	 * @return
	 */
	public boolean isAccountId(Address address);
}
