package deprecated;

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
 *deprecated in favor of InitialData (8/9/16)
 */
@Singleton 
@Deprecated
public class CustomerInitialData {
	
		private ArrayList<Customer> customers = new ArrayList<Customer>();
			
		public CustomerInitialData(){ 
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
