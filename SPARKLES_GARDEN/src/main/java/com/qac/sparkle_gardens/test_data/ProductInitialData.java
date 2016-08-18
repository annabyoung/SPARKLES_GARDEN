package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Product;

/**
 * 
 * @author Annabelle Young
 *
 * Since there is no database yet, storing data at runtime for testing purposes.
 * Functions are included to get, add, and set products.
 *
 *deprecated in favour of InitialData (9/8/16)
 */
@Singleton

public class ProductInitialData {
	private List<Product> products = new ArrayList<Product>();
	
	public ProductInitialData(){
		addProduct(new Product("The Great American Challenge", 50, 79.99));
		addProduct(new Product("Fleshlight Original", 100, 99.99));
		addProduct(new Product("The Screaming O", 500, 19.99));
		addProduct(new Product("Hatachi Wand", 25, 89.99));
		addProduct(new Product("", 500, 19.99));
		
	}
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public void addProduct(Product product){
		this.products.add(product);
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
