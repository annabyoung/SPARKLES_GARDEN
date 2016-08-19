package com.qac.sparkle_gardens.services;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;
import org.junit.Test;


import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.util.CreditStatus;
//import com.qac.sparkle_gardens.controllers.CustomerInterface;



import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
//import com.qac.sparkle_gardens.controllers.CustomerInterface;


import junit.framework.TestCase;

/**
 * 
 * @author Sean Connelly 
 *
 */

public class CustomerServiceTest extends TestCase {
	
	@Inject 
	CustomerRepository customerRepository; 
	
	//CustomerInterface customerInterface = new CustomerService();
	// saw this in demo unsure why its needed. 

	Customer dummyCustomer =  new Customer(001, "John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890"); 
	Customer wrongCustomer =  new Customer(999, "betty", "blarfengarf", "fight me", CreditStatus.BLACKLISTED, "obama", "blue"); 
    


	 /**
	  * returns an ID 
	  * @param accountID
	  */
	@Test
	public void  findByIDTest(){
		
		Customer result = customerRepository.findByID(dummyCustomer.getAccountID());
		assertNotNull(result);
	}
	
	@Test
	public void  findByIDTestNOT(long accountID){
		
		Customer result = customerRepository.findByID(wrongCustomer.getAccountID());
		assertNotNull(result); /// should change this or make more to accomodate the semaphore 
	}
	
	//need to make for all to see graceful failure 
	
	@Test	
	public void getCustomerTest(){
		
		Customer customer = customerRepository.getCustomer(dummyCustomer); 
		assertNotNull(customer);

		assertEquals(customer, dummyCustomer);

	}
		
	@Test	
	public void getCustomerTestNOT(){
		
		Customer customer = customerRepository.getCustomer(wrongCustomer); 
		assertNotNull(customer);

		assertNotEquals(customer, wrongCustomer);
// not sure if this is right?
	}
	
	@Test
	public void updateCustomerTest(){

		boolean result = customerRepository.updateCustomer(dummyCustomer); //update customer what am i updating tho? I may need more of these 
	 assertTrue(result);
	}
		
	@Test
	public void updateCustomerTestNot(){

		boolean result = customerRepository.updateCustomer(wrongCustomer);
	 assertFalse(result);
	 //should return false because customer doesn't exists
	 // should probably make other services for which
	 //update customer gets a valid customer to update with invalid information.
	}
	
	//unsure what to assert for these 
	@Test
	public void removeCustomerTest(){
	customerRepository.removeCustomer(dummyCustomer); //remove customer
	
	}
	
	@Test
	public void removeCustomerTestNot(){
	customerRepository.removeCustomer(wrongCustomer); //remove customer
	
	}
	
	@Test
	public void findCustomerAddressesTest(){
	
		List<CustomerHasAddress> result = customerRepository.findCustomerAddresses(dummyCustomer);
		
		assertNotNull(result);
		}
	
	@Test
	public void findCustomerAddressesTestNot(){
	
		List<CustomerHasAddress> result = customerRepository.findCustomerAddresses(wrongCustomer);
		assertNull(result);
		//should be false for invalid customer
		//but also need to chekc for valid customer with invalid address
		
		}
		
	@Test
	public void findCustomerCardsTest(Customer c){

		List<CustomerHasCard> cards = customerRepository.findCustomerCards(c);

		assertNotNull(cards);
		
	}
	
	@Test
	public void findCustomerCardsTestNot(Customer c){

		List<CustomerHasCard> cards = customerRepository.findCustomerCards(c);

		assertNull(cards);
		
	}
	
	@Test
	public void findByEmailTest(){

	  // return customerRepository.findByEmail(email);
	    assertNotNull(customerRepository.findByEmail(dummyCustomer.getEmail()));
	
	}

	@Test
	public void findByEmailTestNot(){

	  // return customerRepository.findByEmail(email);
	    assertNull(customerRepository.findByEmail(wrongCustomer.getEmail()));
	
	}

}
