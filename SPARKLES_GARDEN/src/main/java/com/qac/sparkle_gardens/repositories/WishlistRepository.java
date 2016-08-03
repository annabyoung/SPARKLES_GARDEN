package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Wishlist;

public interface WishlistRepository {
	public void persistWishlist(Wishlist wishlist);
	
	// Returns all the wishlists
	public ArrayList<Wishlist> getWishlists();
	
	// Update wishlist
	public void updateWishlist(Wishlist wishlist);
	//Remove wishlist
	public void removeWishlist(Wishlist wishlist);
}
