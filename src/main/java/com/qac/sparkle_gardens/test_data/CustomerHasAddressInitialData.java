package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.util.CreditStatus;

/**
 * 
 * @author Tyler
 *
 */
@Singleton
public class CustomerHasAddressInitialData {
	private List<CustomerHasAddress> cusAddList = new ArrayList<CustomerHasAddress>();
	
	public CustomerHasAddressInitialData() {
		Address dummyAddress = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
		Customer customer = new Customer(1, "John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890");
		Customer customer2 = new Customer(2, "Jane", "doe", "email01@email.com", CreditStatus.VALIDATING, "password01", "0987654321");
		Customer customer3 = new Customer(3, "Joe", "Schmoe", "email999@email.com", CreditStatus.VALID, "password01", "1357908642");
		Customer customer4 = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
		CustomerHasAddress custAdd = new CustomerHasAddress(customer, dummyAddress);  
		cusAddList.add(custAdd);
		cusAddList.add(new CustomerHasAddress(customer4, dummyAddress));
		cusAddList.add(new CustomerHasAddress(customer2, dummyAddress));
		cusAddList.add(new CustomerHasAddress(customer, dummyAddress));
		cusAddList.add(new CustomerHasAddress(customer3, dummyAddress));
	}
	
	public List<CustomerHasAddress> getCustomerHasAddresses() {
		return cusAddList;
	}
	
	public void addCustomerHasAddress(CustomerHasAddress custAdd) {
		cusAddList.add(custAdd);
	}
	
	public void setCustomerHasAddresses(List<CustomerHasAddress> cusAddList) {
		this.cusAddList = cusAddList;
	}
}
