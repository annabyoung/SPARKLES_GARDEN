package com.qac.sparkle_gardens.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.util.CreditStatus;

public class WishlistServiceTest {
	
	@Parameter
	private WishlistService wishService = new WishlistService();
	
	@Parameter
	private long id = -1;
	
	private Customer customer;
	private Product product;
	
	@Before
	public void setup() {
		System.out.println("The test has begun...");
		product = new Product("Cookie Gnomonster", 2300, 5.50);
		customer = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
		//wishService.createWishlist(customer, product);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getWishlistShouldThrowIllegalExceptionForInvalidWishlistId() {
		wishService.getWishlist(id);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createWishlistShouldThrowIllegalExceptionForInvalidInput() {
		Product monster = new Product("Cookie Gnomonster", 2300, 5.50);
		wishService.createWishlist(null, monster);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createWishlistShouldThrowIllegalExceptionForInvalidCustomer() {
		wishService.createWishlist(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deleteWishlisthouldThrowIllegalExceptionForInvalidWishlistId() {
		wishService.deleteWishlist(id);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deleteWishlistShouldThrowIllegalExceptionForNullCustomer() {
		wishService.deleteWishlist(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getWishlistShouldThrowIllegalExceptionForInvalidAccountId() {
		wishService.getWishlist(id);
	}
	
	
	@Test
	public void createWishlistShouldCreateAWishlistWithValidInput() {
		wishService.createWishlist(customer, product);
		assertNotNull(wishService.getWishlist(customer));
	}
	
	@Test 
	public void inWishlistReturnTrueForProductInList() {		
		assertTrue(wishService.inWishlist(product, customer));
	}
	
	@Test 
	public void getProductsShouldReturnProductsWithValidInput() {
		assertFalse(wishService.getProducts(customer.getAccountID()).isEmpty());
	}
	
	@Test
	public void getWishlistShouldReturnAWishlistWithValidInput() {
		assertNotNull(wishService.getWishlist(customer));
	}
	
	
	@After
	public void teardown() {
		product = null;
		customer = null;
		//wish = null;
		System.out.println("The test has ended");
	}
}
