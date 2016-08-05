package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import javax.inject.*;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.util.CustomerInitialData;

/**
 * 
 * @author Sean Connelly 
 *
 */

public class CustomerRepositoryOffline implements CustomerRepository
{	
	@Inject 
	private CustomerInitialData initialData;
	
		public CustomerRepositoryOffline()
		{
			initialData = new CustomerInitialData();
		}
		
		public void persistCustomer(Customer customer){
			initialData.addCustomer(customer);
			
		}
		
		public void persistCustomer(ArrayList<Customer> customers){
			initialData.setCustomer(customers);
		}
		
		
		public Customer findByID(Long accountID){
			ArrayList<Customer> theCustomers = initialData.getCustomers();
			for (int i=0; i<theCustomers.size(); i++)
			{
				if(theCustomers.get(i).getAccountID() == accountID){
					return theCustomers.get(i); 
				}
				
			}
		       Customer nothing = new Customer();
		       return nothing; //dunno if this works right 
		}
		
		//get customer
		public ArrayList<Customer> getCustomers(Customer c){
			
			return initialData.getCustomers();
			
		} 
		
		public Customer getCustomer(Customer c){
			ArrayList<Customer> theCustomers = initialData.getCustomers();
			
			for (int i=0; i<theCustomers.size(); i++)
			{
				if(theCustomers.get(i).equals(c)){
				 return theCustomers.get(i);
				}
			}
			 Customer nothing = new Customer();
		       return nothing; //dunno if this works right 
		}
		
		//update customer 
		public void updateCustomer(Customer c){
			ArrayList<Customer> theCustomers = initialData.getCustomers();
			
			for (int i=0; i<theCustomers.size(); i++)
			{
				if(theCustomers.get(i).equals(c)){
				 theCustomers.set(i, c);
				}
			}
		} 
		
		
		//remove customer
		public void removeCustomer(Customer c){
			ArrayList<Customer> theCustomers = initialData.getCustomers();
			
			for (int i=0; i<theCustomers.size(); i++)
			{
				if(theCustomers.get(i).equals(c)){
					theCustomers.remove(i);
				}
			}
			
		}

}
