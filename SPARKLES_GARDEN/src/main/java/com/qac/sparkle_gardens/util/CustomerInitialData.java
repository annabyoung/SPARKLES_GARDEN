package com.qac.sparkle_gardens.util;

import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.qac.sparkle_gardens.entities.Address;
/**
 * 
 * @author Sean Connelly
 * 
 *  only made one dummy address, should make more 
 *
 */

@Singleton 
public class CustomerInitialData {
	
		private ArrayList<Customer> customers = new ArrayList<Customer>();
		
		
		
		
		
		
		public CustomerInitialData(){
 
			Address dummyAddress= new Address(001, 123, "fake street", "Springfield", "Illinois", "USA", "123456" );
			
//			customers.add(new Customer("001", "John", "Smith", "email@email.com", "I don't know what a credit status would look like", "123 fake street"));
//			customers.add(new Customer("002", "Jane", "doe", "email01@email.com", "Really what does a credit score look like", "456 real street"));
//			customers.add(new Customer("003", "Joe", "Schmoe", "email999@email.com", "SOMETHING GOES HERE", "789 timeIsntReal ave"));
//			customers.add(new Customer("004", "Luke", "Skywalker", "theForce@deathstar.com", "you don't need to see my credit score", "Tattooine"));
			
			//String firstName, String lastName, String email, CreditStatus creditStatus, Address address String password
			customers.add(new Customer("John", "Smith", "email@email.com", CreditStatus.ONHOLD, dummyAddress, "password01", "1234567890"));
			customers.add(new Customer("Jane", "doe", "email01@email.com", CreditStatus.VALIDATING, dummyAddress, "password01", "0987654321"));
			customers.add(new Customer("Joe", "Schmoe", "email999@email.com", CreditStatus.VALID,dummyAddress, "password01", "1357908642"));
			customers.add(new Customer("Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, dummyAddress, "password01", "2468097531"));
			 
		}
		
		public ArrayList<Customer> getCustomers(){
			return customers;
		}
		
		public void setCustomer(ArrayList<Customer> customers){
			this.customers= customers;
		}
		
		public void addCustomer(Customer customer){
			customers.add(customer);
		}
	

}
