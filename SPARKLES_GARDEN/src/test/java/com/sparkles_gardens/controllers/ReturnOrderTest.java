package com.sparkles_gardens.controllers;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.util.OrderStatus;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing ReturnOrder controller
 * @author Damien Lloyd
 *
 */
public class ReturnOrderTest
{
	OrderService service = new OrderService();
	
	@Test
	public void returnOK()
	{
		Order o = new Order();
		o.setOrderStatus(OrderStatus.RETURNED);
		
		assertFalse(service.isEligibleForRefund(o.getOrderID()));
		assertTrue(!o.isPayLater());
	}
}
