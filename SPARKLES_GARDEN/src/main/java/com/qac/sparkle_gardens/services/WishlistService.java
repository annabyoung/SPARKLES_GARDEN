package com.qac.sparkle_gardens.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Customer;
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
	 * Retrieves all of the customer's wishlists
	 * @return
	 */
	public List<Wishlist> getWishlists() {
		return wishlistRepository.getWishlists();
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
	public void createWishlist(Customer customer, String name) {
		Wishlist wish = new Wishlist(customer, name);
		wishlistRepository.persistWishlist(wish);
	}
	
	
	
	/**
	 * 
	 * @param product
	 * @param accountId
	 */
	public void addProduct(Product product, long accountId) {
		wishlistRepository.addProductToListWithAcctId(product, accountId);
	}
	
	/**
	 * Overloaded removeProduct method
	 * @param product
	 * @param accountId
	 */
	public void removeProduct(Product product, long accountId) {
		wishlistRepository.removeProduct(product, accountId);
	}
	
	@Deprecated
	/**
	 * Removes a product from a wishlist
	 * @param product
	 * @param wishlistName
	 */
	public void removeProduct(Product product, String wishlistName) {
		wishlistRepository.removeProduct(product, wishlistName);
	}
	
	@Deprecated
	/**
	 * Overloaded addProduct method
	 * if the name of the wislist is passed instead of the wishlist ID
	 * @param product
	 * @param wishlistName
	 */
	public void addProduct(Product product, String wishlistName) {
		wishlistRepository.addProductToList(product, wishlistName);
	}
	
	/**
	 * 
	 * @param wishlistName
	 * @return
	 */
	public List<Product> getProducts(String wishlistName) {
		return wishlistRepository.getProducts(wishlistName);
	}
}
