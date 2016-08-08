package com.qac.sparkle_gardens.controllers.order;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;

@Named (value = "placeOrder")
@SessionScoped
public class PlaceOrder 
{
	private long orderID = 0;
	
	@Inject
	OrderService service;
	
	@Inject
	ProductService pService;
	
	long customerID;
	
	public String placeOrder()
	{
		service.createOrder(customerID);
		
		return "home";
	}

	public long getCustomerID() 
	{
		return customerID;
	}

	public void setCustomerID(long customerID) 
	{
		this.customerID = customerID;
	}
}
