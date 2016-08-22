package com.qac.sparkle_gardens.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
<<<<<<< HEAD
=======
<<<<<<< .merge_file_XwX6cM
import javax.persistence.Table;
=======
>>>>>>> 7c4d37f8e3d8bb39c9a08d970d6bc58309a7710c
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
>>>>>>> .merge_file_1jS2d2
import javax.validation.constraints.NotNull;

import com.qac.sparkle_gardens.entities.composite.OrderLineId;

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
@IdClass(value = OrderLinePK.class)
public class OrderLine implements Serializable
{
	private static final long serialVersionUID = 2617329345043164043L;
	
	@Column
=======
<<<<<<< .merge_file_XwX6cM
@IdClass(OrderLineId.class)
@Table(name="OrderLine")
=======
@IdClass(value = OrderLinePK.class)
>>>>>>> .merge_file_1jS2d2
public class OrderLine implements Serializable
{
	private static final long serialVersionUID = 2617329345043164043L;
<<<<<<< .merge_file_XwX6cM
//
//	@EmbeddedId
//	private OrderLinePK key;	
	@Id
	private Order order;
	
	@Id
	private Product product;
	
	@Column
	@NotNull
	private int quantity; // Quantity of Product ordered
=======
	
	@Column
>>>>>>> 7c4d37f8e3d8bb39c9a08d970d6bc58309a7710c
	@Id
	@Null
	private Order order;
	
	@Column
	@Id
	@Null
	private Product product;
	
	@Column
	@Null
	private int quantity; // Product amount ordered
<<<<<<< HEAD
=======
>>>>>>> .merge_file_1jS2d2
>>>>>>> 7c4d37f8e3d8bb39c9a08d970d6bc58309a7710c
	
	/**
	 * Default constructor of OrderLine. 
	 */
	public OrderLine()
	{
<<<<<<< HEAD
=======
<<<<<<< .merge_file_XwX6cM
		//key = new OrderLinePK();
=======
>>>>>>> .merge_file_1jS2d2
>>>>>>> 7c4d37f8e3d8bb39c9a08d970d6bc58309a7710c
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
		this.product = product;
<<<<<<< HEAD
=======
<<<<<<< .merge_file_XwX6cM
	///	this.key.setProduct(product);
=======
>>>>>>> .merge_file_1jS2d2
>>>>>>> 7c4d37f8e3d8bb39c9a08d970d6bc58309a7710c
		this.quantity = quantity;
	}
	
	/**
	 * Return the product of the OrderLine
	 * @return productID
	 */
	public Product getProduct() 
	{
		return product;
<<<<<<< HEAD
=======
<<<<<<< .merge_file_XwX6cM
	//	return key.getProduct();
=======
>>>>>>> .merge_file_1jS2d2
>>>>>>> 7c4d37f8e3d8bb39c9a08d970d6bc58309a7710c
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