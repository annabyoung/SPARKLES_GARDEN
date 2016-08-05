package com.qac.sparkle_gardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@NotNull
	@Column (name = "orderID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderID;
	
	@Column (name = "customerID", nullable = false)
	@NotNull
	private long customerID;
	
	/**
	 * Default constructor
	 */
	public Order()
	{
		
	}
	
	/**
	 * Construct Order with values
	 */
	public Order(long order_id, long customer_id)
	{
		this.orderID = order_id;
		this.customerID = customer_id;
	}
	
	/**
	 * Get the order ID
	 * @return orderID
	 */
	public long getOrderID() 
	{
		return orderID;
	}
	
	/**
	 * Set the order ID
	 * @param orderID
	 */
	public void setOrderID(long orderID) 
	{
		this.orderID = orderID;
	}
}
