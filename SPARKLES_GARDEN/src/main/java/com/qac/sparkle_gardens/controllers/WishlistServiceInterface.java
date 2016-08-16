package com.qac.sparkle_gardens.controllers;

import java.util.List;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

public interface WishlistServiceInterface {
	
	public Wishlist getWishlist(long id);
	public List<Wishlist> getWishlists();
	public void deleteWishlist(long id);
	public void createWishlist(long accountId, String name);
	public void addProduct(Product product, long wishlistId);
	public void addProduct(Product product, String wishlistName);
	public void removeProduct(Product product, String wishlistName);
	public void removeProduct(Product product, long accountId);
	public List<Product> getProducts(String wishlistName);
	
}
