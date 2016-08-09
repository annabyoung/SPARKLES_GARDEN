package com.qac.sparkle_gardens.controllers.order;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;

/**
 * 
 * @author Damien Lloyd
 *
 */
@Named (value = "placeOrder")
@SessionScoped
public class PlaceOrder 
{	
	@Inject
	OrderService service;
	
	double totalPrice = 0;
	
	/**
	 * Place order with order ID
	 * @param orderID
	 * @return
	 */
	public String placeOrder(long orderID, boolean payLater)
	{
		if (service.isOrderEmpty(orderID))
			return "home";
		
		service.createOrder(payLater);
		service.generateInvoice(orderID);
		totalPrice = service.getTotalPrice(orderID);
		
		return "home";
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}
}
