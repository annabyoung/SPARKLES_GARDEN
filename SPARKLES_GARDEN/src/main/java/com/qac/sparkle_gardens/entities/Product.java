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

@Entity
@NamedQueries({@NamedQuery(name = OrderLine.FIND_BY_PRODUCT_NAME, query = "SELECT a FROM Product a WHERE a.productName = :productName"),})

@Table (name = "products")
public class Product {
	@Id
	@Column (name = "productID")
	@GeneratedValue  (strategy = GenerationType.IDENTITY)//
	private Long productID;
	
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
	private float price;
	
	@ManyToOne
	@JoinColumn(name="wishlist_fk", nullable = false)
	private Wishlist wishlist;
	
	public Product() {	}
	
	public Product(String productName, int stockLevel, float price){	
		this.productName = productName;	
		this.stockLevel = stockLevel;
		this.price = price;}
		
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductID() {
		return productID;
	}
	
	public int getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public static final String FIND_BY_PRODUCT_NAME= "Product.getProductName";
	
}
