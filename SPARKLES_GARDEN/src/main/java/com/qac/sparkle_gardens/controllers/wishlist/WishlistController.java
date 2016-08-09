package com.qac.sparkle_gardens.controllers.wishlist;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.WishlistService;

/**
 * 
 * @author Tyler Deans
 * 
 * This controller adds items to the wishlist and gets the product information
 * 
 */
@Named (value = "wishlist")
public class WishlistController {
	
	@Inject 
	WishlistService wishlistService;
	
	public void createWishlist(long accountId, String wishlistName) {
		wishlistService.createWishlist(accountId, wishlistName);
	}
	
	/**
	 * Adds a product to the wishlist
	 * @param product
	 */
	public void addProductToWishlist(Product product, String wishlistName) {
		
	}
	
	/**
	 * Gets all the products in the wishlist
	 * @return
	 */
	public List<Product> getProducts(String wishlistName) {
		return wishlistService.getProducts(wishlistName);
	}
}
