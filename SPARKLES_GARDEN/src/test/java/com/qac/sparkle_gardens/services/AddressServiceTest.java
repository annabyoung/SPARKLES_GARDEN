package com.qac.sparkle_gardens.services;

import org.junit.After;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

public class AddressServiceTest {
	
	
	@Parameter
	AddressService addService = new AddressService(); 
	
	@Test(expected = IllegalArgumentException.class)
	public void getAddressShouldThrowIllegalExceptionForInvalidAccountId() {
		long custId = 0;
		System.out.println("Testing getAddressShouldThrowIllegalExceptionForInvalidAccountId");
		addService.getAddress(custId);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deleteAddressShouldThrowIllegalExceptionForInvalidIds() {
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
		System.out.println("Another one.");
		System.out.println("Testing anotherCreateAddressShouldThrowIllegalExceptionForInvalidInput");
		addService.createAddress(null, null);
	}
	
	
	@After
	public void teardown() {
		System.out.println("Testing done. PEACE OUT!!");
		addService = null;
	}

}
