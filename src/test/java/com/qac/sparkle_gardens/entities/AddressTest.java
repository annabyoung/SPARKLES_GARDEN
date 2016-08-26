package com.qac.sparkle_gardens.entities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

public class AddressTest {
	
	@Parameter
	Address address = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
	
	@Test
	public void testEquals() {
		Address dummyAddress = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
		assertTrue(address.equals(dummyAddress));
	}

}
