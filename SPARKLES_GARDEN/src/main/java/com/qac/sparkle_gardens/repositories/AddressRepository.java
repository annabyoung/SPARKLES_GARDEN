package com.qac.sparkle_gardens.repositories;

import java.util.List;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;

/**
 * 
 * @author Tyler Deans
 *
 */
public interface AddressRepository {
	// Creates an address
	public void persistAddress(Address address);
	
	// Creates a list of addresses
	public void persistAddresses(List<Address> addresss);
	
	// Locate an address by ID

	public List<Address> findByAccountId(long id); 
	
	// Returns all the addresses
	public List<Address> getAddresses();
	
	// Update as address
	public void updateAddress(Address address);
	//Remove address
	public void removeAddress(Address address);
	
	// Adds a CustomerHasAddress object
	public void addCustomerHasAddress(CustomerHasAddress cust, long accountId);
	
	// Removes a CustomerHasAddress object 
	public void removeCustomerHasAddress(CustomerHasAddress cust, long accountId);
}
