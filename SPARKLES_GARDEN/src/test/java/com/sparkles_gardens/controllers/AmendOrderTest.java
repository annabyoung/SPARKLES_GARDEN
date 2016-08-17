package com.sparkles_gardens.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.controllers.AmendOrder;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.repositories.offline.OrderRepositoryOffline;
import com.qac.sparkle_gardens.util.OrderStatus;
import com.sparkle_gardens.sample_data.OrderSamples;

public class AmendOrderTest 
{
	AmendOrder amendment;
	
	@Before
	public void initialise()
	{
		AmendOrder amendment = new AmendOrder();
	}
	
	@Test
	public void canAmend()
	{
		Order o = OrderSamples.shoes();
		
		String result = amendment.amendOrder(o.getOrderID(), 
				o.getOrderLines().get(0).getProduct().getProductID(), 3);
		
		assertTrue(result == "order_amended");
	}
}
