package com.qac.sparkle_gardens.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Product;
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
	 * @param id
	 */
	public void deleteWishlist(long id) {
		Wishlist wishlist;
		wishlist = wishlistRepository.findById(id);
		wishlistRepository.removeWishlist(wishlist);
	}
	
	/**
	 *  Creates a new wishlist
	 * @param accountId
	 * @param list
	 */
	public void createWishlist(long accountId, List<Product> list) {
		Wishlist wish = new Wishlist(accountId, list);
		wishlistRepository.persistWishlist(wish);
	}
	
	/**
	 * Adds a product to a wishlist
	 * This can be used in another service
	 * @param product
	 * @param wishlist
	 */
	public void addProduct(Product product, long wishlistId) {
		wishlistRepository.addProductToList(product, wishlistId);
	}
	
}
