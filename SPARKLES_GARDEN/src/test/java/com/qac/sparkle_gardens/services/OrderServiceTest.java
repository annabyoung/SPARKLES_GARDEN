package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;

import junit.framework.TestCase;

public class OrderServiceTest extends TestCase 
{
	@Test
	public void checkOrderValid()
	{
		Order o = new Order();
		o.addOrderLine(new OrderLine(new Product("ABC", 10, 2.99), 1));
		
		for (OrderLine ol : o.getOrderLines())
		{
			assertTrue((ol.getQuantity() > ol.getProduct().getStockLevel()));
			assertTrue((ol.getQuantity() < 0));
		}
	}
}
