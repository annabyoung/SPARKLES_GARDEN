package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.util.CreditStatus;

/**
 * 
 * @author Tyler Deans
 * Creates dummy data for the wishlist repository
 *
 */
@Singleton
public class WishlistInitialData {
	private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	private List<Product> products = new ArrayList<Product>();
	private Customer customer4 = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
	// adds dummy data into the wishlists list
	public WishlistInitialData() {
		products.add(new Product("Cookie Gnomonster", 2300, 5.50));
		products.add(new Product("Gnomzilla", 5000, 6.00));
	    wishlists.add(new Wishlist(customer4, products));
	}
	
	public List<Wishlist> getWishlists() {
		return wishlists;
	}
	
	public void addWishlist(Wishlist wishlist) {
		wishlists.add(wishlist);
	}
	
	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}
}
