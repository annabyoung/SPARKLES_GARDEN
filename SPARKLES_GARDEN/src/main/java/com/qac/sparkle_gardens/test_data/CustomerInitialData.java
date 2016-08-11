package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
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
