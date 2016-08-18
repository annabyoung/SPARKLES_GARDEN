package com.qac.sparkle_gardens.repositories.offline;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.qac.sparkle_gardens.repositories.WishlistRepository;

public class WishlistRepositoryTest {
	
	@Parameter
	WishlistRepository wishlistRepo = new WishlistRepositoryOffline();
	
	@Test(expected = IllegalArgumentException.class)
	public void persistWishlistShouldThrowIllegalExceptionForNullWishlist() {
		wishlistRepo.persistWishlist(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void persistWishlistsShouldThrowIllegalExceptionForNullWishlistArrayList() {
		wishlistRepo.persistWishlists(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findByIdShouldThrowIllegalExceptionForInvalidWishlistId() {
		wishlistRepo.findById(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findByAccountIdShouldThrowIllegalExceptionForInvalidAccountId() {
		wishlistRepo.findByAccountId(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addProductToListShouldThrowIllegalExceptionForInvalidInputs() {
		wishlistRepo.addProductToList(null, 69);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addProductToListWithAcctIdShouldThrowIllegalExceptionForInvalidInputs() {
		wishlistRepo.addProductToListWithAcctId(null, 69);
	}
	

}
