package com.qac.sparkle_gardens.repositories.offline;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;

public class OrderRepositoryOfflineTest 
{
	OrderRepositoryOffline repository;
	
	public void successfulPersist()
	{
		Order o = new Order();
		o.addOrderLine(new OrderLine(new Product("Great shoes", 5, 61.99), 1));
		o.addOrderLine(new OrderLine(new Product("Fun facts", 10, 8.00), 2));
		o.addOrderLine(new OrderLine(new Product("The challenge", 1, 79.99), 1));
		
		repository.persistOrder(o);
		
		assertEquals(repository.getOrder(o.getOrderID()), o);
	}
}
