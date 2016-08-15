package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.repositories.CustomerHasAddressRepository;
import com.qac.sparkle_gardens.test_data.InitialData;

/**
 * 
 * @author Tyler Deans
 * I implemented the CustomerHasAddressRepository interface Allen created
 */
@Stateless
@Default
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
	public void persistCustomerHasAddresses(List<CustomerHasAddress> c) {
		initialData.setCustomerHasAddresses(c);
	}

	/**
	 * Gets all of the CustomerHasAddresss in the repository
	 * @return
	 */
	public List<CustomerHasAddress> getCustomerHasAddresses() {
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
		List<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		for (int index = 0; index < custAddress.size(); index++) {
			
			if(custAddress.get(index).getAccountId() == C.getAccountId() && custAddress.get(index).getAddressId() == C.getAddressId() ) {
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
		List<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		for (int index = 0; index < custAddress.size(); index++) {
			
			if(custAddress.get(index).getAccountId() == c.getAccountId() && custAddress.get(index).getAddressId() == c.getAddressId() ) {
				custAddress.remove(index);
			}
		}
		initialData.setCustomerHasAddresses(custAddress);
	}


	/**
	 * Finds instances of Customer Owning Addresses by Customers.
	 * @param accountID
	 * @return
	 */
<<<<<<< HEAD
	public List<CustomerHasAddress> findByCustomerID(long customerID) {
		List<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		List<CustomerHasAddress> customerOwned = new ArrayList<CustomerHasAddress>();
=======
	public List<CustomerHasAddress> findByCustomerID(long accountID) {
		ArrayList<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		ArrayList<CustomerHasAddress> customerOwned = new ArrayList<CustomerHasAddress>();
>>>>>>> 2caba8f9bcaccf1df93b3bb549ba8e67c68fc975
		for (int index = 0; index < custAddress.size(); index++) {
			
			if(custAddress.get(index).getAccountId() == accountID) {
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
		List<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		List<CustomerHasAddress> customerOwned = new ArrayList<CustomerHasAddress>();
		for (int index = 0; index < custAddress.size(); index++) {
			
			if(custAddress.get(index).getAddressId() == AddressID) {
				customerOwned.add(custAddress.get(index));
			}
		}
		return customerOwned;
	}
	
	/**
	 * Checks if there are any customer addresses associated with an given address
	 * @return
	 */
	public boolean isCustomerId(Address address) {
		ArrayList<CustomerHasAddress> custAddress = initialData.getCustomerHasAddresses();
		
		for (int index = 0; index < custAddress.size(); index++) {
			if (custAddress.get(index).getAddressId() == address.getAddressId()) {
				return true;
			}
		}
		return false;
	}
}
