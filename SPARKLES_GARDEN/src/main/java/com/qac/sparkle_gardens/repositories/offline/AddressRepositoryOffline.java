package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.repositories.AddressRepository;
import com.qac.sparkle_gardens.util.AddressInitialData;

/**
 * 
 * @author Tyler Deans
 *
 */
public class AddressRepositoryOffline implements AddressRepository {
	@Inject private AddressInitialData initialData;
	/**
	 * Creates an address
	 * @param address
	 */
	public void persistAddress(Address address) {
		initialData.addAddress(address);
	}
	
	// Creates a list of addresses
	/**
	 * 
	 * @param address
	 */
	public void persistAddresses(List<Address> addresses) {
		initialData.setAddresses(addresses);
	}
	
	// Locate an address by ID
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Address findByCustomerId(long custId) {
		ArrayList<Address> list = initialData.getAddresses();
		Address place = new Address();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getCustomerId() == custId) {
				place = list.get(index);
			}
		}
		return place;
	}
	
	// Returns all the addresses
	public List<Address> getAddresses() {
		return initialData.getAddresses();
	}
	
	// Update as address
	/**
	 * 
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
	//Remove address
	/**
	 * 
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
}
