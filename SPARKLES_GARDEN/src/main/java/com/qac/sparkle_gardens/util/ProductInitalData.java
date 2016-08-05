package com.qac.sparkle_gardens.util;

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
 */

@Singleton
public class ProductInitalData {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public ProductInitalData(){
		products.add(new Product("The Great American Challenge", 50, 79.99));
		products.add(new Product("Fleshlight Original", 100, 99.99));
		products.add(new Product("The Screaming O", 500, 19.99));
	}
	
	public List<Product> getProducts(){
		return products;
	}
	
	public void addProduct(Product product){
		products.add(product);
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
	
}
