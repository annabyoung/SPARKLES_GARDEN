package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;
import com.sparkle_gardens.sample_data.OrderSamples;

/**
 * OrderInitialData contains initial data that will hold orders offline.
 * It allows you to add orders to a list thereof.
 * 
 * @author Damien Lloyd
 */
@Singleton
public class OrderInitialData 
{
	private List<Order> orders = new ArrayList<Order>();
	
	/**
	 * Default constructor for OrderInitialData; constructs
	 * data from relevant entities.
	 */
	public OrderInitialData()
	{
		orders.add(OrderSamples.shoes());
		orders.add(OrderSamples.kinky());
		orders.add(OrderSamples.food());
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
	public List<Order> getOrders()
	{
		return orders;
	}
	
	/**
	 * Concurrently set all orders in a list by another
	 * @param orders
	 */
	public void setOrders(List<Order> orders)
	{
		this.orders = orders;
	}
}