package com.qac.sparkle_gardens.util;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

/**
 * 
 * @author Tyler Deans
 * Creates dummy data for the wishlist repository
 *
 */
@Singleton
public class WishlistInitialData {
	private ArrayList<Wishlist> wishlists = new ArrayList<Wishlist>();
	private ArrayList<Product> products = new ArrayList<Product>();
	
	// adds dummy data into the wishlists list
	public WishlistInitialData() {
		products.add(new Product("Cookie Gnomonster", 2300, 5.50));
		products.add(new Product("Gnomzilla", 5000, 6.00));
		
		wishlists.add(new Wishlist((long) 24, products));
		wishlists.add(new Wishlist((long) 25, products));
	}
	
	public ArrayList<Wishlist> getWishlists() {
		return wishlists;
	}
	
	public void addWishlist(Wishlist wishlist) {
		wishlists.add(wishlist);
	}
	
	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = (ArrayList<Wishlist>) wishlists;
	}
}
