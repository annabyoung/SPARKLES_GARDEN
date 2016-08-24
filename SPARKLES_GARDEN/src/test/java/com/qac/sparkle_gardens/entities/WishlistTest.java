package com.qac.sparkle_gardens.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.util.CreditStatus;

public class WishlistTest {
	
	Customer customer;
	Product product;
	Wishlist wish;
	
	@Before
	public void setup() {
		System.out.println("Let the test begin...");
		product = new Product("Cookie Gnomonster", 2300, 5.50);
		customer = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
		wish = new Wishlist(customer, product);
	}
	
	@Test
	public void inWishlistShouldReturnValidOutput() {
		assertTrue(wish.inWishlist(product.getProductName()));
	}
	
	@Test 
	public void inWishlistShouldReturnFalseWhenNotFoundInList() {
		Product product1 = new Product("Gnomon Ball Z", 2300, 5.50);
		assertFalse(wish.inWishlist(product1.getProductName()));
	}
	
	@After
	public void teardown() {
		product = null;
		customer = null;
		wish = null;
		System.out.println("The test has ended");
	}


}
