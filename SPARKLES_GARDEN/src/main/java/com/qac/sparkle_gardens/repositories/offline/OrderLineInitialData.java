package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;

/**
 * Bean for initial data of order line
 * @author Damien Lloyd
 *
 */
public class OrderLineInitialData 
{
	private List<OrderLine> orderLines;
	
	/**
	 * Constructs dummy data in order line
	 */
	public OrderLineInitialData()
	{
		orderLines.add(new OrderLine(new Order("OD01", 1, 10)));
	}
	
	/**
	 * Get order list
	 * @return
	 */
	public List<OrderLine> getOrderLines()
	{
		return orderLines;
	}
	
	/**
	 * Add orderline to list
	 * @param ol
	 */
	public void addOrderLine(OrderLine ol)
	{
		orderLines.add(ol);
	}
	
	/**
	 * Set list of order lines to another
	 * @param ol
	 */
	public void setOrderLines(List<OrderLine> ol)
	{
		orderLines = ol;
	}
}
