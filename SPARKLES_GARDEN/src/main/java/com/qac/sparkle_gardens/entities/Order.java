package com.qac.sparkle_gardens.entities;

/**
 * 
 * @author Damien Lloyd
 *
 */
public class Order 
{
	private String orderID;
	private int quantity;
	private int priceTotal;
	
	/**
	 * Default constructor
	 */
	public Order()
	{
		
	}
	
	/**
	 * Get the order ID
	 * @return orderID
	 */
	public String getOrderID() 
	{
		return orderID;
	}
	
	/**
	 * Set the order ID
	 * @param orderID
	 */
	public void setOrderID(String orderID) 
	{
		this.orderID = orderID;
	}
	
	/**
	 * Get number of items in order
	 * @return quantity
	 */
	public int getQuantity() 
	{
		return quantity;
	}
	
	/**
	 * Set number of items in order
	 * @param quantity
	 */
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	/**
	 * Get total price from products in order
	 * @return priceTotal
	 */
	public int getPriceTotal() 
	{
		return priceTotal;
	}
	
	/**
	 * Set the price 
	 * @param priceTotal
	 */
	public void setPriceTotal(int priceTotal) 
	{
		this.priceTotal = priceTotal;
	}
}
