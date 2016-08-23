<<<<<<< HEAD

=======
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed
package com.qac.sparkle_gardens.repositories.offline;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.repositories.AddressRepository;
<<<<<<< HEAD
//import com.qac.sparkle_gardens.test_data.InitialData;
=======
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed

public class AddressRepositoryOfflineTest {
	
	
<<<<<<< HEAD
	Address address;
	AddressRepository addressRepo;
=======
	private Address address;
	private AddressRepository addressRepo;
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed
	
	@Before
	public void setup() {
		System.out.println("Setting up test...");
		addressRepo = new AddressRepositoryOffline();
		address = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
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
	public void duplicateFound() {
		
		Address dummyAddress = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
		assertTrue(addressRepo.isDuplicate(dummyAddress));
	}
	
	@After
	public void teardown() {
		System.out.println("End testing...");
		address = null;
		addressRepo = null;
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed
