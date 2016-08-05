package com.qac.sparkle_gardens.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Annabelle Young
 * 
 * Product class that defines ability to find a product by any of its attributes, which includes the ID, name, amount of its stock, and its price.
 * There are defined functions to allow retrieval of all of the product's attributes and the ability to set the values for everything except for product ID.
 *
 */

@Entity

//Queries to find products by different attributes
@NamedQueries({
	@NamedQuery(name = Product.FIND_BY_PRODUCT_ID, 
		query = "SELECT a FROM Product a WHERE a.productID = :productID"),
	@NamedQuery(name = Product.FIND_BY_PRODUCT_NAME, 
		query = "SELECT a FROM Product a WHERE a.productName = :productName"),
	@NamedQuery(name = Product.FIND_BY_STOCK_LEVEL, 
		query = "SELECT a FROM Product a WHERE a.stockLevel = :stockLevel"),
	@NamedQuery(name = Product.FIND_BY_PRICE, 
		query = "SELECT a FROM Product a WHERE a.price = :price")
	
})

@Table (name = "products")
public class Product {
	/*
	 * To do:
	 * Product Image
	 * Product Description
	*/
	@Id
	@Column (name = "productID")
	@GeneratedValue  (strategy = GenerationType.IDENTITY)//
	private long productID;
	
	@Column (name = "productName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String productName;
	
	@Column (name = "stockLevel", nullable = false, length = 10000)
	@NotNull
	@Size (min = 0, max = 10000)
	private int stockLevel;
	
	@Column (name = "price", nullable = false, length = 100000)
	@NotNull
	@Size (min = 0, max = 100000)
	private double price;
	
	//Many products to one wish list
	@ManyToOne
	@JoinColumn(name="wishlist_fk", nullable = false)
	private Wishlist wishlist;
	
	//One product to many order lines
	@OneToMany
	@JoinColumn(name="orderline_fk", nullable = false)
	private List<OrderLine> orderline;
	
	//setting Strings for queries to find Product by its attributes
	public static final String FIND_BY_PRODUCT_ID= "Product.getProductID()";
	public static final String FIND_BY_PRODUCT_NAME= "Product.getProductName()";
	public static final String FIND_BY_STOCK_LEVEL= "Product.getStockLevel()";
	public static final String FIND_BY_PRICE= "Product.getPrice()";	
	
	//blank constructor for Product
	public Product() {	}
	
	//constructor for Product
	public Product(String productName, int stockLevel, double price){	
		this.productName = productName;	
		this.stockLevel = stockLevel;
		this.price = price;}
		
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	//Retrieve Product ID
	public long getProductID() {
		return productID;
	}
	
	public int getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
}
