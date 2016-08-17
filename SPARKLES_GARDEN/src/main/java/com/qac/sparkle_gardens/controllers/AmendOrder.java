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
	
	long orderID, productID;
	int quantity;
	
	@SuppressWarnings("unused")
	public String amendOrder(long orderID, long productID, int quantity)
	{
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
		
		Order o = service.getOrder(orderID);
		
		if (o.getOrderStatus() == OrderStatus.DISPATCHED)
			return "order_not_amended";
		
		for (int i = 0; i < o.getOrderLines().size(); i++)
		{
			if (o.getOrderLines().get(i).getProduct().getProductID() == productID)
				o.getOrderLines().get(i).setQuantity(quantity);
			
			return "order_amended";
		}
		return "order_not_amended";
	}

	public long getOrderID() {
		return orderID;
	}

	public long getProductID() {
		return productID;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public OrderService getService() {
		return service;
	}
}
