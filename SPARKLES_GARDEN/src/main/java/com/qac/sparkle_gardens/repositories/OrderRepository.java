package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Order;

/**
 * Interface for creating a repository of orders that 
 * extends beyond the lifecycle of an application.
 * 
 * @author Damien Lloyd
 *
 */
public interface OrderRepository 
{
	/**
	 * Add order such that it persists beyond the
	 * scope of the software. Effectively storing the order.
	 * @param o
	 */
	public void persistOrder(Order o);
	
	/**
	 * Same as persistOrder(Order o), except it persists
	 * an entire list of orders.
	 * @param o
	 */
	public void persistOrders(ArrayList<Order> o);
	
	/**
	 * Get the Order stored by its orderID
	 * @param orderID
	 * @return Order related to orderID
	 */
	public Order getOrder(long orderID);
	
	/**
	 * Get all the Orders stored.
	 * @return
	 */
	public ArrayList<Order> getOrders();
	
	/**
	 * Remove the Order by its ID
	 * @param orderID
	 */
	public void removeOrder(long orderID);
}
