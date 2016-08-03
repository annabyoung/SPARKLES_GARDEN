package com.qac.sparkle_gardens.entities;

public class Product {
	private String productName, serialNumber;
	private int stockLevel;
	private float price;
	
	public Product(){		
	}
	
	public Product(String productName, String serialNumber, int stockLevel, float price) {
		this.productName = productName;
		this.serialNumber = serialNumber;
		this.stockLevel = stockLevel;
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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
	
	
	
}
