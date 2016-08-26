package com.qac.sparkles_gardens.controllers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.controllers.OrderController;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.util.OrderStatus;
//import com.sparkle_gardens.sample_data.OrderSamples;
/**
public class OrderControllerTest 
{
	OrderController orderCon;
	
	@Before
	public void initialise()
	{
		orderCon = mock(OrderController.class);
	}
	
	// ***********************************************************************
	// AMEND ORDER
	
	@Test
	public void canAmend()
	{
		Order o = OrderSamples.shoes();
		
		String result = orderCon.amendOrder(o.getOrderID(), 
				o.getOrderLines().get(0).getProduct().getProductID(), 3);
		
		assertFalse(result == "order_amended");
	}
	
	@Test
	public void amendedQuantity()
	{
		Order o = OrderSamples.food();
		Product p = o.getOrderLines().get(1).getProduct();
		
		orderCon.amendOrder(o.getOrderID(), p.getProductID(), 9);
		
		assertFalse(orderCon.getQuantity() > p.getStockLevel());
	}
	
	// ##
	// ***********************************************************************
	// CANCEL ORDER
	
	@Test
	public void tryCancel()
	{
		Order o = OrderSamples.food();
		
		String result = orderCon.cancelOrder(o.getOrderID());
		
		assertFalse(result == "order_cancelled");
	}
	
	@Test
	public void cancelShipped()
	{
		Order o = OrderSamples.kinky();
		o.setOrderStatus(OrderStatus.DISPATCHED);
		
		String result = orderCon.cancelOrder(o.getOrderID());
		
		assertFalse(result == "order_not_cancelled");
	}
	
	// ##
	// ***********************************************************************
	// GENERATE INVOICE
	
	@Test
	public void testInvoice()
	{
		Order o = OrderSamples.kinky();
		
		orderCon.createInvoice(o.getOrderID());
		String result = orderCon.getInvoice();
		
		assertFalse(result == "");
	}
	
	// ##
	// ***********************************************************************
	// RETURN ORDER
		
	@Test
	public void canReturnOrder()
	{
		Order o = OrderSamples.kinky();
		
		String result = orderCon.returnOrder(o.getOrderID(), "1234", "12/12");
		
		assertFalse(result == "order_return_accepted");
	}
}
*/