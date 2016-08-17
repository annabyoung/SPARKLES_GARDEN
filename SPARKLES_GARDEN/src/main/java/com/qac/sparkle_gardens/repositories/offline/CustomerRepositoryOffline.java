package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.*;


import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.test_data.InitialData;

/**
 * 
 * @author Sean Connelly 
 *
 */
@Stateless
@Default
public class CustomerRepositoryOffline implements CustomerRepository
{	
	@Inject 
	private InitialData initialData;
	private List<Customer> customers;
		public CustomerRepositoryOffline()
		{
			initialData = new InitialData();
			
			List<Customer> customers = initialData.getCustomers();
			
		}
		
		public void persistCustomer(Customer customer){
			customers.addCustomer(customer);
			
		}
		
		public void persistCustomer(List<Customer> customers){
			customers.setCustomer(customers);
		}
		
		public Customer findByID(long accountID) {
			customers;
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).getAccountID() == accountID){
					return customers.get(i); 
				}
				
			}
		       Customer nothing = new Customer();
		       return nothing; //dunno if this works right 
		}
		
		//get customer
		public List<Customer> customers(Customer c){
			
			return initialData.customers();
			
		} 
		
		public Customer customer(Customer c){
			
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).equals(c)){
				 return customers.get(i);
				}
			}
			 Customer nothing = new Customer();
		       return nothing; //dunno if this works right 
		}
		
		//update customer 
		public void updateCustomer(Customer c){
			
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).equals(c)){
				customers.set(i, c);
				}
			}
		} 
		
		
		//remove customer
		public void removeCustomer(Customer c){
			
			
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).equals(c)){
					customers.remove(i);
				}
			}
			
		}

		
		public Customer findByEmail(String email) 
		{
			for (Customer customer : initialData.getCustomers())
				if(customer.getEmail().equalsIgnoreCase(email))
					return customer;
			return null;
		}
		
		
		
		public Address findCustomerAddresses(Customer customer){

			Address address= new Address();
			initialData.getAddresses();
			
			//TODO: initialize objects, may need to reference composite objects  
		return address; 
		}
		
		public List<Card> findCustomerCards(Customer customer){
		
			initialData.get; // i probably need to come back and get composite types 
			//TODO: currently doesn't work and just returns a null card. make it work later   
			
			return card;
		}
		
}