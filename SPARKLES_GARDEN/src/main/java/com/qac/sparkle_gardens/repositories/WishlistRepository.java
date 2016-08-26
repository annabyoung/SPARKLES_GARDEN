package com.qac.sparkle_gardens.repositories;

import java.util.List;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

/**
 * 
 * @author Tyler Deans
 *
 * This is the wishlist repository
 * which has the CRUD operations for the Wishlist entity.
 */

public interface WishlistRepository {
	public void persistWishlist(Wishlist wishlist);
	public void persistWishlists(List<Wishlist> wishlists);
	// Locate the wishlist by ID
	public Wishlist findById(long id); 
	
	// Returns all the wishlists
	public List<Wishlist> getWishlists();
	
	public Wishlist findByAccountId(long id);
	
	// Adds a product to a wishlist
	public void addProductToList(Product product, long wishId);
	
	public void addProductToListWithAcctId(Product product, long acctId);
	
	public List<Product> getProducts(long accountId);
	
	// Update wishlist
	public void updateWishlist(Wishlist wishlist);
	
	//Remove wishlist
	public void removeWishlist(Wishlist wishlist);
	
	// overloaded method with accountId parameter
	public void removeProduct(Product product, long accountId);
	
	// checks if a product is in a wishlist
	public boolean inWishlist(Product product, long accountId);
	
}
