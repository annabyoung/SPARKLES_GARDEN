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
	private ArrayList<Product> products;
	
	@Column
	@NotNull
	private String wishlistName;
	
	public Wishlist () {
		this.acccountId = 0;
	}
	
	public Wishlist(long acccountId, List<Product> products, String wishlistName) {
		this.acccountId = acccountId;
		this.products = (ArrayList<Product>) products;
		this.wishlistName = wishlistName;
	}
	
	/**
	 * 
	 * @param acccountId
	 * @param products
	 */
	public Wishlist(long acccountId, List<Product> products) {
		this.acccountId = acccountId;
		this.products = (ArrayList<Product>) products;
	}
	/**
	 * This constructor was created since when a wishlist is created
	 * products may be added to the wishlist once the wishlist is created.
	 * 
	 * Instead of adding products and creating the wishlist at the same time.
	 * @param acccountId
	 * @param wishlistName
	 */
	public Wishlist(long acccountId, String wishlistName) {
		this.acccountId = acccountId;
		this.wishlistName = wishlistName;
	}
	
	/**
	 * 
	 * Getters and setters for wishlist attributes
	 */
	public String getWishlistName() {
		return wishlistName;
	}

	public void setWishlistName(String wishlistName) {
		this.wishlistName = wishlistName;
	}

	public long getAccountId() {
		return acccountId;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public long getWishlistId() {
		return wishlistId;
	}
	
	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}
   /** I don't know if I need this 
    * It depends on how the products are in a list or 
    * each product ID matches to a customer ID
    * 
    * @Column (name = "productName", nullable = false, length = 225)
	* @NotNull
	* @Size (min = 2, max = 225)
	* private String productName;
	
	* @Column (name = "price", nullable = false, length = 100000)
	* @NotNull
	* @Size (min = 0, max = 100000)
	* private double price;
    * 
    * public String getProductName() {
		return productName;
	* }
	
	* public double getPrice() {
		return price;
	* }
    * 
    */
	
	
	

}


