package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.util.InitialData;

/**
 * The OrderRepositoryOffline class 
 * @author Damien Lloyd
 *
 */
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
	
	public void persistOrders(ArrayList<Order> o) 
	{
		initialData.setOrders(o);
	}
	
	public Order getOrder(long orderID) 
	{
		ArrayList<Order> ol = initialData.getOrders();
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).getOrderID() == orderID)
				return ol.get(i);
		}
		return null;
	}
	
	public ArrayList<Order> getOrders() 
	{
		return initialData.getOrders();
	}
	
	public void removeOrder(long orderID) 
	{
		ArrayList<Order> ol = initialData.getOrders();
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).getOrderID() == orderID)
				ol.remove(i);
		}
	}
}
