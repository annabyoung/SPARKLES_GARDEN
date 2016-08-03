package com.qac.sparkle_gardens.entities;

public class Order 
{
	private int orderID;
	private int quantity;
	private int priceTotal;
	
	public Order()
	{
		
	}

	public int getOrderID() 
	{
		return orderID;
	}

	public void setOrderID(int orderID) 
	{
		this.orderID = orderID;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	public int getPriceTotal() 
	{
		return priceTotal;
	}

	public void setPriceTotal(int priceTotal) 
	{
		this.priceTotal = priceTotal;
	}

}
