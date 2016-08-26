package com.qac.sparkle_gardens.services;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.repositories.AddressRepository;
import com.qac.sparkle_gardens.repositories.CustomerHasAddressRepository;
import com.qac.sparkle_gardens.repositories.offline.AddressRepositoryOffline;
import com.qac.sparkle_gardens.repositories.offline.CustomerHasAddressRepositoryOffline;

@Stateless
public class AddressService {
	@Inject private AddressRepository addressRepository = new AddressRepositoryOffline();
	@Inject private CustomerHasAddressRepository custAddressRepository = new CustomerHasAddressRepositoryOffline();
	
	/**
	 * Retrieves a list of the addresses a customer has
	 * @param id
	 * @return
	 */
	public List<Address> getAddress(long custId) {
		if (custId < 0) {
			throw new IllegalArgumentException();
		}
		return addressRepository.findByAccountId(custId);
	}
	
	/**
	 * deletes the address
	 * @param id
	 */
	public void deleteAddress(long acctId, long addressId) {
		if (acctId <= 0 || addressId <= 0) {
			throw new IllegalArgumentException();
		}
		// Retrieve all the addresses under a given address ID
		ArrayList<CustomerHasAddress> custAdd = (ArrayList<CustomerHasAddress>) custAddressRepository.findByAddressId(addressId);
		
		CustomerHasAddress custAddress = new CustomerHasAddress();
		// Finds the given account ID with that address ID
		for (CustomerHasAddress cust : custAdd) {
			if (cust.getAccountId() == acctId && cust.getAddressId() == addressId) {
				custAddress = cust;
			}
		}
		
		Address address = custAddress.getAddress();
		
		custAddressRepository.removeCustomerHasAddress(custAddress);
		/** if there are no other customers who have this associated address
		 * then the address is removed
		 */
		if (!custAddressRepository.isAccountId(address)) {
			addressRepository.removeAddress(address);
		}
		
	}
	
	/**
	 * 
	 * @param customer
	 * @param newAddress
	 */
	public void createAddress(Customer customer, Address newAddress) {
		if (customer == null || newAddress == null) {
			throw new IllegalArgumentException();
		}
		Address address = newAddress;
		CustomerHasAddress custAdd = new CustomerHasAddress(customer, address); 
		custAddressRepository.persistCustomerHasAddress(custAdd);
		
		/** This code prevents duplicate address objects from being created.
		 * If the address has not already been created then add a new address 
		 * to the repository.
		 */
		if (!addressRepository.isDuplicate(address)) {
			addressRepository.persistAddress(address);
		}
	}
	
	/**
	 * A create address method with more parameters
	 * @param customer
	 * @param buildingNum
	 * @param streetName
	 * @param city
	 * @param county
	 * @param country
	 * @param postCode
	 */
	public void createAddress(Customer customer, String buildingNum, String addressLine1, String addressLine2, String city, String county, String country, String postCode, String addressType) {
		if (customer == null || buildingNum == null || addressLine1 == null || addressLine2 == null || city == null || county == null|| country == null|| postCode == null|| addressType == null) {
			throw new IllegalArgumentException();
		}
		
		Address address = new Address(buildingNum, addressLine1, addressLine2, city, county, country, postCode, addressType);
		CustomerHasAddress custAdd = new CustomerHasAddress(customer, address); 
		custAddressRepository.persistCustomerHasAddress(custAdd);
		
		/** This code prevents duplicate address objects from being created.
		 * If the address has not already been created then add a new address 
		 * to the repository.
		 */
		if (!addressRepository.isDuplicate(address)) {
			addressRepository.persistAddress(address);
		}
		
	}
	
	/**
	 * 
	 * @param customer
	 * @param buildingNum
	 * @param addressLine1
	 * @param city
	 * @param county
	 * @param country
	 * @param postCode
	 * @param addressType
	 */
	public void createAddress(Customer customer, String buildingNum, String addressLine1, String city, String county, String country, String postCode, String addressType) {
		if (customer == null || buildingNum == null || addressLine1 == null || city == null || county == null|| country == null|| postCode == null|| addressType == null) {
			throw new IllegalArgumentException();
		}
		
		Address address = new Address(buildingNum, addressLine1, city, county, country, postCode, addressType);
		CustomerHasAddress custAdd = new CustomerHasAddress(customer, address); 
		custAddressRepository.persistCustomerHasAddress(custAdd);
		
		/** This code prevents duplicate address objects from being created.
		 * If the address has not already been created then add a new address 
		 * to the repository.
		 */
		if (!addressRepository.isDuplicate(address)) {
			addressRepository.persistAddress(address);
		}
		
	}
	/**
	 * Deletes the address
	 * @param customer
	 * @param otherAddress
	 */
	public void deleteAddress(Customer customer, Address address) {
		if (customer == null || address == null) {
			throw new IllegalArgumentException();
		}
		
		CustomerHasAddress custAdd = new CustomerHasAddress(customer, address);
		custAddressRepository.removeCustomerHasAddress(custAdd);
		
		/** if there are no other customers who have this associated address
		 * then the address is removed
		 */
		if (!custAddressRepository.isAccountId(address)) {
			addressRepository.removeAddress(address);
		}
		
	}
	
	/**
	 * Updates the address
	 * @param customer
	 * @param address
	 */
	public void updateAddress(Customer customer, Address address) {
		if (customer == null || address == null) {
			throw new IllegalArgumentException();
		}
		CustomerHasAddress custAdd = new CustomerHasAddress(customer, address);
		addressRepository.updateAddress(address);
		custAddressRepository.updateCustomerHasAddress(custAdd);
		
	}
	
	/**
	 *  Creates a new address (DEPRECATED)
	 * @param address
	 */
	@Deprecated
	public void createAddress(Address address) {
		addressRepository.persistAddress(address);
	}	
}