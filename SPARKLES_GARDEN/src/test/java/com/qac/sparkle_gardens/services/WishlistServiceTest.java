package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.qac.sparkle_gardens.controllers.WishlistServiceInterface;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

import junit.framework.TestCase;
public class WishlistServiceTest extends TestCase {
	
	@Parameter
	WishlistServiceInterface wishService = new WishlistService();
	
	@Parameter
	List<Product> products = new ArrayList<Product>();
	
	@Parameter
	public Product p1 = new Product("The Great American Challenge", 50, 79.99);
	
	@Parameter
	public long accountId = 34;
	
	@Test  // tests if the getProducts method works
	public void checkGetProducts() {
		// First make the test pass then later make it fail to ensure the test works
		Wishlist wishlist = new Wishlist(accountId, p1);
		wishService.createWishlist(accountId, p1);
		
		boolean equal = false;
		List<Product> wishlistProdCopy = wishlist.getProducts();
		List<Product> serviceProdCopy = wishService.getProducts(accountId);
		
		if (wishlistProdCopy.size() != serviceProdCopy.size()) {
			equal = false;
		}
		else {
			for (int index = 0; index < wishlistProdCopy.size(); index++) {
				if (wishlistProdCopy.get(index).getProductID() == serviceProdCopy.get(index).getProductID()) {
					equal = true;
				}
				else {
					equal = false;
				}
			}
		}
		
		assertTrue(equal);
	}
}
