package com.qac.sparkle_gardens.services;

import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.repositories.AddressRepository;

public class AddressService {
	@Inject AddressRepository addressRepository;
	
	/**
	 * Retrieves the address - the list of products
	 * @param id
	 * @return
	 */
	public Address getAddress(long custId) {
		return addressRepository.findByCustomerId(custId);
	}
	
	/**
	 * deletes the address
	 * @param id
	 */
	public void deleteAddress(long custId) {
		Address address;
		address = addressRepository.findByCustomerId(custId);
		addressRepository.removeAddress(address);
	}
	
	/**
	 *  Creates a new address
	 * @param address
	 */
	public void createAddress(Address address) {
		addressRepository.persistAddress(address);
	}
	
	
	
}
