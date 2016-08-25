package com.qac.sparkle_gardens.repositories;

import java.util.List;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
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
	
	// checks for duplicate objects
	public boolean isDuplicate(Address address);
	
	@Deprecated
	public void removeCustomerHasAddress(CustomerHasAddress custAddress, long customerId);
	
	// Adds a CustomerHasAddress object
	@Deprecated
	public void addCustomerHasAddress(CustomerHasAddress cust, long accountId);
	
}
