package com.qac.sparkle_gardens.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Damien Lloyd
 *
 */
@Entity
public class OrderLine 
{
	@OneToMany
	@NotNull
	@JoinColumn(name = "orderID", nullable = false)
	private long orderID;
	
	@OneToMany
	@NotNull
	@JoinColumn(name = "productID", nullable = false)
	private long productID;
	
	private int quantity; // Quantity of Products of productID
	
	private double price; // The price of the product of productID
	
	public OrderLine()
	{
		price = 0;
		quantity = 0;
	}
	
	public OrderLine(long productID, int quantity, double price)
	{
		setProduct(productID, quantity, price);
	}
	
	public void setProduct(long productID, int quantity, double price)
	{
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
	}
}
