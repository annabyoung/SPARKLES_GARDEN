package com.qac.sparkle_gardens.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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
		assertEquals(true, list.inWishlist(p1.getProductID()));
	}
}
