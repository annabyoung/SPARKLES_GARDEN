package com.qac.sparkle_gardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * The OrderLine class contains information regarding one product &
 * its quantity. Note: the quantity of the product
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
	@JoinColumn(name = "productID", nullable = false)
	private long productID;

	private Product product;
	
	@Column
	@NotNull
	private int quantity; // Quantity of Product ordered
	
	/**
	 * Default constructor of OrderLine. 
	 */
	public OrderLine()
	{
		product = new Product();
		quantity = 0;
	}
	
	/**
	 * Create OrderLine from a product's ID & the quantity ordered.
	 * 
	 * @param productID
	 * @param quantity Quantity of product order. This is not stock level!
	 */
	public OrderLine(Product product, int quantity)
	{
		setProduct(product, quantity);
	}
	
	/**
	 * Just like the Constructor, but it's a handy function nonetheless
	 * where it takes:
	 * 
	 * @param productID The ID of the product to be ordered
	 * @param quantity The quantity of the product to be ordered
	 */
	public void setProduct(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}
	
	/**
	 * Return the orderID of the OrderLine it pertains to
	 * @return orderID
	 */
	public long getProductID() 
	{
		return productID;
	}
	
	/**
	 * Set the orderID the OrderLine relates to
	 * @param orderID
	 */
	public void setProductID(long productID) 
	{
		this.productID = productID;
	}
	
	/**
	 * Return the productID of the OrderLine
	 * @return productID
	 */
	public Product getProduct() 
	{
		return product;
	}
	
	/**
	 * Set the productID of the product
	 * @param productID
	 */
	public void setProduct(Product product) 
	{
		this.product = product;
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
}
