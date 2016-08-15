package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.repositories.AddressRepository;
import com.qac.sparkle_gardens.repositories.CustomerHasAddressRepository;
import com.qac.sparkle_gardens.test_data.InitialData;

/**
 * 
 * @author Tyler Deans
 *
 */
@Stateless
@Default
public class AddressRepositoryOffline implements AddressRepository {
	@Inject private InitialData initialData;
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
<<<<<<< HEAD
	public Address findByCustomerId(long accountId) {
		List<Address> list = initialData.getAddresses();
		Address place = new Address();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getCustomerId() == accountId) {
				place = list.get(index);
			}
=======
	public List<Address> findByAccountId(long accountId) {
		ArrayList <Address> places = new ArrayList <Address>();
		// retrieves all the addresses a customer has 
	    ArrayList<CustomerHasAddress> custAddress = (ArrayList<CustomerHasAddress>) custAddressRepository.findByCustomerID(accountId);
		
		for (CustomerHasAddress cust : custAddress) {
			places.add(cust.getAddress());
>>>>>>> 2caba8f9bcaccf1df93b3bb549ba8e67c68fc975
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
	
<<<<<<< HEAD
	public void addCustomerHasAddress(CustomerHasAddress cust, long accountId) {
		List<Address> addresses = initialData.getAddresses();
=======
	/**
	 * @param address
	 */
	public boolean isDuplicate(Address address) {
		ArrayList<Address> addresses = initialData.getAddresses();
		
>>>>>>> 2caba8f9bcaccf1df93b3bb549ba8e67c68fc975
		for (int index = 0; index < addresses.size(); index++) {
			if (address.equals(addresses.get(index))) {
				return true;
			}
		}
		return false;
	}
	
<<<<<<< HEAD
	public void removeCustomerHasAddress(CustomerHasAddress cust, long accountId) {
		List<Address> addresses = initialData.getAddresses();
		for (int index = 0; index < addresses.size(); index++) {
			if (addresses.get(index).getCustAddress().getCustomerId() == accountId) {
				custAddressRepository.removeCustomerHasAddress(cust);
			}
		}
	}
=======
>>>>>>> 2caba8f9bcaccf1df93b3bb549ba8e67c68fc975
}
