package com.qac.sparkle_gardens.entities;

/**
 * 
 * @author Damien Lloyd
 *
 */
public class OrderLine 
{
	private String orderID;
	private String serialNumber;
	
	/**
	 * Default constructor
	 */
	OrderLine()
	{
		this.orderID = "";
		this.serialNumber = "";
	}
	
	/**
	 * Create OrderLine from Product and Order
	 * @param p The product
	 * @param o The order
	 */
	OrderLine(Product p, Order o)
	{
		this.orderID = o.getOrderID();
		this.serialNumber = p.getSerialNumber();
	}
}
