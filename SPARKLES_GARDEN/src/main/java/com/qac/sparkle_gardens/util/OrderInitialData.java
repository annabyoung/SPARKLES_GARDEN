package com.qac.sparkle_gardens.util;

import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;

/**
 * OrderInitialData contains initial data that will hold orders offline.
 * It allows you to add orders to a list thereof.
 * 
 * deprecated in favour of InitialData (9/8/16)
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
		orders.add(new Order(1, new Customer())); 
		orders.add(new Order(2, new Customer()));
		orders.add(new Order(3, new Customer()));
		orders.add(new Order(4, new Customer()));
		orders.add(new Order(5, new Customer()));
		
		// Add order line to order by productID, quantity & price
		orders.get(0).addOrderLine(new OrderLine(new Product("Pretty trainers", 3, 30), 3));
		orders.get(0).addOrderLine(new OrderLine(new Product("Funky gnome", 5, 12), 2));
		
		orders.get(1).addOrderLine(new OrderLine(new Product("Awesome boots", 3, 100), 1));
		
		orders.get(2).addOrderLine(new OrderLine(new Product("Amazing watch", 1, 50), 2));
		
		orders.get(3).addOrderLine(new OrderLine(new Product("Superduper gaming rig!", 2, 600), 10));
		orders.get(3).addOrderLine(new OrderLine(new Product("Great socks!", 10, 40), 2));
		orders.get(3).addOrderLine(new OrderLine(new Product("Allen's Mac", 1, 231), 12));
		
		orders.get(4).addOrderLine(new OrderLine(new Product("Impressive glasses", 2, 200), 1));
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