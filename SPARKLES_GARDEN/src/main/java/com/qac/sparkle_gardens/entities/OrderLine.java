package com.qac.sparkle_gardens.entities;

public class OrderLine 
{
	private String orderID;
	private String serialNumber;
	
	OrderLine()
	{
		this.orderID = "";
		this.serialNumber = "";
	}
	
	OrderLine(Product p, Order o)
	{
		this.orderID = o.getOrderID();
		this.serialNumber = p.getSerialNumber();
	}
}
