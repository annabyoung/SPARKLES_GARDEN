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
	
		public CustomerRepositoryOffline()
		{
			initialData = new InitialData();
		}
		
		public void persistCustomer(Customer customer){
			initialData.addCustomer(customer);
			
		}
		
		public void persistCustomer(List<Customer> customers){
			initialData.setCustomer(customers);
		}
		
		public Customer findByID(long accountID) {
			List<Customer> theCustomers = initialData.getCustomers();
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
		public List<Customer> getCustomers(Customer c){
			
			return initialData.getCustomers();
			
		} 
		
		public Customer getCustomer(Customer c){
			List<Customer> theCustomers = initialData.getCustomers();
			
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
			List<Customer> theCustomers = initialData.getCustomers();
			
			for (int i=0; i<theCustomers.size(); i++)
			{
				if(theCustomers.get(i).equals(c)){
				 theCustomers.set(i, c);
				}
			}
		} 
		
		
		//remove customer
		public void removeCustomer(Customer c){
			List<Customer> theCustomers = initialData.getCustomers();
			
			for (int i=0; i<theCustomers.size(); i++)
			{
				if(theCustomers.get(i).equals(c)){
					theCustomers.remove(i);
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
			Address address; 
			address= (Address) initialData.getAddresses();
			return address;
			//TODO: get compost class return addresses
		}
		
		public Card findCustomerCards(Customer customer){
			Card card;
			card = initialData.getCards().get(0); 
			return card;
			//TODO: and do this return type is wrong;  
		}

		@Override
		public void findCustomerAdresses(Customer c) {
			// TODO Auto-generated method stub
			
		}
		
}