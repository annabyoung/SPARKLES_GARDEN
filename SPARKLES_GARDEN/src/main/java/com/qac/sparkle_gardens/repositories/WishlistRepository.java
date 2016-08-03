package com.qac.sparkle_gardens.repositories;

import java.util.List;
import com.qac.sparkle_gardens.entities.Wishlist;

public interface WishlistRepository {
	public void persistWishlist(Wishlist wishlist);
	public void persistWishlists(List<Wishlist> wishlists);
	// Read wishlist
	public Wishlist getWishlist();
	
	// Update wishlist
	public void updateWishlist(Wishlist wishlist);
	//Remove wishlist
	public void removeWishlist(Wishlist wishlist);
}
