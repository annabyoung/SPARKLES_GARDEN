package com.qac.sparkle_gardens.entities;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Tyler Deans
 * This composite entity was created to resolve the issue
 * of the many to many relationship between customer and address. 
 */
public class CustomerHasAddress {
	// Composite key
	@Id
	@JoinColumn (name="customer_fk", nullable = false)
	@ManyToOne
	private Customer customer;
	
	@Id
	@JoinColumn (name="address_fk", nullable = false)
	@ManyToOne 
	private Address address;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
