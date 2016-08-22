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
		Product p1 = new Product("The Great American Challenge", 50, 79.99, "/images/gnome0.jpg");
		p1.addProductTags("dildo");
		p1.addProductTags("dong");
		p1.addProductTags("american");
		p1.addProductTags("challenge");	
		products.add(p1);
		
		
		Product p2 = new Product("Fleshlight Original", 100, 99.99, "/images/gnome1.jpg");
		p2.addProductTags("masturbator");
		p2.addProductTags("discreet");
		p2.addProductTags("original");
		p2.addProductTags("male_masturbator");
		products.add(p2);
		
		
		Product p3 = new Product("The Screaming O", 500, 19.99, "/images/gnome2.jpg");
		p3.addProductTags("vibrating");
		p3.addProductTags("cock_ring");
		p3.addProductTags("ring");
		p3.addProductTags("couples");
		products.add(p3);
		
		Product p4 = new Product("Hatachi Wand", 25, 89.99, "/images/gnome3.jpg");
		p4.addProductTags("vibrating");
		p4.addProductTags("massager");
		p4.addProductTags("multi_speed");
		products.add(p4);
		
		Product p5 = new Product("Power Bullet", 100, 24.99, "/images/gnome4.jpg");
		p5.addProductTags("vibrating");
		p5.addProductTags("multi_speed");
		p5.addProductTags("external_stimulation");
		products.add(p5);
		
		setProducts(products);
		
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