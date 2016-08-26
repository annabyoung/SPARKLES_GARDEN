
package com.qac.sparkle_gardens.repositories.offline;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.repositories.AddressRepository;
//import com.qac.sparkle_gardens.test_data.InitialData;
import com.qac.sparkle_gardens.repositories.CustomerHasAddressRepository;
import com.qac.sparkle_gardens.util.CreditStatus;

public class AddressRepositoryOfflineTest {
	
	
	private Address address;
	private AddressRepository addressRepo;
	private CustomerHasAddressRepository custAddRepo;
	private Customer customer;
	private CustomerHasAddress custAdd;
	
	@Before
	public void setup() {
		System.out.println("Setting up test...");
		addressRepo = new AddressRepositoryOffline();
		address = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
		customer = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
		custAdd = new CustomerHasAddress(customer, address);
		custAddRepo = new CustomerHasAddressRepositoryOffline();
		addressRepo.persistAddress(address);
		custAddRepo.persistCustomerHasAddress(custAdd);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	/**
	 * Test succeeds if findByAccountId is passed an invalid ID
	 */
	public void findByAccountIdShouldThrowIllegalExceptionForInvalidId() {
		long id = -1;
		addressRepo.findByAccountId(id);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void persistAddressShouldThrowIllegalExceptionForNullAddress() {
		addressRepo.persistAddress(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateAddressShouldThrowIllegalExceptionForNullAddress() {
		addressRepo.updateAddress(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void removeAddressShouldThrowIllegalExceptionForNullAddress() {
		addressRepo.removeAddress(null);
	}
	
	@Test
	public void isDuplicateShouldFindDuplicates() {
		
		Address dummyAddress = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
		assertTrue(addressRepo.isDuplicate(dummyAddress));
	}
	
	@Test
	public void findByAccountIdShouldReturnAddressWithValidInput() {
		assertNotNull(addressRepo.findByAccountId(customer.getAccountID()));
	}
	
	@After
	public void teardown() {
		System.out.println("End test");
		address = null;
		addressRepo = null;
		customer = null;
	}

}
