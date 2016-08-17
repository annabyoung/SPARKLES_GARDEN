package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.*;


import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
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
		
		@Override 
		public void persistCustomer(Customer customer){
			customers.add(customer);
			
		}
		
		@Override 
		public void persistCustomer(List<Customer> customer){
			customers.addAll(customer);
		}
		
		@Override 
		public Customer findByID(long accountID) {
		
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
			
			return customers;
			
		} 
		@Override 
		public Customer getCustomer(Customer c){
			
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
		@Override 
		public void updateCustomer(Customer c){
			
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).equals(c)){
				customers.set(i, c);
				}
			}
		} 
		
		
		//remove customer
		@Override 
		public void removeCustomer(Customer c){
			
			
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).equals(c)){
					customers.remove(i);
				}
			}
			
		}

		@Override 
		public Customer findByEmail(String email) 
		{
			for (Customer customer : initialData.getCustomers())
				if(customer.getEmail().equalsIgnoreCase(email))
					return customer;
			return null;
		}
		
		
		@Override 
		public List<CustomerHasAddress> findCustomerAddresses(Customer customer){

			List<CustomerHasAddress> composites = initialData.getCustomerHasAddresses(); // i probably need to come back and get composite types 
			List<CustomerHasAddress> addys=  new ArrayList<CustomerHasAddress>();
						for (CustomerHasAddress addyz : composites)
						{
							if(addyz.getCustomerId() == customer.getAccountID())
							addys.add(addyz);
						}
			
						return addys;
		}
		
		@Override 
		public List<CustomerHasCard> findCustomerCards(Customer customer){
		
		List<CustomerHasCard> composites = initialData.getCusHasCards(); // i probably need to come back and get composite types 
		List<CustomerHasCard> cards=  new ArrayList<CustomerHasCard>();
					for (CustomerHasCard cardz : composites)
					{
						if(cardz.getCustomerId() == customer.getAccountID())
						cards.add(cardz);
					}
		
					return cards;
		}

		
		
}