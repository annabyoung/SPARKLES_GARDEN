package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.entities.Order;

/**
 * Cancel an order
 * @author Damien Lloyd
 *
 */
@Named (value = "cancelOrder")
@SessionScoped
public class CancelOrder 
{
	@Inject
	OrderService service;
	
	/**
	 * Take the order's ID, check that the order status is not yet dispatched
	 * 
	 * @param orderID
	 * @return
	 */
	public String cancelOrder(long orderID)
	{
		Order order = service.getOrder(orderID);
		
		return "home";
	}
}
