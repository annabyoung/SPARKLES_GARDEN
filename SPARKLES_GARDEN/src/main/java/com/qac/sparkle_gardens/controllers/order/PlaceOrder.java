package com.qac.sparkle_gardens.controllers.order;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.PaymentService;

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
	
	@Inject
	PaymentService pService;
	
	double totalPrice = 0;
	
	/**
	 * Place order with order ID and option to pay later
	 * @param orderID The order ID Order pertains to
	 * @param payLater Do you want to buy-now-pay-later?
	 * @return
	 */
	public String placeOrder(long orderID, boolean payLater)
	{
		if (service.isOrderEmpty(orderID))
			return "home";
		
		service.createOrder(payLater);
		service.generateInvoice(orderID);
		totalPrice = service.getTotalPrice(orderID);
		
		if (!payLater)
		{
			// financial magic
			return "home";
		}
		
		return "home";
	}
	
	/**
	 * Get the total price of the order
	 * @return The total price
	 */
	public double getTotalPrice()
	{
		return totalPrice;
	}
}
