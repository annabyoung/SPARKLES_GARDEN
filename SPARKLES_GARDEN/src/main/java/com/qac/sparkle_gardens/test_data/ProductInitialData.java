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
		Product p1 = new Product("The Great American Challenge", 50, 79.99);
		p1.addProductTags("dildo");
		p1.addProductTags("dong");
		p1.addProductTags("american");
		p1.addProductTags("challenge");	
		p1.setProductDescription("This is a massive purple dildo. It is American. It is a challenge. It is great.");
		products.add(p1);
		
		
		Product p2 = new Product("Fleshlight Original", 100, 99.99);
		p2.addProductTags("masturbator");
		p2.addProductTags("discreet");
		p2.addProductTags("original");
		p2.addProductTags("male_masturbator");
		p2.setProductDescription("It looks like a flashlight. Take off the cap, and surprise! There's a fake vagina inside.");
		products.add(p2);
		
		
		Product p3 = new Product("The Screaming O", 500, 19.99);
		p3.addProductTags("vibrating");
		p3.addProductTags("cock_ring");
		p3.addProductTags("ring");
		p3.addProductTags("couples");
		p3.setProductDescription("A simple vibrating cock ring. This is popular for couples that want to try something new in the bedroom.");
		products.add(p3);
		
		Product p4 = new Product("Hatachi Wand", 25, 89.99);
		p4.addProductTags("vibrating");
		p4.addProductTags("massager");
		p4.addProductTags("multi_speed");
		p4.setProductDescription("A very powerful massager. It was originally meant to be a back or sore muscle massager since the vibrations are incredibly strong. It's more popularly purchased as a sex toy.");
		products.add(p4);
		
		Product p5 = new Product("Power Bullet", 100, 24.99);
		p5.addProductTags("vibrating");
		p5.addProductTags("multi_speed");
		p5.addProductTags("external_stimulation");
		p2.setProductDescription("A small three-speed vibrator. It's perfect for people that haven't used a vibrator before and want to get an idea of what it's like to use one.");
		products.add(p5);
		
		//setProducts(products);
		
	}
	
	public List<Product> getAllProducts(){
		return this.products;
	}
	
	public void addProduct(Product product){
		this.products.add(product);
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
