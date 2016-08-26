package com.qac.sparkle_gardens.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qac.sparkle_gardens.controllers.CurrentUserController;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.services.CustomerService;
import com.qac.sparkle_gardens.services.OrderService;

@Path("/orderrest")
@RequestScoped
public class OrderRESTController {

	@Inject private Logger log;
	@Inject private OrderService orderService;
	@Inject private CustomerService customerService;
	@Inject private CurrentUserController currentUser;
	
	@GET
	@Path("customerOrders")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Order> getCustomerOrders(){
		log.info("/orderrest/customerOrders reached");
		return orderService.getOrdersByCustomer(customerService.getCustomerByID(currentUser.getCustomerId()));
	}
}
