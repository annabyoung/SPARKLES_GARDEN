package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.test_data.InitialData;

/**
 * The OrderRepositoryOffline class 
 * @author Damien Lloyd
 *
 */
@Stateless
@Default
public class OrderRepositoryOffline 
	implements OrderRepository
{
	@Inject
	private InitialData initialData;

	public OrderRepositoryOffline() 
	{
		initialData = new InitialData();
	}
	
	public void persistOrder(Order o) 
	{
		initialData.addOrder(o);
	}
	
	public void persistOrders(List<Order> o) 
	{
		initialData.setOrders(o);
	}
	
	public Order getOrder(long orderID) 
	{
		List<Order> ol = initialData.getOrders();
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).getOrderID() == orderID)
				return ol.get(i);
		}
		return null;
	}
	
	public List<Order> getOrders() 
	{
		return initialData.getOrders();
	}
	
	public void removeOrder(long orderID) 
	{
		List<Order> ol = initialData.getOrders();
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).getOrderID() == orderID)
				ol.remove(i);
		}
	}
}
