package com.qac.sparkle_gardens.repositories.offline;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.WishlistRepository;
import com.qac.sparkle_gardens.util.CreditStatus;

/**
 * 
 * @author Tyler
 *
 */
public class WishlistRepositoryOfflineTest {
	
	@Parameter
	WishlistRepository wishlistRepo = new WishlistRepositoryOffline();
	
	private Customer customer;
	private Product product;
	private Wishlist wish;
	
	@Before
	public void setup() {
		System.out.println("The test has begun...");
		product = new Product("Cookie Gnomonster", 2300, 5.50);
		customer = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
		wish = new Wishlist(customer, product);
		wishlistRepo.persistWishlist(wish);
	}
	
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
	
	@Test
	public void inWishlistShouldReturnValidOutputProductInList() {
		Product gmonster = new Product("Cookie Gnomonster", 2300, 5.50);
		assertTrue(wishlistRepo.inWishlist(gmonster, customer.getAccountID()));
	}
	
	@Test
	/*
	 * This test passes when a wishlist is successfully created
	 */
	public void persistWishlistShouldCreateAWishList() {
		wishlistRepo.persistWishlist(wish);
		/* Assuming the wishlist has been successfully created
		 * inWishlist will return true.
		 */
		assertTrue(wishlistRepo.inWishlist(product, customer.getAccountID()));
	}
	
	@Test
	public void findByAccountIdShouldReturnAWishlist() {
		assertNotNull(wishlistRepo.findByAccountId(customer.getAccountID()));
	}
	
	@Test 
	public void getProductsShouldReturnProducts() {
		assertFalse(wishlistRepo.getProducts(customer.getAccountID()).isEmpty());
	}
	
	@After
	public void teardown() {
		product = null;
		customer = null;
		wish = null;
		System.out.println("The test has ended");
	}

}
