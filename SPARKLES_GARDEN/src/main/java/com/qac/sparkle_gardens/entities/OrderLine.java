package com.qac.sparkle_gardens.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * The OrderLine class contains information regarding one product,
 * its quantity, and its price. Note: the quantity of the product
 * in the OrderLine is NOT equal to the quantity of the product's stock level.
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
	
	/**
	 * Default constructor of OrderLine. 
	 */
	public OrderLine()
	{
		price = 0;
		quantity = 0;
	}
	
	/**
	 * Create OrderLine from a product's ID, the quantity ordered
	 * and the INDIVIDUAL price.
	 * 
	 * @param productID
	 * @param quantity Quantity of product order. This is not stock level!
	 * @param price This is not total price! Input the product's price only
	 */
	public OrderLine(long productID, int quantity, double price)
	{
		setProduct(productID, quantity, price);
	}
	
	/**
	 * Just like the Constructor, but it's a handy function nonetheless
	 * where it takes:
	 * 
	 * @param productID The ID of the product to be ordered
	 * @param quantity The quantity of the product to be ordered
	 * @param price The individual price of the product (not total)
	 */
	public void setProduct(long productID, int quantity, double price)
	{
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
	}
	
	/**
	 * Return the orderID of the OrderLine it pertains to
	 * @return orderID
	 */
	public long getOrderID() 
	{
		return orderID;
	}
	
	/**
	 * Set the orderID the OrderLine relates to
	 * @param orderID
	 */
	public void setOrderID(long orderID) 
	{
		this.orderID = orderID;
	}
	
	/**
	 * Return the productID of the OrderLine
	 * @return productID
	 */
	public long getProductID() 
	{
		return productID;
	}
	
	/**
	 * Set the productID of the product
	 * @param productID
	 */
	public void setProductID(long productID) 
	{
		this.productID = productID;
	}
	
	/**
	 * Get the quantity of the desired product to be ordered
	 * @return quantity
	 */
	public int getQuantity() 
	{
		return quantity;
	}
	
	/**
	 * Set the quantity of the product to be ordered
	 * @param quantity
	 */
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	/**
	 * Get the individual price of the product to be ordered
	 * @return price
	 */
	public double getPrice() 
	{
		return price;
	}
	
	/**
	 * Set the individual price of the product to be ordered
	 * @param price
	 */
	public void setPrice(double price) 
	{
		this.price = price;
	}
}
