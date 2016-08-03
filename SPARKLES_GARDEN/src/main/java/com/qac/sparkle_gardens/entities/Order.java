package com.qac.sparkle_gardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Damien Lloyd
 *
 */
@Entity
@Table (name = "order")
public class Order 
{
	@Id
	@Column (name = "orderID")
	private String orderID;
	
	@Column (name = "quantity", nullable = false)
	private int quantity;
	
	@Column (name = "priceTotal", nullable = false)
	private int priceTotal;
	
	/**
	 * Default constructor
	 */
	public Order()
	{
		
	}
	
	/**
	 * Construct Order with values
	 */
	public Order(String id, int quantity, int priceTotal)
	{
		this.orderID = id;
		this.quantity = quantity;
		this.priceTotal = priceTotal;
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
