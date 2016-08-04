package com.qac.sparkle_gardens.entities;

import java.util.ArrayList;

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
import javax.validation.constraints.Size;


/**
 * 
 * @author Tyler Deans
 *
 */

@Entity
@Table(name = "Wishlist")
public class Wishlist {
	// Annotation for Wishlist table
	
	/**
	 * I made an ID for the wishlist because I needed a way to uniquely
	 * identify each list. In case that a wishlist needs to be updated
	 */
	@Id
	@Column (name = "wishlistID")
	@GeneratedValue  (strategy = GenerationType.IDENTITY)
	private String wishlistId;
	
	@OneToOne
	@JoinColumn(name = "customerID", nullable = false)
	@NotNull
	private String customerId;
	
	@OneToMany
	@JoinColumn(name="product_fk", nullable = false)
	// the list of products in wishlist
	private ArrayList<Product> product;
	
	@Column (name = "productName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String productName;
	
	@Column (name = "price", nullable = false, length = 100000)
	@NotNull
	@Size (min = 0, max = 100000)
	private double price;
	
	public Wishlist () {
		this.customerId = "";
	}
	public Wishlist(String customerId, ArrayList<Product> product) {
		this.customerId = customerId;
		this.product = product;
	}
	public String getCustomerId() {
		return customerId;
	}

	public String getProductName() {
		return productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public ArrayList<Product> getproduct() {
		return product;
	}
	public String getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(String wishlistId) {
		this.wishlistId = wishlistId;
	}

}


