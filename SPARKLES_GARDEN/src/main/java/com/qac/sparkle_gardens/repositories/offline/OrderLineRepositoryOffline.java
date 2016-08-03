package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.repositories.OrderLineRepository;

public class OrderLineRepositoryOffline 
	implements OrderLineRepository
{
	private OrderLineInitialData initialData;
	
	public OrderLineRepositoryOffline()
	{
		initialData = new OrderLineInitialData();
	}

	public void persistOrderLine(OrderLine ol) 
	{
		initialData.addOrderLine(ol);
	}

	public void persistOrderLines(List<OrderLine> ol) 
	{
		initialData.setOrderLines(ol);
	}

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

	public List<OrderLine> getOrderLines() 
	{
		return initialData.getOrderLines();
	}

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
