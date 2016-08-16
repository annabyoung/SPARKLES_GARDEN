package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import com.qac.sparkle_gardens.controllers.WishlistServiceInterface;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

import junit.framework.TestCase;
public class WishlistServiceTest extends TestCase {

	@Test
	public void checkCreateWishlist() {
		WishlistServiceInterface wish = new WishlistService();
		List<Product> products = new ArrayList<Product>();
	}
}
