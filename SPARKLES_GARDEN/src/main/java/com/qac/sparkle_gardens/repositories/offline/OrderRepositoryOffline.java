package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.OrderInitialData;
import com.qac.sparkle_gardens.repositories.OrderRepository;

public class OrderRepositoryOffline 
	implements OrderRepository
{
	private OrderInitialData initialData;
	
	public OrderRepositoryOffline() 
	{
		initialData = new OrderInitialData();
	}

	public void persistOrder(Order o) 
	{
		initialData.addOrder(o);
	}

	public void persistOrders(List<Order> o) 
	{
		initialData.setOrders(o);
	}

	public Order findByID(String orderID) 
	{
		List<Order> ol = initialData.getOrders();
		Order o = null;
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).getOrderID() == orderID)
				o = ol.get(i);
		}
		return o;
	}

	public List<Order> getOrders() 
	{
		return initialData.getOrders();
	}

	public void updateOrder(Order o) 
	{
		List<Order> ol = initialData.getOrders();
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).equals(o))
				ol.set(i, o);
		}
	}

	public void removeOrder(Order o) 
	{
		List<Order> ol = initialData.getOrders();
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).equals(o))
				ol.remove(i);
		}
	}
}
