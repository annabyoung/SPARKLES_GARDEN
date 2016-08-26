package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.test_data.OrderInitialData;

/**
 * The OrderRepositoryOffline class 
 * @author Damien Lloyd
 *
 */
@Stateless
@Default
public class OrderRepositoryOffline 
	implements OrderRepository
{
	@Inject
	private OrderInitialData initialData = new OrderInitialData();
	
	public void persistOrder(Order order) 
	{
		
		initialData.addOrder(order);
	}
	
	public void persistOrders(List<Order> orders) 
	{	
		initialData.setOrders(orders);
	}
	
	public Order getOrder(long orderID) 
	{
		List<Order> ol = initialData.getOrders();
		
		for (Order order: ol){
			if (order.getOrderID() == orderID){
				return order;
			}
		}
		return null;
	}
	
	public List<Order> getOrders() 
	{
		return initialData.getOrders();
	}
	
	public void updateOrder(Order order) {
		List<Order> orders = initialData.getOrders();
		for (int index = 0; index < orders.size(); index++) {
			if (order.getOrderID() == orders.get(index).getOrderID()) {
				orders.set(index, order);
			}
		}
		initialData.setOrders(orders);
	}
	
	public void removeOrder(long orderID) 
	{
		List<Order> ol = initialData.getOrders();
		for (Order order: ol){
			if (order.getOrderID() == orderID){
				 ol.remove(order);
			}
		}
		initialData.setOrders(ol);
	}
}
