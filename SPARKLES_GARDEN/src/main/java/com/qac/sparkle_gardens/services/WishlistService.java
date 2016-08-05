package com.qac.sparkle_gardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.WishlistRepository;

/**
 * 
 * @author Tyler Deans
 * This is the Wishlist Service Bean
 */
@Stateless
public class WishlistService {
	@Inject WishlistRepository wishlistRepository;
	/**
	 * Get wishlist information
	 * Create wishlist 
	 * Delete wishlist
	 */
	
	/**
	 * Retrieves the wishlist - the list of products
	 * @param id
	 * @return
	 */
	public Wishlist getWishlist(long id) {
		return wishlistRepository.findById(id);
	}
	
	/**
	 * deletes the wishlist
	 */
	public void deleteWishlist(long id) {
		Wishlist wishlist;
		wishlist = wishlistRepository.findById(id);
		wishlistRepository.removeWishlist(wishlist);
	}
	
	public void createWishlist() {
		
	}
	
}
