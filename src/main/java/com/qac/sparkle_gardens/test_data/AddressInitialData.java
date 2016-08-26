package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import com.qac.sparkle_gardens.entities.Address;

/**
 * 
 * @author Tyler Deans
 * Dummy data for the address repository
 * 
 * deprecated in favour of InitialData (9/8/16)
 */

@Singleton
public class AddressInitialData {
	private List<Address> addresses = new ArrayList<Address>();
	
	
	public AddressInitialData() {
		addAddress(new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping"));
		// I used an address generator online
		addAddress(new Address("8", "Ettersgill Cl", "Stockton-on-Tees", "United Kingdom", "TS16 0GJ", "Billing"));
		addAddress(new Address("18", "Lumsden Ave", "Southampton", "United Kingdom", "SO15 5EL", "Billing"));
		addAddress(new Address("3", "Cottenham Rd", "Histon", "Cambridge", "United Kingdom", "CB24 9ES", "Shipping"));
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public void addAddress(Address address) {
		addresses.add(address);
	}
	
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}


