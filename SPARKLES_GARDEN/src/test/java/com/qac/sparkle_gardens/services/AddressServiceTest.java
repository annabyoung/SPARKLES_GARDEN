package com.qac.sparkle_gardens.services;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.AddressRepository;
import com.qac.sparkle_gardens.repositories.offline.AddressRepositoryOffline;
import com.qac.sparkle_gardens.util.CreditStatus;

public class AddressServiceTest {
	
	private AddressService addService; 
	private Customer customer;
	private Address address;
	private AddressRepository addressRepo;
	
	
	@Before
	public void setup() {
		customer = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
		addService = new AddressService(); 
		address = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
		//addService.createAddress(customer, address);
		addressRepo = new AddressRepositoryOffline();
		addressRepo.persistAddress(address);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getAddressShouldThrowIllegalExceptionForInvalidAccountId() {
		long custId = 0;
		System.out.println("Testing getAddressShouldThrowIllegalExceptionForInvalidAccountId");
		addService.getAddress(custId);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deleteAddressShouldThrowIllegalExceptionForInvalidAddressId() {
		long acctId = 1, addressId = 0;
		System.out.println("Testing deleteAddressShouldThrowIllegalExceptionForInvalidIds");
		addService.deleteAddress(acctId, addressId);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createAddressShouldThrowIllegalExceptionForInvalidInput() {
		System.out.println("Testing createAddressShouldThrowIllegalExceptionForInvalidInput");
		addService.createAddress(null, null, null, null, null, null, null, null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void otherCreateAddressShouldThrowIllegalExceptionForInvalidInput() {
		System.out.println("Testing otherCreateAddressShouldThrowIllegalExceptionForInvalidInput");
		addService.createAddress(null, null, null, null, null, null, null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void anotherCreateAddressShouldThrowIllegalExceptionForInvalidInput() {
		System.out.println("Testing anotherCreateAddressShouldThrowIllegalExceptionForInvalidInput");
		addService.createAddress(null, null);
	}
	
	@Test
	public void createAddressShouldCreateAnAddressWithValidInput() {
		addService.createAddress(customer, address);
		assertFalse(addressRepo.findByAccountId(customer.getAccountID()).isEmpty());
	}
	
	
	@Test
	public void getAddressShouldReturnAnAddressWithValidInput() {
		addService.createAddress(customer, address);
		assertFalse(addService.getAddress(customer.getAccountID()).isEmpty());
	}
	
	@After
	public void teardown() {
		System.out.println("Test done. PEACE OUT!!");
		addService = null;
		customer = null;
		addressRepo = null;
		address = null;
		
	}

}
