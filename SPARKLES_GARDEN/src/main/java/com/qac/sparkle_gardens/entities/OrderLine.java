package com.qac.sparkle_gardens.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.qac.sparkle_gardens.entities.composite.OrderLinePK;

/**
 * The OrderLine class contains information regarding one product &
 * its quantity. Note: the quantity of the product
 * in the OrderLine is NOT the product's stock level.
 * 
 * @author Damien Lloyd
 *
 */
@Deprecated 
@Entity
@IdClass(OrderLinePK.class)
@Table(name="OrderLine")
public class OrderLine implements Serializable
{
	private static final long serialVersionUID = 2617329345043164043L;
	

	@Id
	private Order order;
	
	@Id
	private Product product;
	
	@Column
	@NotNull
	private int quantity; // Quantity of Product ordered
	
	/**
	 * Default constructor of OrderLine. 
	 */
	public OrderLine()
	{
	}
	
	/**
	 * Create OrderLine from a product's ID & the quantity ordered.
	 * 
	 * @param productID
	 * @param quantity Quantity of product order. This is not stock level!
	 */
	public OrderLine(Product product, int quantity)
	{
		this.product= product;
		this.quantity=quantity;		
	}
	
	/**
	 * Just like the Constructor, but it's a handy function nonetheless
	 * where it takes:
	 * 
	 * @param product The product to be ordered
	 * @param quantity The quantity of that product to be ordered
	 */
	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	/**
	 * Return the product of the OrderLine
	 * @return productID
	 */
	public Product getProduct() 
	{
		return product;
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