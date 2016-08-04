package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;

/**
 * Bean for initial data of order line
 * @author Damien Lloyd
 *
 */
@Singleton
public class OrderLineInitialData 
{
	private ArrayList<OrderLine> orderLines;
	
	/**
	 * Constructs dummy data in order line
	 */
	public OrderLineInitialData()
	{
		orderLines.add(new OrderLine(new Order("OD01", "C001", 1, 10)));
		orderLines.add(new OrderLine(new Order("OD01", "C002", 4, 40)));
	}
	
	/**
	 * Get order list
	 * @return
	 */
	public ArrayList<OrderLine> getOrderLines()
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
	public void setOrderLines(ArrayList<OrderLine> ol)
	{
		orderLines = ol;
	}
}
