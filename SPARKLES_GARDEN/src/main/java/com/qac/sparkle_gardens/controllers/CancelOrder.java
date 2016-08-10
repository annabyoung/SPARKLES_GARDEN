package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.entities.Order;

/**
 * 
 * @author Annabelle Young
 * 
 * Allows the customer to cancel an order before it has left the warehouse.
 * In case customer realizes they ordered incorrect quantity, item, or no longer desire the item before it is dispatched to them.
 *
 */
@Named (value = "cancelOrder")
@SessionScoped
public class CancelOrder 
{
	@Inject
	OrderService service;
	
	/**
	 * Take the order's ID, check that the order status is not yet dispatched or delivered
	 * 
	 * @param orderID
	 * @return
	 */
	public String cancelOrder(long orderID)
	{
		Order order = service.getOrder(orderID);
		if (service.validateOrderStatus(order)){
			if(order.isPayLater()){
				
			}
		}
		return "home";
	}
}
