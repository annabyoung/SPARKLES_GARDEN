package com.qac.sparkle_gardens.repositories;

import java.util.List;
import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Wishlist;

public interface AddressRepository {
	public void persistWishlist(Wishlist wishlist);
	public void persistWishlists(List<Wishlist> wishlists);
	// Locate an address by ID
	public Address findById(long id); 
	
	// Returns all the addresses
	public List<Address> getAddress();
	
	// Update as address
	public void updateAddress(Address address);
	//Remove address
	public void removeAddress(Address address);
}
