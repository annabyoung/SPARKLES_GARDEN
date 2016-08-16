package com.qac.sparkle_gardens.entities;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

public class WishlistTest {
	
	//@Parameter
	//public List <Product> products = new ArrayList<Product>();
	
	@Parameter
	public Product p1 = new Product("The Great American Challenge", 50, 79.99);
	
	@Parameter
	public long accountId = 34;
	
	@Parameter
	public Wishlist list = new Wishlist(accountId, p1);
	
	// checks if a wishlist can be created
	@Test
	public void testWishlistCreation() {
		assertNotNull(list);
	}
	
	@Test 
	public void checkInWishlist() {
		assertTrue(list.inWishlist(p1.getProductID()));
	}
}
