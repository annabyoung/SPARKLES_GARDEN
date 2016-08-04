package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.repositories.OrderLineRepository;
import javax.inject.*;

public class OrderLineRepositoryOffline 
	implements OrderLineRepository
{
	@Inject
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
	public void persistOrderLines(ArrayList<OrderLine> ol) 
	{
		initialData.setOrderLines(ol);
	}
	
	/**
	 * Find orderline by the order ID
	 * @param ID of the order
	 */
	public OrderLine findByID(String orderID) 
	{
		ArrayList<OrderLine> ol = initialData.getOrderLines();
		OrderLine o = null;
		
		for (int i = 0; i < ol.size(); i++)
		{
			if (ol.get(i).getOrderID() == orderID)
				o = ol.get(i);
		}
		return o;
	}
	
	/**
	 * Get order lines list
	 */
	public ArrayList<OrderLine> getOrderLines() 
	{
		return initialData.getOrderLines();
	}
	
	/**
	 * Update orderline in list based on the order ID
	 * @param The order ID of the order to remove
	 */
	public void updateOrderLine(String orderID) 
	{
		ArrayList<OrderLine> _ol = initialData.getOrderLines();
		
		for (int i = 0; i < _ol.size(); i++)
		{
			if (_ol.get(i).getOrderID() == orderID)
				_ol.set(i, this.findByID(orderID));
		}
	}
	
	/**
	 * Removes orderline from list by the orderID
	 * @param The order ID of the order to remove
	 */
	public void removeOrderLine(String orderID)
	{
		ArrayList<OrderLine> _ol = initialData.getOrderLines();
		
		for (int i = 0; i < _ol.size(); i++)
		{
			if (_ol.get(i).getOrderID() == orderID)
				_ol.remove(i);
		}
	}
}
