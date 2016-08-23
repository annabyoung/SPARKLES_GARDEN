package com.qac.sparkle_gardens.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.qac.sparkle_gardens.entities.OrderLinePK;
=======
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.qac.sparkle_gardens.entities.composite.OrderLinePK;
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed

/**
 * The OrderLine class contains information regarding one product &
 * its quantity. Note: the quantity of the product
 * in the OrderLine is NOT the product's stock level.
 * 
 * @author Damien Lloyd
 *
 */

@Entity
<<<<<<< HEAD
@IdClass(OrderLinePK.class)
@Table(name="OrderLine")
public class OrderLine implements Serializable
{
	private static final long serialVersionUID = 2617329345043164043L;
	
=======
@Table(name="OrderLine")
@IdClass(value = OrderLinePK.class)
public class OrderLine implements Serializable
{
	private static final long serialVersionUID = 2617329345043164043L;
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed

	@Id
	private Order order;
	
	@Id
	private Product product;
	
	@Column
	@NotNull
	private int quantity; // Quantity of Product ordered
<<<<<<< HEAD
	
=======

>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed
	/**
	 * Default constructor of OrderLine. 
	 */
	public OrderLine()
	{
<<<<<<< HEAD
=======

		quantity = 0;
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed
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
		this.product = product;
		this.quantity = quantity;
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