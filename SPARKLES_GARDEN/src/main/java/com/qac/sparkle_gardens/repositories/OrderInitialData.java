package com.qac.sparkle_gardens.repositories;

import java.util.List;
import com.qac.sparkle_gardens.entities.Order;

public class OrderInitialData 
{
	private List<Order> orders;
	
	public OrderInitialData()
	{
		orders.add(new Order("OD01", 4, 40));
		orders.add(new Order("OD02", 1, 100));
		orders.add(new Order("OD03", 10, 60));
		orders.add(new Order("OD04", 5, 37));
		orders.add(new Order("OD05", 2, 10));
	}
	
	public void addOrder(Order o)
	{
		this.orders.add(o);
	}
	
	public List<Order> getOrders()
	{
		return orders;
	}
	
	public void setOrders(List<Order> orders)
	{
		this.orders = orders;
	}
}