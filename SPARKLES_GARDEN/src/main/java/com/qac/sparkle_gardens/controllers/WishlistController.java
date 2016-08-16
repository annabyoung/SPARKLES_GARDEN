package com.qac.sparkle_gardens.controllers;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.WishlistService;

/**
 * 
 * @author Tyler Deans
 * 
 * This controller adds items to the wishlist and gets the product information
 * 
 */
@Named (value = "wishlist")

@RequestScoped
public class WishlistController {
	
	@Inject 
	WishlistService wishlistService;
	@Inject 
	OrderService orderService;
	
	/**
	 * Creates a wishlist for a given customer
	 * @param accountId
	 * @param wishlistName
	 */
	public void createWishlist(long accountId, String wishlistName) {
		wishlistService.createWishlist(accountId, wishlistName);
	}
	
	public void createWishlist(long accountId, Product product) {
		wishlistService.createWishlist(accountId, product);
	}
	
	/**
	 * Adds a product to the wishlist
	 * @param product
	 * @param wishlistName
	 */
	public void addProductToWishlist(Product product, String wishlistName) {
		wishlistService.addProduct(product, wishlistName);
	}
	
	/**
	 * Removes a product from the wishlist
	 * @param product
	 * @param wishlistName
	 */
	public void removeProductFromWishlist(Product product, long accountId) {
		wishlistService.removeProduct(product, accountId);
	}
	
	/**
	 * Gets all the products in the wishlist
	 * @return
	 */
	public List<Product> getProducts(String wishlistName) {
		return wishlistService.getProducts(wishlistName);
	}
	
	
}
