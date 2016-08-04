package com.qac.sparkle_gardens.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 
 * @author Damien Lloyd
 *
 */
@Entity
public class OrderLine 
{
	@OneToMany
	@JoinColumn(name = "orderID", nullable = false)
	private String orderID;
	
	@OneToMany
	@JoinColumn(name = "productID", nullable = false)
	private ArrayList<String> products;
	
	/**
	 * Create OrderLine from Product and Order
	 * @param p The product
	 * @param o The order
	 */
	public OrderLine(Order o)
	{
		this.orderID = o.getOrderID();
	}
	
	/**
	 * Add product to the order line
	 * @param p Product to add
	 */
	void addProduct(Product p)
	{
		this.products.add(p.getProductID());
	}
	
	/**
	 * Retrieve list of products in order line
	 * @return products
	 */
	public ArrayList<String> getProducts()
	{
		return products;
	}
	
	/**
	 * Set order in order line
	 * @param o Order to be set
	 */
	public void setOrder(Order o)
	{
		this.orderID = o.getOrderID();
	}
	
	/**
	 * Get order in order line
	 * @return order
	 */
	public String getOrderID()
	{
		return orderID;
	}
}
