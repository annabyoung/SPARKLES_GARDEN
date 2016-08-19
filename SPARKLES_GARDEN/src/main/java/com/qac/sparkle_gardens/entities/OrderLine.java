package com.qac.sparkle_gardens.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * The OrderLine class contains information regarding one product &
 * its quantity. Note: the quantity of the product
 * in the OrderLine is NOT equal to the quantity of the product's stock level.
 * 
 * @author Damien Lloyd
 *
 */

@Entity
public class OrderLine implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2617329345043164043L;

	@EmbeddedId
	private OrderLinePK key;
	
	@Column
	@Null
	private Product product;
	
	@Column
	@Null
	private int quantity; // Quantity of Product ordered
	
	/**
	 * Default constructor of OrderLine. 
	 */
	public OrderLine()
	{
		key = new OrderLinePK();
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
		this();
		setProduct(product, quantity);
	}
	
	/**
	 * Just like the Constructor, but it's a handy function nonetheless
	 * where it takes:
	 * 
	 * @param product The product to be ordered
	 * @param quantity The quantity of that product to be ordered
	 */
	public void setProduct(Product product, int quantity)
	{
		this.key.setProduct(product);
		this.quantity = quantity;
	}
	
	/**
	 * Return the product of the OrderLine
	 * @return productID
	 */
	public Product getProduct() 
	{
		return key.getProduct();
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
