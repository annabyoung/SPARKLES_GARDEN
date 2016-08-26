package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.*;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.test_data.InitialData;
import com.qac.sparkle_gardens.util.CreditStatus;

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
	private InitialData initialData= new InitialData();
	private List<Customer> customers = new ArrayList<>();
	List<Customer> custlist = new ArrayList<>();
		public CustomerRepositoryOffline()
		{
			initialData = new InitialData();
			
			//List<Customer> customers = initialData.getCustomers();
			
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
		
			customers.addAll(initialData.getCustomers());
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).getAccountID() == accountID){
					return customers.get(i); 
				}
				
			}
		      return null;
		      //return nothing; //dunno if this works right 
		}
		
		//get customer
		public List<Customer> customers(Customer c){
			
			return customers;
			
		} 
		@Override 
		public Customer getCustomer(Customer c){
			customers.addAll(initialData.getCustomers());
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
		public boolean updateCustomer(Customer c){
			customers.addAll(initialData.getCustomers());
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).equals(c)){
				customers.set(i, c);
				return true;
				}
			}
			return false; 
		} 
		
		
		//remove customer
		@Override 
		public boolean removeCustomer(Customer c){
			
			customers.addAll(initialData.getCustomers());
			for (int i=0; i<customers.size(); i++)
			{
				if(customers.get(i).equals(c)){
					customers.remove(i);
					return true;
				}
			}
			return false;
			
		}

		@Override
		public boolean isEmail(String email){
			Customer custlist = new Customer(1, "bob", "bob", "bob", CreditStatus.VALID, "bob", "bob");
			/*for(Customer customer : custlist){*/
				if(email.equals(custlist.getEmail()))
					return true; 
			//}
		
			return false;
		}
		
		@Override 
		public Customer findByEmail(String email) 
		{
			 custlist.addAll(initialData.getCustomers());
			for (Customer customer : custlist){
				if(customer.getEmail().equalsIgnoreCase(email))
					return customer;
			}
			return null;
		}
		
		@Override 
		public List<CustomerHasAddress> findCustomerAddresses(Customer customer){

//			List<CustomerHasAddress> composites = initialData.getCustomerHasAddresses(); // i probably need to come back and get composite types 
			List<CustomerHasAddress> addys=  new ArrayList<CustomerHasAddress>();
//						for (CustomerHasAddress addyz : composites)
						{
	//						if(addyz.getCustomerId() == customer.getAccountID())
	//						addys.add(addyz);
						}
			
						return addys;
		}
		
		@Override 
		public List<CustomerHasCard> findCustomerCards(Customer customer){
		
		List<CustomerHasCard> composites = initialData.getCusHasCards(); // i probably need to come back and get composite types 
		List<CustomerHasCard> cards=  new ArrayList<CustomerHasCard>();
					for (CustomerHasCard cardz : composites)
					{
						if(cardz.getCustomer().getAccountID() == customer.getAccountID())
						cards.add(cardz);
					}
		
					return cards;
		}
		
//		public Address findCustomerAddresses(Customer customer){
//			Address address; 
//			address= (Address) initialData.getAddresses();
//			return address;
//			//TODO: get compost class return addresses
//		}
		
		/*public Card findCustomerCards(Customer customer){
			Card card;
			card = initialData.getCards().get(0); 
			return card;
			//TODO: and do this return type is wrong;  
		}*/

		@Override
		public void findCustomerAdresses(Customer c) {
			// TODO Auto-generated method stub
		}
}