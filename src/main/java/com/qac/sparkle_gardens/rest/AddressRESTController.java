package com.qac.sparkle_gardens.rest;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.services.AddressService;

/**
 * 
 * @author Tyler
 *
 * This controller creates, deletes, updates, and retrieves addresses
 */

@Path (value = "/")
@RequestScoped
public class AddressRESTController {
	@Inject private AddressService addService;
	
	@POST
	@Consumes ("text/plain")
	@Path (value = "new_address")
	public void createAddress(Customer customer, @FormParam("buildingNum")String buildingNum, @FormParam("addressLine1") String addressLine1, @FormParam("city") String city, @FormParam("county") String county, @FormParam("country") String country, @FormParam("postCode") String postCode, @FormParam("addressType") String addressType) {
		addService.createAddress(customer, buildingNum, addressLine1, city, county, country, postCode, addressType);
	}
	
	@POST
	@Consumes ("text/plain")
	@Path (value = "new_address")
	public void createAddress(Customer customer, @FormParam("buildingNum")String buildingNum, @FormParam("addressLine1") String addressLine1, @FormParam("addressLine2") String addressLine2, @FormParam("city") String city, @FormParam("county") String county, @FormParam("country") String country, @FormParam("postCode") String postCode, @FormParam("addressType") String addressType) {
		addService.createAddress(customer, buildingNum, addressLine1, addressLine2, city, county, country, postCode, addressType);
	}
	
	@POST
	@Consumes ("text/plain")
	@Path (value = "new_address")
	public void createAddress(Customer customer, Address newAddress) {
		addService.createAddress(customer, newAddress);
	}
	
	@GET
	@Produces ({MediaType.APPLICATION_JSON})
	@Path (value = "address")
	public List<Address> getAddress(Customer customer) {
		return addService.getAddress(customer.getAccountID());
	}
	
	public void updateAddress(Customer customer, Address address) {
		addService.updateAddress(customer, address);
	}
	
	/* Overloaded delete address method because
	 * a customer and address object can be passed in or 
	 * their IDs respectively.
	 * 
	 */
	public void deleteAddress(Customer customer, Address address) {
		addService.deleteAddress(customer, address);
	}
	
	public void deleteAddress(long acctId, long addressId) {
		addService.deleteAddress(acctId, addressId);
	}
	
}
