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

	Customer dummyCustomer =  new Customer("John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890"); 

	//Customer dummyCustomer; 
	

	
	public void persistCustomerTest(Customer customer){
	
	Customer dummyCustomer =  new Customer("John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890"); 
	}
	
	//CustomerInterface customerInterface = new CustomerService();
	// saw this in demo unsure why its needed. 

	 /**
	  * returns an ID 
	  * @param accountID
	  */
	@Test
	public void  findByIDTest(long accountID){
		
		Customer result = customerRepository.findByID(accountID);
		assertNotNull(result);
	}
	
	
	@Test	
	public void getCustomerTest(){
		
		Customer customer = customerRepository.getCustomer(dummyCustomer); 
		assertNotNull(customer);

		assertEquals(customer, dummyCustomer);

	}
		
	@Test
	public void updateCustomerTest(){

		boolean result = customerRepository.updateCustomer(dummyCustomer); //update customer what am i updating tho? I may need more of these 
	 assertTrue(result);
	}
		
	@Test
	public void removeCustomerTest(Customer c){
	customerRepository.removeCustomer(c); //remove customer
	
	}
	
	@Test
	public void findCustomerAddressesTest(Customer c){
	
		List<CustomerHasAddress> result = customerRepository.findCustomerAddresses(c);
		
		assertNotNull(result);
		}
		
	@Test
	public void findCustomerCardsTest(Customer c){

		List<CustomerHasCard> cards = customerRepository.findCustomerCards(c);

		assertNotNull(cards);
		
	}
	
	@Test
	public void findByEmailTest(String email){

	  // return customerRepository.findByEmail(email);
	    assertNotNull(customerRepository.findByEmail(email));
	
	}
}
