package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.OrderRepository;

public class OrderRepositoryOffline 
	implements OrderRepository
{
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
	public Order findByID(String orderID) 
	{
		ArrayList<Order> ol = initialData.getOrders();
		Order o = null;
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).getOrderID() == orderID)
				o = ol.get(i);
		}
		return o;
	}
	
	/**
	 * Get list of orders from bean
	 */
	public ArrayList<Order> getOrders() 
	{
		return initialData.getOrders();
	}
	
	/** 
	 * Update order in the bean
	 */
	public void updateOrder(Order o) 
	{
		ArrayList<Order> ol = initialData.getOrders();
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).equals(o))
				ol.set(i, o);
		}
	}
	
	/**
	 * Remove order from the bean
	 */
	public void removeOrder(Order o) 
	{
		ArrayList<Order> ol = initialData.getOrders();
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).equals(o))
				ol.remove(i);
		}
	}
}
