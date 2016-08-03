package com.qac.sparkle_gardens.repositories;

import java.util.List;

import com.qac.sparkle_gardens.entities.OrderLine;

public interface OrderLineRepository 
{
	public void persistOrderLine(OrderLine ol);
	public void persistOrderLines(List<OrderLine> ol);
	public OrderLine findByID(String orderID);
	public List<OrderLine> getOrderLines();
	public void updateOrderLine(OrderLine ol);
	public void removeOrderLine(OrderLine ol);
}
