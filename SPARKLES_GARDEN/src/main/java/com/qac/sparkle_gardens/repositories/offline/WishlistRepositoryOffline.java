package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.WishlistRepository;
import com.qac.sparkle_gardens.test_data.InitialData;

/**
 * 
 * @author Tyler Deans
 *
 */
@Stateless
@Default
public class WishlistRepositoryOffline implements WishlistRepository{
	@Inject private InitialData initialData;
	
	/**
	 * @param Wishlist wishlist
	 * 
	 * Add a wishlist
	 */
	public void persistWishlist(Wishlist wishlist) {
		initialData.addWishlist(wishlist);
	}
	
	public void persistWishlists(List<Wishlist> wishlists) {
		initialData.setWishlists(wishlists);
	}
	/**
	 * Finds a wishlist according to the wishlist ID
	 * @param id
	 * @return
	 */
	public Wishlist findById(long id) {
		List<Wishlist> list = initialData.getWishlists();
		Wishlist wish = new Wishlist();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getWishlistId() == id) {
				wish = list.get(index);
			}
		}
		return wish;
	}
	
	/**
	 * Finds a wishlist according to the account ID
	 * @param id
	 * @return
	 */
	public Wishlist findByAccountId(long id) {
		List<Wishlist> list = initialData.getWishlists();
		Wishlist wish = new Wishlist();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getAccountId() == id) {
				wish = list.get(index);
			}
		}
		return wish;
	}
	
	/**
	 * Finds a wishlist according to the name of the wishlist
	 * @param name
	 * @return
	 */
	public Wishlist findByName(String name) {
		List<Wishlist> list = initialData.getWishlists();
		Wishlist wish = new Wishlist();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getWishlistName().equals(name)) {
				wish = list.get(index);
			}
		}
		return wish;
	}
	/**
	 * This method adds a product to the wishlist
	 * @param product
	 * @param wishId
	 */
	public void addProductToList(Product product, long wishId) {
		// Creates a wishlist object based on the given ID
		Wishlist aList = findById(wishId); 
		aList.addProduct(product); // adds the product to the list
		updateWishlist(aList); // updates the original list with the updated lists
	}
	/**
	 * This method adds a product to the wishlist according to the name 
	 *  of the wishlist
	 * @param product
	 * @param name
	 */
	public void addProductToList(Product product, String name) {
		// Creates a wishlist object based on the given ID
		Wishlist aList = findByName(name); 
		aList.addProduct(product); // adds the product to the list
		updateWishlist(aList); // updates the original list with the updated lists
	}
	
	/**
	 * Removes a product from a wishlist
	 * @param product
	 * @param name
	 */
	public void removeProduct(Product product, String name) {
		Wishlist aList = findByName(name);
		aList.removeProduct(product);
		updateWishlist(aList);
	}
	
	/**
	 * Overloaded removeProduct method
	 * @param product
	 * @param accountId
	 */
	public void removeProduct(Product product, long accountId) {
		Wishlist aList = findByAccountId(accountId);
		aList.removeProduct(product);
		updateWishlist(aList);
	}
	
	/**
	 * Checks if a given product is in a wishlist
	 * @param product
	 * @param accountId
	 */
	public boolean inWishlist(Product product, long accountId) {
		Wishlist list = findByAccountId(accountId);
		if (list.inWishlist(product.getProductID())) {
			return true;
		}
		
		return false;
	}
	
	// Read all the wishlists
	public List<Wishlist> getWishlists() {
		return initialData.getWishlists();
	}
	
	// Update wishlist
	public void updateWishlist(Wishlist wish) {
		List<Wishlist> list = initialData.getWishlists();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).equals(wish)) {
				list.set(index, wish);
			}
		}
		initialData.setWishlists(list);
	}
	//Remove wishlist
	public void removeWishlist(Wishlist wish) {
		List<Wishlist> list = initialData.getWishlists();
	
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).equals(wish)) {
				list.remove(index);
			}
		}
		initialData.setWishlists(list);
	}
	
	/**
	 * Returns all the products in a wishlist
	 * @param wishlist
	 */
	public List<Product> getProducts(String wishlistName) {
		Wishlist list = findByName(wishlistName);
		return list.getProducts();
	}
	
}
