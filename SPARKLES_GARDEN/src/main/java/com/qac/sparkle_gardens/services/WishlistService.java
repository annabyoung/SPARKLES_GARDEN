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
	@Inject private WishlistRepository wishlistRepository;

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
	 * 
	 * @param customer
	 * @param product
	 */
	public void createWishlist(Customer customer, Product product) {
		Wishlist wish = new Wishlist(customer, product);
		wishlistRepository.persistWishlist(wish);
	}
	
	public void createWishlist(Customer customer, List<Product> products) {
		Wishlist wish = new Wishlist(customer, products);
		wishlistRepository.persistWishlist(wish);
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

	//@Deprecated
	//public void createWishlist(long accountId, String name) {
		//Wishlist wish = new Wishlist(accountId, name);
		//wishlistRepository.persistWishlist(wish);
	//}
	
	
	
	/**
<<<<<<< HEAD
	 * Overloaded create wishlist method
	 * @param accountId
	 * @param product
	 */
	//@Deprecated
	//public void createWishlist(Customer customer, String name) {
		//Wishlist wish = new Wishlist(customer, name);
		//wishlistRepository.persistWishlist(wish);
	//}
	
=======
	 * 
	 * @param product
	 * @param accountId
	 */
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed
	public void addProduct(Product product, long accountId) {
		wishlistRepository.addProductToListWithAcctId(product, accountId);
	}
	
	//@Deprecated
	/**
	 * Overloaded removeProduct method
	 * @param product
	 * @param accountId
	 */
<<<<<<< HEAD
	//public void addProduct(Product product, String wishlistName) {
		//wishlistRepository.addProductToList(product, wishlistName);
	//}
	//@Deprecated
		//public void addProduct(Product product, long wishlistId) {
		//	wishlistRepository.addProductToList(product, wishlistId);
		//}
	
	//@Deprecated
=======
	public void removeProduct(Product product, long accountId) {
		wishlistRepository.removeProduct(product, accountId);
	}
	
	@Deprecated
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed
	/**
	 * Removes a product from a wishlist
	 * @param product
	 * @param wishlistName
	 */
	//public void removeProduct(Product product, String wishlistName) {
		//wishlistRepository.removeProduct(product, wishlistName);
	//}
	
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
	public List<Product> getProducts(Customer customer) {
		return wishlistRepository.getProducts(customer.getAccountID());
	}
	
	public List<Product> getProducts(long accountId) {
		return wishlistRepository.getProducts(accountId);
	}
	
	/**
	 * 
	 * @param wishlistName
	 * @return
	 */
	//@Deprecated
	//public List<Product> getProducts(String wishlistName) {
		//return wishlistRepository.getProducts(wishlistName);
	//}
}
