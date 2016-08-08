package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.WishlistRepository;

/**
 * 
 * @author Tyler Deans
 *
 */

public class WishlistRepositoryOffline implements WishlistRepository{
	@Inject private WishlistInitialData initialData;
	
	/**
	 * @param Wishlist wishlist
	 * 
	 * Add a wishlist
	 */
	public void persistWishlist(Wishlist wishlist) {
		initialData.addWishlist(wishlist);
	}
	
	public void persistWishlists(List<Wishlist> wishlists) {
		
	}
	/**
	 * Finds a wishlist according to the ID
	 * @param id
	 * @return
	 */
	public Wishlist findById(long id) {
		ArrayList<Wishlist> list = initialData.getWishlists();
		Wishlist wish = new Wishlist();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getWishlistId() == id) {
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
	// Read all the wishlists
	public ArrayList<Wishlist> getWishlists() {
		return initialData.getWishlists();
	}
	
	// Update wishlist
	public void updateWishlist(Wishlist wish) {
		ArrayList<Wishlist> list = initialData.getWishlists();
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).equals(wish)) {
				list.set(index, wish);
			}
		}
		initialData.setWishlists(list);
	}
	//Remove wishlist
	public void removeWishlist(Wishlist wish) {
		ArrayList<Wishlist> list = initialData.getWishlists();
	
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).equals(wish)) {
				list.remove(index);
			}
		}
		initialData.setWishlists(list);
	}
	
}
