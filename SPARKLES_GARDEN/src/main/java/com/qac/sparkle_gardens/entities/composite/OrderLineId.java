package com.qac.sparkle_gardens.entities.composite;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;

public class OrderLineId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2226216570947961682L;
	@JoinColumn(name="orderId", nullable=false)
	@ManyToOne
	private Order order;
	@JoinColumn(name="productId", nullable=false)
	@ManyToOne
	private Product product;

	public Order getOrder() {
		return order;
	}
	public Product getProduct() {
		return product;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public OrderLineId() {}
	
	public OrderLineId(Order order, Product product) {
		this.order = order;
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLineId other = (OrderLineId) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}