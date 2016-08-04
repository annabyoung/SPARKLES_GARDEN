package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Order;

public interface OrderRepository 
{
	public void persistOrder(Order o);
	public void persistOrders(ArrayList<Order> o);
	public Order findByID(String orderID);
	public ArrayList<Order> getOrders();
	public void updateOrder(Order o);
	public void removeOrder(Order o);
}
