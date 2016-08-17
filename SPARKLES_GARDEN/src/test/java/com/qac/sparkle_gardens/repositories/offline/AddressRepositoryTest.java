package com.qac.sparkle_gardens.repositories.offline;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.repositories.AddressRepository;

public class AddressRepositoryTest {
	@Before
	public void initTestCase() {
		AddressRepository addressRepo = new AddressRepositoryOffline();
	}
	@Parameter
	Address address = new Address(1, "Anchorage", "Anchorage Quay", "Salford Quays", "England", "M50 3YJ");
	
	/**
	@Test
	public void findByAccountIdNotFound() {
		
	}
	**/
	
	@Test
	public void duplicateFound() {
		addressRepo.persistAddress(address);
		Address dummyAddress = new Address(1, "Anchorage", "Anchorage Quay", "Salford Quays", "England", "M50 3YJ");
		assertEquals(addressRepo.isDuplicate(dummyAddress), true);
	}

}
