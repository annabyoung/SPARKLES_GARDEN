package com.qac.sparkle_gardens.repositories.offline;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.repositories.AddressRepository;
//import com.qac.sparkle_gardens.test_data.InitialData;

public class AddressRepositoryTest {
	
	
	Address address;
	AddressRepository addressRepo;
	//InitialData initData;
	
	@Before
	public void setup() {
		System.out.println("Setting up test...");
		addressRepo = new AddressRepositoryOffline();
		address = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
		//initData = new InitialData();
	}
	
	/**
	@Test
	public void findByAccountIdNotFound() {
		
	}
	**/
	
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

}
