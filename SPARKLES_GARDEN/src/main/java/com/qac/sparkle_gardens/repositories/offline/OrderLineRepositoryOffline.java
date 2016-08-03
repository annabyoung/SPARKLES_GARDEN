package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.repositories.OrderLineRepository;

public class OrderLineRepositoryOffline 
	implements OrderLineRepository
{
	private OrderLineInitialData initialData;
	
	/**
	 * Default constructor
	 */
	public OrderLineRepositoryOffline()
	{
		initialData = new OrderLineInitialData();
	}
	
	/**
	 * Add orderline to order line data. Persists beyond SLC
	 */
	public void persistOrderLine(OrderLine ol) 
	{
		initialData.addOrderLine(ol);
	}
	
	/**
	 * Add list of orderlines to current list
	 */
	public void persistOrderLines(List<OrderLine> ol) 
	{
		initialData.setOrderLines(ol);
	}
	
	/**
	 * Find orderline by the order ID
	 * @param ID of the order
	 */
	public OrderLine findByID(String orderID) 
	{
		List<OrderLine> ol = initialData.getOrderLines();
		OrderLine o = null;
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).getOrder().getOrderID() == orderID)
				o = ol.get(i);
		}
		return o;
	}
	
	/**
	 * Get order lines list
	 */
	public List<OrderLine> getOrderLines() 
	{
		return initialData.getOrderLines();
	}
	
	/**
	 * Update orderline in list based on the ol object
	 * Warning: expensive operation
	 */
	public void updateOrderLine(OrderLine ol) 
	{
		List<OrderLine> _ol = initialData.getOrderLines();
		OrderLine o = null;
		
		for (int i = 0; i < _ol.size(); i++)
		{
			if (_ol.get(i).getOrder().equals(_ol))
				o = _ol.set(i, o);
		}
	}
	
	/**
	 * Removes orderline from list
	 */
	public void removeOrderLine(OrderLine ol)
	{
		List<OrderLine> _ol = initialData.getOrderLines();
		OrderLine o = null;
		
		for (int i = 0; i < _ol.size(); i++)
		{
			if (_ol.get(i).getOrder().equals(_ol))
				o = _ol.remove(i);
		}
	}
}
