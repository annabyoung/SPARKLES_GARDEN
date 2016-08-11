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
	 * Locate an address by the customer ID
	 * @param id
	 * @return
	 */
	public List<Address> findByCustomerId(long accountId) {
		ArrayList<Address> correspondingAddresses = new ArrayList<Address>();
		for (CustomerHasAddress a: custAddressRepository.getCustomerHasAddresses()){
			if (a.getAccountId() == accountId){
				correspondingAddresses.add(a.getAddress());
			}
		}
		return correspondingAddresses;
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
		ArrayList<Address> addresses = initialData.getAddresses();
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
		ArrayList<Address> addresses = initialData.getAddresses();
		for (int index = 0; index < addresses.size(); index++) {
			if (addresses.get(index).getAddressId() == address.getAddressId()) {
				addresses.remove(index);
			}
		}
		initialData.setAddresses(addresses);
	}
	
	public void addCustomerHasAddress(CustomerHasAddress cust, long accountId) {
		ArrayList<Address> addresses = initialData.getAddresses();
		for (int index = 0; index < addresses.size(); index++) {
			if (addresses.get(index).getCustAddress().getAccountId() == accountId) {
				custAddressRepository.addCustomerHasAddress(cust);
			}
		}
	}
	
	public void removeCustomerHasAddress(CustomerHasAddress cust, long accountId) {
		ArrayList<Address> addresses = initialData.getAddresses();
		for (int index = 0; index < addresses.size(); index++) {
			if (addresses.get(index).getCustAddress().getAccountId() == accountId) {
				custAddressRepository.removeCustomerHasAddress(cust);
			}
		}
	}
}
