package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Order;

/**
 * OrderInitialData contains initial data that will hold orders offline.
 * It allows you to add orders to a list thereof
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
		orders.add(new Order("OD01", "C001", 4, 40));
		orders.add(new Order("OD02", "C002", 1, 100));
		orders.add(new Order("OD03", "C003", 10, 60));
		orders.add(new Order("OD04", "C001", 5, 37));
		orders.add(new Order("OD05", "C003", 2, 10));
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