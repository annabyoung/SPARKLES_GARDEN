package com.qac.sparkle_gardens.util;

import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;

/**
 * 
 * @author Sean Connelly
 *
 */

@Singleton 
public class CustomerInitialData {
	
		private ArrayList<Customer> customers = new ArrayList<Customer>();
		
		public CustomerInitialData(){
			customers.add(new Customer("001", "John", "Smith", "email@email.com", "I don't know what a credit status would look like", "123 fake street"));
			customers.add(new Customer("002", "Jane", "doe", "email01@email.com", "Really what does a credit score look like", "456 real street"));
			customers.add(new Customer("003", "Joe", "Schmoe", "email999@email.com", "SOMETHING GOES HERE", "789 timeIsntReal ave"));
			customers.add(new Customer("004", "Luke", "Skywalker", "theForce@deathstar.com", "you don't need to see my credit score", "Tattooine"));
			// add stuff to do stuff thing 
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
