package com.qac.sparkle_gardens.services;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;
import org.junit.Test;


import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.util.CreditStatus;
//import com.qac.sparkle_gardens.controllers.CustomerInterface;



import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
//import com.qac.sparkle_gardens.controllers.CustomerInterface;


import junit.framework.TestCase;

/**
 * 
 * @author sean connelly 
 *
 */

public class CustomerServiceTest extends TestCase {
	
<<<<<<< HEAD
	@Inject 
	CustomerRepository customerRepository; 

	Customer dummyCustomer =  new Customer("John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890"); 

	//Customer dummyCustomer; 
	

	
	public void persistCustomerTest(Customer customer){
=======
>>>>>>> e129f58b156b7e1e704826c0597df8fecf76aff2
	
	
	Customer dummyCustomer =  new Customer("John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890"); 
	CustomerRepository customerRepository; 
	CustomerInterface customerInterface = new CustomerService();
	

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
	public void getCustomerTest(Customer c){
		
		Customer customer = customerRepository.getCustomer(c); 
		assertNotNull(customer);

		assertEquals(customer, dummyCustomer);

	}
		
	@Test
	public void updateCustomerTest(Customer c){

		customerRepository.updateCustomer(c); //update customer what am i updating tho? I may need more of these 
	
	}
		
	@Test
	public void removeCustomerTest(Customer c){
		customerRepository.removeCustomer(c); //remove customer
	}
	
<<<<<<< HEAD

=======
	@Test
>>>>>>> e129f58b156b7e1e704826c0597df8fecf76aff2
	public void findCustomerAddressesTest(Customer c){
	
		customerRepository.findCustomerAddresses(c);

}
		
	@Test
	public void findCustomerCardsTest(Customer c){
		

		Card cards = customerRepository.findCustomerCards(c);

		assertNotNull(cards);
		
	}
	
	@Test
	public Customer findByEmail(String email){

		
	   return customerRepository.findByEmail(email);
	
	}
}
