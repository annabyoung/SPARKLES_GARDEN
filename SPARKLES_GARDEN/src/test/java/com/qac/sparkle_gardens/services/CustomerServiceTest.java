package com.qac.sparkle_gardens.services;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.controllers.CustomerInterface;

import junit.framework.TestCase;

/**
 * 
 * @author sean connelly 
 *
 */

public class CustomerServiceTest extends TestCase {
	
	@Inject 
	CustomerRepository customerRepository; 
	Customer dummyCustomer; 
	
	
	public void persistCustomerTest(Customer customer){
	
		  customerRepository.persistCustomer(customer);	
	}
	
	public void persistCustomerTest(List<Customer> customers){
	
		customerRepository.persistCustomer(customers);
	}
	
	public void  findByIDTest(long accountID){
		
		Customer result = customerRepository.findByID(accountID);
		assertNotNull(result);
	}
	
	public void getCustomerTest(Customer c){
		
		Customer customer = customerRepository.getCustomer(c); 
		assertNotNull(customer);
		assertsEquals(customer, dummyCustomer)
	}
		
	public void updateCustomerTest(Customer c){

		customerRepository.updateCustomer(c); //update customer what am i updating tho? I may need more of these 
	
	}
		
	
	public void removeCustomerTest(Customer c){
		customerRepository.removeCustomer(c); //remove customer
	}
	
	public void findCustomerAdressesTest(Customer c){
	
		customerRepository.findCustomerAdresses(c);
	}
		
		
	public void findCustomerCardsTest(Customer c){
		
		Cards cards customerRepository.findCustomerCards(c);
		assertNotNull(cards);
		
	}
	
	public Customer findByEmail(String email){

		
	   return customerRepository.findByEmail(email);
	
	}
}
