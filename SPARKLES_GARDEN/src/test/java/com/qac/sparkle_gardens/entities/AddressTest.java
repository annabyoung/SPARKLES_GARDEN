package com.qac.sparkle_gardens.entities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

public class AddressTest {
	
	@Parameter
	Address address = new Address(1, "Anchorage", "Anchorage Quay", "Salford Quays", "England", "M50 3YJ");
	
	@Test
	public void testEquals() {
		Address dummyAddress = new Address(1, "Anchorage", "Anchorage Quay", "Salford Quays", "England", "M50 3YJ");
		assertTrue(address.equals(dummyAddress));
	}

}
