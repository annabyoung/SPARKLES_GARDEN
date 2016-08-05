package com.qac.sparkle_gardens.util;

import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;

/**
 * OrderInitialData contains initial data that will hold orders offline.
 * It allows you to add orders to a list thereof.
 * 
 * @author Damien Lloyd
 *
 */
@Singleton
public class OrderInitialData 
{
	private ArrayList<Order> orders;
	
	/**
	 * Default constructor for OrderInitialData; constructs
	 * data from relevant entities.
	 */
	public OrderInitialData()
	{
		// Create order with orderID & customerID
		orders.add(new Order(1, 1)); 
		orders.add(new Order(2, 2));
		orders.add(new Order(3, 3));
		orders.add(new Order(4, 4));
		orders.add(new Order(5, 5));
		
		// Add order line to order by productID, quantity & price
		orders.get(0).addOrderLine(new OrderLine(30, 3, 30));
		orders.get(0).addOrderLine(new OrderLine(29, 2, 12));
		
		orders.get(1).addOrderLine(new OrderLine(1337, 1, 100));
		
		orders.get(2).addOrderLine(new OrderLine(193, 2, 50));
		
		orders.get(3).addOrderLine(new OrderLine(50, 10, 600));
		orders.get(3).addOrderLine(new OrderLine(99, 2, 40));
		orders.get(3).addOrderLine(new OrderLine(9202, 12, 2313));
		
		orders.get(4).addOrderLine(new OrderLine(34, 1, 200));
	}
	
	/**
	 * Add an order to list of orders
	 * @param o
	 */
	public void addOrder(Order o)
	{
		this.orders.add(o);
	}
	
	/**
	 * Get list of orders
	 * @return orders
	 */
	public ArrayList<Order> getOrders()
	{
		return orders;
	}
	
	/**
	 * Concurrently set all orders in a list by another
	 * @param orders
	 */
	public void setOrders(ArrayList<Order> orders)
	{
		this.orders = orders;
	}
}