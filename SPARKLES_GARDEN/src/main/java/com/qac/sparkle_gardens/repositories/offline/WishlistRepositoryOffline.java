package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.WishlistRepository;
/**
 * 
 * @author Tyler Deans
 *
 */
public class WishlistRepositoryOffline implements WishlistRepository{
	private WishlistInitialData initialData;
	
	public void persistWishlist(Wishlist wishlist) {
		initialData.addWishlist(wishlist);
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
