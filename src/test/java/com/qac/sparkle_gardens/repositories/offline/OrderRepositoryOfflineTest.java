//package com.qac.sparkle_gardens.repositories.offline;
//
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.qac.sparkle_gardens.entities.Order;
//import com.qac.sparkle_gardens.entities.OrderLine;
//import com.qac.sparkle_gardens.repositories.OrderRepository;
//import com.sparkle_gardens.sample_data.OrderSamples;
//
//public class OrderRepositoryOfflineTest 
//{
//	OrderRepository repo;
//	
//	@Before
//	public void initialise()
//	{
//		repo = new OrderRepositoryOffline();
//	}
//	
//	@Test
//	public void successfulPersist()
//	{
//		Order o = OrderSamples.kinky();
//
//		
//		repo.persistOrder(o);
//		
//		assertEquals(repo.getOrder(o.getOrderID()), o);
//	}
//	
//	@Test
//	public void orderEmpty(Order o)
//	{
//		Order kink = OrderSamples.kinky();
//		assertNull(kink);
//		assertThat(o, is(notNullValue()));
//	}
//	
//	@Test
//	public void verifyQuantity()
//	{
//		for (Order o : OrderSamples.orders())
//		{
//			repo.persistOrder(o);
//			for (OrderLine ol : o.getOrderLines())
//			{
//				assertFalse(ol.getQuantity() == 0);
//				repo.getOrders().forEach(ord -> orderEmpty(ord));
//			}
//		}
//	}
//	
//	@After
//	public void teardown()
//	{
//		repo = null;
//	}
//	
//}
