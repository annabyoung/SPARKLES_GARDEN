package com.qac.sparkle_gardens.repositories.offline;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.sparkle_gardens.sample_data.OrderSamples;

public class OrderRepositoryOfflineTest 
{
	//OrderRepositoryOffline repository;
	OrderRepository or;
	
	@Before
	public void initialise()
	{
		//repository = new OrderRepositoryOffline();
		or = new OrderRepositoryOffline();
	}
	
	@Test
	public void successfulPersist()
	{
		Order o = OrderSamples.kinky();

		
		or.persistOrder(o);
		
		assertEquals(or.getOrder(o.getOrderID()), o);
	}
	
	@Test
	public void orderEmpty()
	{
		Order o = OrderSamples.food();
		
		assertThat(o, is(notNullValue()));
	}
	
	@Test
	public void verifyQuantity()
	{
		for (Order o : OrderSamples.orders())
		{
			for (OrderLine ol : o.getOrderLines())
			{
				assertFalse(ol.getQuantity() == 0);
			}
		}
	}
	
	@After
	public void teardown(){
	//	repository = null;
		or = null;
	}
	
}
