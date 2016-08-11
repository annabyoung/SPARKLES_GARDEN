package com.qac.sparkle_gardens.services;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.repositories.AddressRepository;
import com.qac.sparkle_gardens.repositories.CustomerHasAddressRepository;

public class AddressService {
	@Inject AddressRepository addressRepository;
	@Inject CustomerHasAddressRepository custAddressRepository;
	
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
		custAddressRepository.removeCustomerHasAddress(address.getCustAddress());
		addressRepository.removeCustomerHasAddress(address.getCustAddress(), address.getAccountId());
	}
	
	/**
	 *  Creates a new address
	 * @param address
	 */
	@Deprecated
	public void createAddress(Address address) {
		addressRepository.persistAddress(address);
	}
	
	/**
	 * Overloaded create address method
	 * @param customerId
	 * @param buildingNum
	 * @param streetName
	 * @param city
	 * @param county
	 * @param country
	 * @param postCode
	 */
	public void createAddress(Customer customer, int buildingNum, String streetName, String city, String county, String country, String postCode) {
		Address address = new Address(buildingNum, streetName, city, county, country, postCode);
		CustomerHasAddress custAdd = new CustomerHasAddress(customer, address); 
		custAddressRepository.persistCustomerHasAddress(custAdd);
		addressRepository.persistAddress(address);
		addressRepository.addCustomerHasAddress(custAdd, customer.getAccountID());
	}
	
	
	
}
