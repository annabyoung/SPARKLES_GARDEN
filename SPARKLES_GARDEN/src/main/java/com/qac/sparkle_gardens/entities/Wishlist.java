package com.qac.sparkle_gardens.entities;

import java.util.ArrayList;
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
	// Annotation for Wishlist table
	
	/**
	 * I made an ID for the wishlist because I needed a way to uniquely
	 * identify each list. In case that a wishlist needs to be updated
	 */
	@Id
	@Column (name = "wishlistID")
	@GeneratedValue  (strategy = GenerationType.IDENTITY)
	private long wishlistId;
	
	@OneToOne
	@JoinColumn(name = "accountID", nullable = false)
	@NotNull
	private long acccountId;
	
	/**
	 * A wishlist would have a list of products associated with one
	 * customer
	 */
	@OneToMany
	@JoinColumn(name="product_fk", nullable = false)
	// the list of products in wishlist
	private ArrayList<Product> product;
	
	/**
	 * I am not sure if I need to use these properties
	 * because the products are in a list.
	 * 
	 * 
	 * @Column (name = "productName", nullable = false, length = 225)
	 * @NotNull
	 * @Size (min = 2, max = 225)
	 * private String productName;
	
	 * @Column (name = "price", nullable = false, length = 100000)
	 * @NotNull
	 * @Size (min = 0, max = 100000)
	*  private double price;
	 */
	
	
	public Wishlist () {
		this.acccountId = 0;
	}
	public Wishlist(long acccountId, List<Product> product) {
		this.acccountId = acccountId;
		this.product = (ArrayList<Product>) product;
	}
	public long getCustomerId() {
		return acccountId;
	}
	/**
	 * If product name and price are separate columns in the database table then 
	 * these methods are necessary. I am not sure if they necessary.
	 * 
	 * public String getProductName() {
		return productName;
	 }
	
	 * public double getPrice() {
		return price;
	 }
	 */
	
	
	public ArrayList<Product> getproduct() {
		return product;
	}
	public long getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}

}


