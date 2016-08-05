package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.util.OrderInitialData;

/**
 * The OrderRepositoryOffline class 
 * @author Damien Lloyd
 *
 */
public class OrderRepositoryOffline 
	implements OrderRepository
{
	@Inject
	private OrderInitialData initialData;
	
	/**
	 * Default constructor for order repository; initialises with dummy data
	 */
	public OrderRepositoryOffline() 
	{
		initialData = new OrderInitialData();
	}
	
	/**
	 * Add order to the bean
	 */
	public void persistOrder(Order o) 
	{
		initialData.addOrder(o);
	}
	
	/**
	 * Concurrently add orders to the list in the bean
	 */
	public void persistOrders(ArrayList<Order> o) 
	{
		initialData.setOrders(o);
	}
	
	/**
	 * Find order by its String id
	 * @param orderID The id of the Order
	 */
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
	
	/**
	 * Get list of orders from bean
	 */
	public ArrayList<Order> getOrders() 
	{
		return initialData.getOrders();
	}
	
	/**
	 * Remove order from the bean
	 */
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
