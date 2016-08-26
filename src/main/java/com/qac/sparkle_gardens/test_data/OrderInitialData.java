package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.util.CreditStatus;

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
	private Customer customer1 = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
	private Customer customer2 = new Customer();
	/**
	 * Default constructor for OrderInitialData; constructs
	 * data from relevant entities.
	 */
	public OrderInitialData()
	{
		orders.add(new Order(3, customer1));
		orders.add(new Order(6, customer2));
		
	}
	
	/**
	 * Add an order to list of orders
	 * @param o
	 */
	public void addOrder(Order order)
	{
		orders.add(order);
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