package com.qac.sparkle_gardens.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Tyler Deans
 * This composite entity was created to resolve the issue
 * of the many to many relationship between customer and address. 
 */
@Entity
@IdClass(CustomerHasAddressId.class)
@Table(name = "Customer Addresses")
public class CustomerHasAddress {
	// Composite key
	@Id	private Customer customer;

	@Id	private Address address;

	public CustomerHasAddress() {
		
	}
	
	public CustomerHasAddress(Customer customer, Address address) {
		this.customer = customer;
		this.address = address;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public long getAccountId() {
		return this.customer.getAccountID();
	}
	
	public long getAddressId() {
		return this.address.getAddressId();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getCustomerId() {
		return customer.getAccountID();
	}
	
	public boolean equals(CustomerHasAddress custAdd) {
		if (custAdd.getAccountId() == getAccountId() && custAdd.getAddressId() == getAddressId()) {
			return true;
		}
		
		return false;
	}
}

class CustomerHasAddressId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5947456138558952953L;

	@JoinColumn (name="customer_fk", nullable = false)
	@ManyToOne
	private Customer customer;

	@JoinColumn (name="address_fk", nullable = false)
	@ManyToOne 
	private Address address;

	public CustomerHasAddressId() {}

	public CustomerHasAddressId(Customer customer, Address address) {
		this.customer = customer;
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerHasAddressId other = (CustomerHasAddressId) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
}