/**
 * 
 */
package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qac.sparkle_gardens.controllers.ProductInterface;
import com.qac.sparkle_gardens.entities.Product;

/**
 * @author Annabelle Young
 *
 */
public class ProductServiceTest {

	@Test
	public void checkInStockShouldReturnValidOutput() {
		ProductInterface pi = new ProductService();
		Product product = new Product("The Great American Challenge", 50, 79.99); 
		Boolean result = pi.checkInStock(product);
		assertNotNull(result);
		assertEquals(true, result);
	}

}
