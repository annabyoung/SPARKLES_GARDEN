package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;

public class OrderLineInitialData 
{
	private List<OrderLine> orderLines;
	
	public OrderLineInitialData()
	{
		orderLines.add(new OrderLine(new Order("OD01", 1, 10)));
	}
	
	public List<OrderLine> getOrderLines()
	{
		return orderLines;
	}
	
	public void addOrderLine(OrderLine ol)
	{
		orderLines.add(ol);
	}
	
	public void setOrderLines(List<OrderLine> ol)
	{
		orderLines = ol;
	}
}
