package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;

import junit.framework.TestCase;

/**
 * Order Service test
 * @author Damien Lloyd
 *
 */
public class OrderServiceTest extends TestCase 
{
	OrderService service = new OrderService();
	
	@Test
	public void checkOrderValid()
	{
		Order o = new Order();
		o.addOrderLine(new OrderLine(new Product("ABC", 10, 2.99), 1));
		
		for (OrderLine ol : o.getOrderLines())
		{
			assertTrue((ol.getQuantity() > ol.getProduct().getStockLevel()));
			assertFalse((ol.getQuantity() < 0));
		}
	}
	
	@Test
	public void ensurePricePositive()
	{
		Order o = new Order();
		o.addOrderLine(new OrderLine(new Product("ABC", 10, 2.99), 1));
		o.addOrderLine(new OrderLine(new Product("Lovely", 11, 100), 2));
		
		assertFalse(service.getTotalPrice(o.getOrderID()) < 0);
	}
	
	@Test
	public void canProductBeAdded()
	{
		Product p = new Product("Chris.. lol", 1, 0.01);
		
		assertFalse(service.addProductToBasket(p, 1));
	}
}
