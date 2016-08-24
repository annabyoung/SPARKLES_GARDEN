package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.test_data.InitialData;
import com.qac.sparkle_gardens.util.CreditStatus;

public class CustomerServiceTest1 {
	
	@Inject
	private InitialData initialData = new InitialData();
	@Inject 
	private Address address = new Address();
	
	Customer customer;
	CustomerService customerService;
	Customer dummyCustomer; 
	Customer wrongCustomer;
	String firstName;
	String lastName;
	String email;
	String password;
	String phone;
	long userID;
	

	@Before 
	public void setup(){
		//System.out.println("SET UP CUSTOMER SERVICE TESTS");
		customerService= new CustomerService(); 
		Customer dummyCustomer =  new Customer(001, "John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890"); 
		Customer wrongCustomer =  new Customer(999, "betty", "blarfengarf", "fight me", CreditStatus.BLACKLISTED, "obama", "blue");
		String firstName="meep";
		String lastName="morp";
		String email="laime@email.com";
		String password="dorwssap";
		String phone="0987654321";
	    long userID=001;
	}
	
	
	@Test
	public void testValidateRegistrationDetails() {
		
		System.out.println("testValidateRegistrationDetails");
		boolean result = customerService.validateRegistrationDetails(firstName, lastName, password, email, phone);
		System.out.println(result);
		assertTrue(result); 
		//fail("Not yet implemented");
	}

	@Test
	public void testValidateEmailInputs() {
		System.out.println("testValidateEmailInputs");
		
		boolean result = customerService.validateEmailInputs(email);
		assertTrue(result);
		
		
	}

	@Test
	public void testGetUserIDAtLogin() {
		System.out.println("testGetUserIDAtLogin");
		customerService.getUserIDAtLogin(email, password);
		
		
	}

	@Test
	public void testMakeNewCustomer() {
		System.out.println("testMakeNewCustomer");
		
		customerService.makeNewCustomer(firstName, lastName, email, CreditStatus.VALID, password, phone);
		
	
	}

	@Test
	public void testUpgradeAccount() {
		System.out.println("testUpgradeAccount");
		
		customerService.upgradeAccount(firstName, lastName, email, CreditStatus.VALID, password, phone);
		
		
	
	}

	@Test
	public void testUpdateAccountDetails() {
		System.out.println("testUpdateAccountDetails");
		
		customerService.updateAccountDetails(customer);
		
	
	}

	@Test
	public void testGetCustomerByID() {
		System.out.println("testGetCustomerByID");
		
		customerService.getCustomerByID(userID);
		
	
	}

	@Test
	public void testValidateDetails() {
		System.out.println("testValidateDetails");
		
		customerService.validateDetails(email, password);
		
		
	}

	@Test
	public void testGetUserID() {
		System.out.println("testGetUserID");
		
		customerService.getUserID(email);
		
		
	}

	@Test
	public void testUpdateCustomerAddress() {
		System.out.println("testUpdateCustomerAddress");
		
		customerService.updateCustomerAddress(customer, address);
		
		
	}	
	
	@After
	public void teardown(){
		System.out.println("teardown!");
		//do science 
	}

}
