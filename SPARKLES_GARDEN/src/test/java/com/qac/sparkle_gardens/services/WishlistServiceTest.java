package com.qac.sparkle_gardens.services;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.qac.sparkle_gardens.entities.Product;

public class WishlistServiceTest {
	
	@Parameter
	private WishlistService wishService = new WishlistService();
	
	@Parameter
	private long id = 0;
	
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
	public void deleteWishlisthouldThrowIllegalExceptionForInvalidWishlistId() {
		wishService.deleteWishlist(id);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deleteWishlisthouldThrowIllegalExceptionForNullCustomer() {
		wishService.deleteWishlist(null);
	}

	
	
}
