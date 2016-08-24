package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.WishlistRepository;
import com.qac.sparkle_gardens.test_data.WishlistInitialData;

/**
 * 
 * @author Tyler Deans
 *
 */
@Stateless
@Default
public class WishlistRepositoryOffline implements WishlistRepository{
	@Inject private WishlistInitialData initialData = new WishlistInitialData();
	
	/**
	 * @param Wishlist wishlist
	 * 
	 * Add a wishlist
	 */
	public void persistWishlist(Wishlist wishlist) {
		if (wishlist == null) {
			throw new IllegalArgumentException();
		}
		
		initialData.addWishlist(wishlist);
	}
	
	public void persistWishlists(List<Wishlist> wishlists) {
		if (wishlists == null) {
			throw new IllegalArgumentException();
		}
		
		initialData.setWishlists(wishlists);
	}
	
	// Read all the wishlists
		public List<Wishlist> getWishlists() {
			return initialData.getWishlists();
		}

	/**
	 * Finds a wishlist according to the wishlist ID
	 * @param id
	 * @return
	 */
	public Wishlist findById(long id) {
		if (id <= 0) {
			throw new IllegalArgumentException();
		}
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
		if (id <= 0) {
			throw new IllegalArgumentException();
		}
		
		List<Wishlist> list = initialData.getWishlists();
		Wishlist wish = new Wishlist();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getCustomer().getAccountID() == id) {
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
		if (wishId <= 0 || product == null) {
			throw new IllegalArgumentException();
		}
		// Creates a wishlist object based on the given ID
		Wishlist aList = findById(wishId); 
		aList.addProduct(product); // adds the product to the list
		updateWishlist(aList); // updates the original list with the updated lists
	}
	
	public void addProductToListWithAcctId(Product product, long acctId) {
		if (product == null || acctId <= 0) {
			throw new IllegalArgumentException();
		}
		// Creates a wishlist object based on the given ID
		Wishlist aList = findByAccountId(acctId); 
		aList.addProduct(product); // adds the product to the list
		updateWishlist(aList); // updates the original list with the updated lists
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
		if (list.inWishlist(product.getProductName())) {
			return true;
		}
		
		return false;
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
	
	public List<Product> getProducts(long accountId) {
		Wishlist list = findByAccountId(accountId);
		return list.getProducts();
	}
	
	//@Deprecated
		/**
		 * No longer necessary
		 * Finds a wishlist according to the name of the wishlist
		 * @param name
		 * @return
		 */
		//public Wishlist findByName(String name) {
			//List<Wishlist> list = initialData.getWishlists();
			//Wishlist wish = new Wishlist();
			//for (int index = 0; index < list.size(); index++) {
				//if (list.get(index).getWishlistName().equals(name)) {
					//wish = list.get(index);
				//}
			//}
			//return wish;
		//}
	
}
