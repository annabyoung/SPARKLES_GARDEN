package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.OrderLine;

public interface OrderLineRepository 
{
	public void persistOrderLine(OrderLine ol);
	public void persistOrderLines(ArrayList<OrderLine> ol);
	public OrderLine findByID(String orderID);
	public ArrayList<OrderLine> getOrderLines();
	public void updateOrderLine(String orderID);
	public void removeOrderLine(String orderID);
}
