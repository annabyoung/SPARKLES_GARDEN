package com.qac.sparkle_gardens.controllers.order;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.services.OrderService;

@Named (value = "placeOrder")
@SessionScoped
public class PlaceOrder 
{
	private long orderID = 0;
	
	@Inject
	OrderService service;
	
	public String placeOrder()
	{
		
		return "home";
	}
}
