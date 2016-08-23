package com.qac.sparkle_gardens.entities.composite;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;

/**
 * Primary key class for OrderLine
 * 
 * @author Damien Lloyd
 *
 */
public class OrderLinePK implements Serializable
{
	private static final long serialVersionUID = 1517213253333547928L;

	@JoinColumn (name = "orderID", nullable = false)
	@ManyToOne
	private Order order;
	
	@JoinColumn (name = "productID", nullable = false)
	@ManyToOne
	private Product product;	
	
	public OrderLinePK()
	{
		order = null;
		product = null;
	}
	
	public OrderLinePK(Order order, Product product)
	{
		this.order = order;
		this.product = product;
	}
	
	public void setOrder(Order order) 
	{
		this.order = order;
	}

	public void setProduct(Product product) 
	{
		this.product = product;
	}

	public Order getOrder() 
	{
		return order;
	}

	public Product getProduct() 
	{
		return product;
	}

	@Override
	public boolean equals(Object obj) 
	{
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() 
	{
		return super.hashCode();
	}
}
