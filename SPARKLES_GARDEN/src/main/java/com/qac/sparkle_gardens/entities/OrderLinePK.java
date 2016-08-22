package com.qac.sparkle_gardens.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderLinePK implements Serializable
{
	private static final long serialVersionUID = 1517213253333547928L;
<<<<<<< .merge_file_OwhEK1

//	@Column (name = "orderID", nullable = false)
//	private Order order;
//	
//	@Column (name = "productID", nullable = false)
//	private Product product;	
//	
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public Order getOrder() {
//		return order;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	@Override
//	public boolean equals(Object obj) 
//	{
//		return super.equals(obj);
//	}
//	
//	@Override
//	public int hashCode() 
//	{
//		return super.hashCode();
//	}
=======
	
	@ManyToOne
	@JoinColumn (name = "orderID", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn (name = "productID", nullable = false)
	private Product product;
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public Product getProduct() {
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
>>>>>>> .merge_file_gAJkuo
}
