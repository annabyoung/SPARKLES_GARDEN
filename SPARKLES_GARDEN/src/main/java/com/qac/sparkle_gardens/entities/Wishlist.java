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
	private Customer customer;
	
	/**
	 * A wishlist would have a list of products associated with one
	 * customer
	 */
	@OneToMany
	@JoinColumn(name="product_fk", nullable = false)
	// the list of products in wishlist
	private List<Product> products;
	
	// default constructor
	public Wishlist () { }
	
	public Wishlist(Customer customer) {
		this.customer = customer;
		products = new ArrayList<Product>();
	}
	public Wishlist(Customer customer, Product product) {
		this.customer = customer;
		products = new ArrayList<Product>();
		addProduct(product);
	}
	
	/**
	 * 
	 * @param acccountId
	 * @param products
	 */
	public Wishlist(Customer customer, List<Product> products) {
		this.customer = customer;
		this.products = (ArrayList<Product>) products;
	}
	
	
	/**
	 * Checks if the product is in a wishlist
	 * @param productId
	 * @return
	 */
	public boolean inWishlist(String productName) {
		for (int index = 0; index < products.size(); index++) {
			if (products.get(index).getProductName().equals(productName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Getters and setters for wishlist attributes
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	public List<Product> getProducts() {
		return (List<Product>) products;
	}
	
	/**
	 * adds a product to the product list 
	 * @param product
	 */
	public void addProduct(Product product) {
		products.add(product);
	}
	
	/**
	 * removes a product from the product list 
	 * @param product
	 */
	public void removeProduct(Product product) {
		for (int index = 0; index < products.size(); index++) {
			if (products.get(index).getProductID() == product.getProductID()) {
				products.remove(index);
			}
		}
	}
	
	public long getWishlistId() {
		return wishlistId;
	}
	
	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}
  
}