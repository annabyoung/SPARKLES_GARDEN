package com.qac.sparkle_gardens.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 
 * @author Damien Lloyd
 *
 */
public class OrderLine 
{
	@OneToMany
	@JoinColumn(name = "order_fk", nullable = false)
	private Order order;
	
	@OneToMany
	@JoinColumn(name = "products_fk", nullable = false)
	private List<Product> products;
	
	/**
	 * Create OrderLine from Product and Order
	 * @param p The product
	 * @param o The order
	 */
	OrderLine(Order o)
	{
		this.order = o;
	}
	
	/**
	 * Add product to the order line
	 * @param p Product to add
	 */
	void addProduct(Product p)
	{
		this.products.add(p);
	}
	
	/**
	 * Retrieve list of products in order line
	 * @return products
	 */
	List<Product> getProducts()
	{
		return products;
	}
}
