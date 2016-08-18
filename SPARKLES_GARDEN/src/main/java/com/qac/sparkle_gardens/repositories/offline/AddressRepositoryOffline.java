package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.repositories.AddressRepository;
import com.qac.sparkle_gardens.repositories.CustomerHasAddressRepository;
import com.qac.sparkle_gardens.test_data.AddressInitialData;

/**
 * 
 * @author Tyler Deans
 *
 */
@Stateless
@Default
public class AddressRepositoryOffline implements AddressRepository {
	@Inject private AddressInitialData  initialData = new AddressInitialData();
	@Inject private CustomerHasAddressRepository custAddressRepository;
	/**
	 * Creates an address
	 * @param address
	 */
	public void persistAddress(Address address) {
		initialData.addAddress(address);
	}
	
	/**
	 * Creates a list of addresses
	 * @param address
	 */
	public void persistAddresses(List<Address> addresses) {
		initialData.setAddresses(addresses);
	}
	
	/**
	 * Locate the address(s) by the customer ID
	 * @param id
	 * @return
	 */

	public List<Address> findByAccountId(long accountId) {
		List <Address> places = new ArrayList <Address>();
		// retrieves all the addresses a customer has 
	    List<CustomerHasAddress> custAddress = (ArrayList<CustomerHasAddress>) custAddressRepository.findByCustomerID(accountId);
		
		for (CustomerHasAddress cust : custAddress) {
			places.add(cust.getAddress());
		}
		return places;
	}
	
	// Returns all the addresses
	public List<Address> getAddresses() {
		return initialData.getAddresses();
	}
	

	/**
	 * Updates an address
	 * @param address
	 */
	public void updateAddress(Address address) {
		List<Address> addresses = initialData.getAddresses();
		for (int index = 0; index < addresses.size(); index++) {
			if (addresses.get(index).getAddressId() == address.getAddressId()) {
				addresses.set(index, address);
			}
		}
		initialData.setAddresses(addresses);
	}

	/**
	 * Removes an address
	 * @param address
	 */
	public void removeAddress(Address address) {
		List<Address> addresses = initialData.getAddresses();
		for (int index = 0; index < addresses.size(); index++) {
			if (addresses.get(index).getAddressId() == address.getAddressId()) {
				addresses.remove(index);
			}
		}
		initialData.setAddresses(addresses);
	}
	
	/**
	 * @param address
	 */
	public boolean isDuplicate(Address address) {
		List<Address> addresses = initialData.getAddresses();
		

		for (int index = 0; index < addresses.size(); index++) {
			if (address.equals(addresses.get(index))) {
				return true;
			}
		}
		return false;
	}
	
	@Deprecated
	public void addCustomerHasAddress(CustomerHasAddress cust, long accountId) {
		List<Address> addresses = initialData.getAddresses();
	}
	
	@Deprecated
	public void removeCustomerHasAddress(CustomerHasAddress cust, long accountId) {
		List<Address> addresses = initialData.getAddresses();
		for (int index = 0; index < addresses.size(); index++) {
			if (addresses.get(index).getCustAddress().getCustomerId() == accountId) {
				custAddressRepository.removeCustomerHasAddress(cust);
			}
		}
	}

}
