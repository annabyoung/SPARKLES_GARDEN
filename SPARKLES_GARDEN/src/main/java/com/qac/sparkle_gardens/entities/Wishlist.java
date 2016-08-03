package com.qac.sparkle_gardens.entities;

public class Wishlist {
	private int customerID;
	private int[] products;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int[] getProducts() {
		return products;
	}

	public void setProducts(int[] products) {
		this.products = products;
	}
	
}


