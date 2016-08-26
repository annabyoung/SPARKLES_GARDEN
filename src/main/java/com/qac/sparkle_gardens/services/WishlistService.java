package com.qac.sparkle_gardens.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.WishlistRepository;
import com.qac.sparkle_gardens.repositories.offline.WishlistRepositoryOffline;
import com.qac.sparkle_gardens.test_data.WishlistInitialData;

/**
 * 
 * @author Tyler Deans
 * This is the Wishlist Service Bean
 */
@Stateless
public class WishlistService {
	@Inject private WishlistRepository wishlistRepository = new WishlistRepositoryOffline();
	@Inject private WishlistInitialData initialData = new WishlistInitialData();
	/**
	 * 
	 * @param customer
	 * @return
	 */
	public Wishlist getWishlist(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException();
		}
		return wishlistRepository.findByAccountId(customer.getAccountID());
	}
	
	/**
	 * Retrieves the wishlist based on the account ID
	 * @param accountId
	 * @return
	 */
	public Wishlist getWishlist(long accountId) {
		if (accountId <= 0) {
			throw new IllegalArgumentException();
		}
		return wishlistRepository.findByAccountId(accountId);
	}
	
	/**
	 * Retrieves all of the customer's wishlists
	 * @return
	 */
	public List<Wishlist> getWishlists() {
		return wishlistRepository.getWishlists();
	}
	
	public void createWishlist(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException();
		}
		
		wishlistRepository.persistWishlist(new Wishlist(customer));
	}
	
	/**
	 * 
	 * @param customer
	 * @param product
	 */
	public void createWishlist(Customer customer, Product product) {
		if (customer == null || product == null) {
			throw new IllegalArgumentException();
		}
		Wishlist wish = new Wishlist(customer, product);
		wishlistRepository.persistWishlist(wish);
	}
	
	/**
	 * 
	 * @param customer
	 * @param products
	 */
	public void createWishlist(Customer customer, List<Product> products) {
		if (customer == null || products.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Wishlist wish = new Wishlist(customer, products);
		wishlistRepository.persistWishlist(wish);
	}
	
	/**
	 * deletes the wishlist
	 * @param wishlistId
	 */
	public void deleteWishlist(long wishlistId) {
		if (wishlistId <= 0) {
			throw new IllegalArgumentException();
		}
		Wishlist wishlist;
		wishlist = wishlistRepository.findById(wishlistId);
		wishlistRepository.removeWishlist(wishlist);
	}
	
	/**
	 * 
	 * @param customer
	 */
	public void deleteWishlist(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException();
		}
 		Wishlist wish = wishlistRepository.findByAccountId(customer.getAccountID());
		wishlistRepository.removeWishlist(wish);
	}
	
	public void removeProduct(Product product, long accountId) {
		if (product == null || accountId <= 0) {
			throw new IllegalArgumentException();
		}
		wishlistRepository.removeProduct(product, accountId);
	}
	public List<Product> getProducts(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException();
		}
		return wishlistRepository.getProducts(customer.getAccountID());
	}
	
	public List<Product> getProducts(long accountId) {
		if (accountId <= 0) {
			throw new IllegalArgumentException();
		}
		return wishlistRepository.getProducts(accountId);
	}
	
	public void addProduct(Product product, long accountId) {
		if (product == null || accountId <= 0) {
			throw new IllegalArgumentException();
		}
		wishlistRepository.addProductToListWithAcctId(product, accountId);
	}
	
	public void addProduct(Product product, Customer customer) {
		if (product == null || customer == null) {
			throw new IllegalArgumentException();
		}
		wishlistRepository.addProductToListWithAcctId(product, customer.getAccountID());
	}
	
	// checks if a product is in a list
	public boolean inWishlist(Product product, Customer customer) {
		if (product == null) {
			throw new IllegalArgumentException();
		}
		
		return wishlistRepository.inWishlist(product, customer.getAccountID());
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
	 * Overloaded create wishlist method
	 * @param accountId
	 * @param product
	 */
	//@Deprecated
	//public void createWishlist(Customer customer, String name) {
		//Wishlist wish = new Wishlist(customer, name);
		//wishlistRepository.persistWishlist(wish);
	//}
	
	//@Deprecated
	/**
	 * Overloaded addProduct method
	 * if the name of the wislist is passed instead of the wishlist ID
	 * @param product
	 * @param wishlistName
	 */
	//public void addProduct(Product product, String wishlistName) {
		//wishlistRepository.addProductToList(product, wishlistName);
	//}
	//@Deprecated
		//public void addProduct(Product product, long wishlistId) {
		//	wishlistRepository.addProductToList(product, wishlistId);
		//}
	
	//@Deprecated
	/**
	 * Removes a product from a wishlist
	 * @param product
	 * @param wishlistName
	 */
	//public void removeProduct(Product product, String wishlistName) {
		//wishlistRepository.removeProduct(product, wishlistName);
	//}
	
	/**
	 * Overloaded removeProduct method
	 * @param product
	 * @param accountId
	 */
	
	
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
