package com.qac.sparkle_gardens.controllers;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.services.AddressService;

@Named (value = "address")
@RequestScoped
public class AddressController {
	@Inject private AddressService addService;
	
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
		addService.createAddress(customer, buildingNum, addressLine1, city, county, country, postCode, addressType);
	}
	
	/**
	 * 
	 * @param customer
	 * @param buildingNum
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param county
	 * @param country
	 * @param postCode
	 * @param addressType
	 */
	public void createAddress(Customer customer, String buildingNum, String addressLine1, String addressLine2, String city, String county, String country, String postCode, String addressType) {
		addService.createAddress(customer, buildingNum, addressLine1, addressLine2, city, county, country, postCode, addressType);
	}
	
	/**
	 * 
	 * @param customer
	 * @param newAddress
	 */
	public void createAddress(Customer customer, Address newAddress) {
		addService.createAddress(customer, newAddress);
	}
	
	/**
	 * 
	 * @param customer
	 * @param address
	 */
	public void updateAddress(Customer customer, Address address) {
		addService.updateAddress(customer, address);
	}
	
	public List<Address> getAddress(Customer customer) {
		return addService.getAddress(customer.getAccountID());
	} 
	
	/* Overloaded delete address method because
	 * a customer and address object can be passed in or 
	 * their IDs respectively.
	 * 
	 */
	public void deleteAddress(Customer customer, Address address) {
		addService.deleteAddress(customer, address);
	}
	
	public void deleteAddress(long acctId, long addressId) {
		addService.deleteAddress(acctId, addressId);
	}
}
