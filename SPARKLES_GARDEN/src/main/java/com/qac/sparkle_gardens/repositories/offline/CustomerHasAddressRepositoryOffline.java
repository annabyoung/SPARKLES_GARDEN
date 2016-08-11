package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.repositories.CustomerHasAddressRepository;
import com.qac.sparkle_gardens.util.InitialData;

/**
 * 
 * @author Tyler Deans
 * I implemented the CustomerHasAddressRepository interface Allen created
 */
public class CustomerHasAddressRepositoryOffline implements CustomerHasAddressRepository {
	@Inject private InitialData initialData;
	
	/**
	 * Keeps CustomerHasAddresss in database.
	 * @param CustomerHasAddress c
	 */
	public void persistCustomerHasAddress(CustomerHasAddress c) {
		initialData.addCustomerHasAddress(c);
	}

	/**
	 * Keeps ArrayList of CustomerHasAddresss.
	 * @param ArrayList<CustomerHasAddress> c
	 */
	public void persistCustomerHasAddresses(ArrayList<CustomerHasAddress> c) {
		initialData.setCustomerHasAddresses(c);
	}

	/**
	 * Gets all of the CustomerHasAddresss in the repository
	 * @return
	 */
	public ArrayList<CustomerHasAddress> getCustomerHasAddresses() {
		return initialData.getCustomerHasAddresses();
	}
	
	/**
	 * Adds a new CustomerHasAddress into repository. Might be useless because persist CustomerHasAddress.
	 * @param c
	 */
	public void addCustomerHasAddress(CustomerHasAddress c) {
		initialData.addCustomerHasAddress(c);
	}

	/**
	 * Updates a CustomerHasAddress.
	 * @param C
	 */
	public void updateCustomerHasAddress(CustomerHasAddress C) {
		ArrayList<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		for (int index = 0; index < custAddress.size(); index++) {
			
			if(custAddress.get(index).getCustomerId() == C.getCustomerId() && custAddress.get(index).getAddressId() == C.getAddressId() ) {
				custAddress.set(index, C);
			}
		}
		initialData.setCustomerHasAddresses(custAddress);
	}

	/**
	 * Removes a CustomerHasAddress.
	 * @param c
	 */
	public void removeCustomerHasAddress(CustomerHasAddress c) {
		ArrayList<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		for (int index = 0; index < custAddress.size(); index++) {
			
			if(custAddress.get(index).getCustomerId() == c.getCustomerId() && custAddress.get(index).getAddressId() == c.getAddressId() ) {
				custAddress.remove(index);
			}
		}
		initialData.setCustomerHasAddresses(custAddress);
	}


	/**
	 * Finds instances of Customer Owning Addresses by Customers.
	 * @param customerID
	 * @return
	 */
	public List<CustomerHasAddress> findByCustomerID(long customerID) {
		ArrayList<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		ArrayList<CustomerHasAddress> customerOwned = new ArrayList<CustomerHasAddress>();
		for (int index = 0; index < custAddress.size(); index++) {
			
			if(custAddress.get(index).getCustomerId() == customerID) {
				customerOwned.add(custAddress.get(index));
			}
		}
		return customerOwned;
	}
	
	/**
	 * Finds instances of Customer Owning Addresses by Address.
	 * @param AddressID
	 * @return
	 */
	public List<CustomerHasAddress> findByAddressID(long AddressID) {
		ArrayList<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		ArrayList<CustomerHasAddress> customerOwned = new ArrayList<CustomerHasAddress>();
		for (int index = 0; index < custAddress.size(); index++) {
			
			if(custAddress.get(index).getAddressId() == AddressID) {
				customerOwned.add(custAddress.get(index));
			}
		}
		return customerOwned;
	}
}