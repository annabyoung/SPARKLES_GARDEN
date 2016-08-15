package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.RequestScoped;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.util.OrderStatus;

/**
 * Amend an order such that the product's quantity is changed
 * @author Damien Lloyd
 *
 */
@RequestScoped
public class AmendOrder 
{
	OrderService service;
	
	@SuppressWarnings("unused")
	public String amendOrder(long orderID, long productID, int quantity)
	{
		Order o = service.getOrder(orderID);
		
		if (o.getOrderStatus() == OrderStatus.DISPATCHED)
			return "orders";
		
		for (int i = 0; i < o.getOrderLines().size(); i++)
		{
			if (o.getOrderLines().get(i).getProduct().getProductID() == productID)
				o.getOrderLines().get(i).setQuantity(quantity);
			
			return "orders";
		}
		return "orders";
	}
}
