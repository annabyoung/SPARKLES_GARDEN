package com.qac.sparkle_gardens.controllers;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.services.OrderService;

/**
 * Amend an order such that the product's quantity is changed
 * @author Damien Lloyd
 *
 */
public class AmendOrder 
{
	OrderService service;
	
	public String amendOrder(long orderID, long productID, int quantity)
	{
		Order o = service.getOrder(orderID);
		
		for (int i = 0; i < o.getOrderLines().size(); i++)
		{
			if (o.getOrderLines().get(i).getProduct().getProductID() == productID)
				o.getOrderLines().get(i).setQuantity(quantity);
			
			return "orders";
		}
		return "orders";
	}
}
