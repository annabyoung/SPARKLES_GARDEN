package com.qac.sparkle_gardens.controllers.order;

import javax.inject.Inject;

import com.qac.sparkle_gardens.services.OrderService;

public class CancelOrder 
{
	@Inject
	OrderService service;
	
	public String cancelOrder(long orderID)
	{
		return "home";
	}
}
