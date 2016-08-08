package com.qac.sparkle_gardens.util;

import java.util.ArrayList;
import java.util.List;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;

/**
 * 
 * @author Tyler Deans
 * Dummy data for the address repository
 */
public class AddressInitialData {
	private List<Address> addresses = new ArrayList<Address>();
	private Customer customer = new Customer();
	
	public AddressInitialData() {
		addresses.add(new Address(customer, 1, "Anchorage 1", "Anchorage Quay", "Salford Quays", "England", "M50 3YJ"));
		
	}
	
	public ArrayList<Address> getAddresses() {
		return (ArrayList<Address>) addresses;
	}
}


