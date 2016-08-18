package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;
import com.sparkle_gardens.sample_data.OrderSamples;

import junit.framework.TestCase;

/**
 * Order Service test
 * @author Damien Lloyd
 *
 */
public class OrderServiceTest
{
	OrderService service;
	Order order;
	
	@Before
	public void initialise()
	{
		service = new OrderService();
		order = new Order();
	}
	
	@Test
	public void checkOrderValid()
	{
		order.addOrderLine(new OrderLine(new Product("ABC", 10, 2.99), 1));
		/*
		Order o = new Order();
		o.addOrderLine(new OrderLine(new Product("ABC", 10, 2.99), 1));
		
		for (OrderLine ol : o.getOrderLines())
		{
			assertTrue((ol.getQuantity() > ol.getProduct().getStockLevel()));
			assertFalse((ol.getQuantity() < 0));
		}
		*/
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
	public void isInvoiceNull()
	{
		//Order o = OrderSamples.techies();
		
		order = OrderSamples.techies();
		
		String invoice = service.generateInvoice(order.getOrderID());
		
		assertNotNull(invoice);
	}
	
	@Test
	public void productBasketOps()
	{
		Product p = new Product("Apple", 10, 0.30);
		//Product q = new Product("Laptop", 15, 499.00);
		
		boolean added = service.addProductToBasket(p, 2);
		assertFalse(added);
		/*
		boolean removed = service.removeItemFromBasket(p);
		assertTrue(removed);
		
		service.addProductToBasket(q, 1);
		
		boolean empty = service.isBasketEmpty();
		assertFalse(empty);
		
		boolean clear = service.clearBasket();
		assertTrue(clear);
		*/
	}
	
	@Test
	public void orderCreated()
	{
		Product a = new Product("Toothbrush", 20, 2.99);
		//Product b = new Product("Cup", 30, 1.00);
		
		service.addProductToBasket(a, 2);
		//service.addProductToBasket(b, 3);
		
		boolean result = service.createOrder(true);
		
		assertTrue(result);
	}
	
	@Test
	public void validatedOrderStatus()
	{
		Order o = OrderSamples.shoes();
		
		boolean result = service.validateOrderStatus(o);
		
		assertTrue(result);
	}
	
	/**
	 * @author Annabelle Young
	 * Set variables to null so they can be re-implemented
	 */
	@After
	public void teardown()
	{
		service = null;
		order = null;
	}
	
}
