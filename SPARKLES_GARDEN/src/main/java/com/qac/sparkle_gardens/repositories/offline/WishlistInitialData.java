package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

public class WishlistInitialData {
	private ArrayList<Wishlist> wishlists = new ArrayList<Wishlist>();
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public WishlistInitialData() {
		products.add(new Product("Cookie Gnomonster", 2300, (float)5.50));
		products.add(new Product("Gnomzilla", 5000, (float)6.00));
		
		wishlists.add(new Wishlist("CM024", products));
		wishlists.add(new Wishlist("CM025", products));
	}
	
	public ArrayList<Wishlist> getWishlists() {
		return wishlists;
	}
	
	public void addWishlist(Wishlist wishlist) {
		wishlists.add(wishlist);
	}
	
	public void setWishlists(ArrayList<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}
}
