package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.OrderRepository;

public class OrderRepositoryOffline 
	implements OrderRepository
{
	public OrderRepositoryOffline() 
	{
		// TODO Auto-generated constructor stub
	}

	public void persistOrder(Order o) 
	{
		// TODO Auto-generated method stub
		
	}

	public void persistOrders(List<Order> o) 
	{
		// TODO Auto-generated method stub
		
	}

	public Order findByID(String orderID) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getOrders() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void updateOrder(Order o) 
	{
		// TODO Auto-generated method stub
	}

	public void removeOrder(Order o) 
	{
		// TODO Auto-generated method stub
	}
}
