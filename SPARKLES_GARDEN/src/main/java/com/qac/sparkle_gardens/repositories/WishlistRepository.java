package com.qac.sparkle_gardens.repositories;

import java.util.List;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

/**
 * 
 * @author Tyler Deans
 *
 * This is the wishlist repository
 * which has the CRUD operation for the Wishlist entity
 */

public interface WishlistRepository {
	public void persistWishlist(Wishlist wishlist);
	public void persistWishlists(List<Wishlist> wishlists);
	// Locate the wishlist by ID
	public Wishlist findById(long id); 
	
	// Returns all the wishlists
	public List<Wishlist> getWishlists();
	
	// Adds a product to a wishlist
	public void addProductToList(Product product, long wishId);
	// Update wishlist
	public void updateWishlist(Wishlist wishlist);
	//Remove wishlist
	public void removeWishlist(Wishlist wishlist);
	
	//Returns all the products in a wishlist
	public List<Product> getProducts(String wishlistName);
}
