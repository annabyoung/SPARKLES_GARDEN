package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.repositories.OrderLineRepository;
import com.qac.sparkle_gardens.util.MethodAuthor;
import com.qac.sparkle_gardens.util.OrderLineInitialData;

import javax.inject.*;

/**
 * This class contains initial data and provides an interface to adding order lines, etc
 * @author Damien Lloyd
 *
 */
@Deprecated
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
		
		for (int i = 0; i < ol.size(); i++)
		{
			//if (ol.get(i).getOrderID() == orderID) 
			//	return ol.get(i);
		}
		return null;
	}
	
	/**
	 * Get order lines list
	 */
	public ArrayList<OrderLine> getOrderLines() 
	{
		return initialData.getOrderLines();
	}
	
	/**
	 * Update orderline in list based on the ol object
	 */
	@MethodAuthor(author="Damien")
	public void updateOrderLine(String orderID) 
	{
		ArrayList<OrderLine> _ol = initialData.getOrderLines();
		OrderLine o = null;
		
		for (int i = 0; i < _ol.size(); i++)
		{
			//if (_ol.get(i).getOrderID().equals(_ol)) 
			//{
			//	o = _ol.set(i, o);
				//break;
			//}
		}
	}
	
	/**
	 * Removes orderline from list
	 */
	@MethodAuthor(author="Damien")
	public void removeOrderLine(String orderID)
	{
		ArrayList<OrderLine> _ol = initialData.getOrderLines();
		
		for (int i = 0; i < _ol.size(); i++)
		{
			//if (_ol.get(i).getOrderID().equals(_ol)) 
			//{
			//	_ol.remove(i);
			//	break;
			//}
		}
	}
}
