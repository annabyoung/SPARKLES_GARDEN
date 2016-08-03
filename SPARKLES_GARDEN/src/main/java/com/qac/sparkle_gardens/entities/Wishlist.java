package com.qac.sparkle_gardens.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * 
 * @author Tyler Deans
 *
 */

@Entity
@Table(name = "Wishlist")
public class Wishlist {
	/**
	 * Annotation for Wishlist table
	 */
	@Id 
	@Column(name = "wishlistID")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long wishlistID;
	
	@OneToOne
	@JoinColumn(name = "customer_fk", nullable = false)
	@NotNull
	private String customerID;
	
	@OneToMany
	@JoinColumn(name="product_fk", nullable = false)
	// the list of products in wishlist
	private List<Product> products;
	
	
	public Wishlist(String custid, List<Product> products) {
		customerID = custid;
		this.products = products;
	}
	public String getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Long getWishlist() {
		return wishlistID;
	}
	
}


