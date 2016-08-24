package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.util.CreditStatus;
/**
 * 
 * @author Sean Connelly
 * 
 *  only made one dummy address, should make more 
 *
 *deprecated in favor of InitialData (8/9/16)
 */
@Singleton 
@Deprecated 
public class CustomerInitialData {
	
		private List<Customer> customers = new ArrayList<Customer>();
			

		public CustomerInitialData(){
			
			Customer customer = new Customer(1, "John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890");
			Customer customer2 = new Customer(2, "Jane", "doe", "email01@email.com", CreditStatus.VALIDATING, "password01", "0987654321");
			Customer customer3 = new Customer(3, "Joe", "Schmoe", "email999@email.com", CreditStatus.VALID, "password01", "1357908642");
			Customer customer4 = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
			
			customers.add(0, customer);
			customers.add(1, customer2);
			customers.add(2, customer3);
			customers.add(3, customer4);


		}
		
		public List<Customer> getCustomers(){
			return customers;
		}
		
		public void setCustomer(List<Customer> customers){
			this.customers= customers;
		}
		
		public void addCustomer(Customer customer){
			customers.add(customer);
		}
	

}
