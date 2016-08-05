package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Order;

public interface OrderRepository 
{
	public void persistOrder(Order o);
	
	public void persistOrders(ArrayList<Order> o);
	
	public Order get(long orderID);
	
	public ArrayList<Order> getOrders();
	
	public void removeOrder(long orderID);
}
