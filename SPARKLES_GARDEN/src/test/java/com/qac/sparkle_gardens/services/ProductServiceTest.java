/**
 * 
 */
package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.qac.sparkle_gardens.controllers.ProductInterface;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.ProductRepository;

/**
 * @author Annabelle Young
 * 
 * JUnit tests for ProductService class which implements ProductInterface
 * Verify that all functions in ProductService produce valid results
 *
 */
public class ProductServiceTest {
	//@Inject ProductRepository productRepository;
	
	private Product product = new Product("The Great American Challenge", 10, 79.99);
	ProductInterface pi = new ProductService();
	
	/**
	 * This test is checking checkInStock(Product p) to make sure that 'true' is returned if the stock level is greater than 0
	 */	
	@Test
	public void checkInStockShouldReturnValidOutputForInStock() {		
		Boolean result = pi.checkInStock(product);
		assertTrue(result);
	}
	
	/**
	 * This test is checking checkInStock(Product p) to make sure that 'false' is returned if the stock level is 0
	 */
	@Test
	public void checkInStockShouldReturnValidOutputForNoStock() {
		product.setStockLevel(0);
		Boolean result = pi.checkInStock(product);
		assertFalse(result);
	}
	
	/**
	 * This test is checking checkInStock(Product p) to make sure that IllegalArgumentException is thrown if null is passed into the function
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkInStockShouldThrowIllegalExceptionForNullProduct(){
		pi.checkInStock(null);		
	}
	/*
	@Deprecated
	@Test
	public void getProductDescriptionFromIDShouldReturnDescription(){
		ProductInterface pi = new ProductService();
		
		String result = pi.getProductDescriptionFromID(product.getProductID());
		assertEquals("This is a massive dildo", result);
	}
	
	@Deprecated
	@Test(expected = IllegalArgumentException.class)
	public void getProductDescriptionFromIDShouldThrowIllegalExceptionForNullID(){
		ProductInterface pi = new ProductService();
		pi.getProductDescriptionFromID(0);
	}
	*/
	
	/**
	 * Verifies that 'true' is returned by checkIfEnoughQuantity if the product has enough stock to meet the requested amount
	 * product's stock level is set to 10, so checking if 10 >= 5, which it is, so 'true'
	 */
	@Test
	public void checkIfEnoughQuantityShouldReturnValidOutputForEnoughStock(){
		Boolean result = pi.checkIfEnoughQuantity(product, 5);
		assertTrue(result);
	}
	
	/**
	 * Verifies that 'false' is returned by checkIfEnoughQuantity if the product does not have enough stock to meet the requested amount
	 * product's stock level is set to 10, so checking if 10 >= 15, which it isn't, so 'false'
	 */
	@Test
	public void checkIfEnoughQuantityShouldReturnValidOutputForNotEnoughStock(){
		Boolean result = pi.checkIfEnoughQuantity(product, 15);
		assertFalse(result);
	}
	
	/**
	 * Verifies that Illegal Argument Exception is thrown if null is passed in for Product value
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkIfEnoughQuantityShouldThrowIllegalExceptionForNullProduct(){
		pi.checkIfEnoughQuantity(null, 5);
	}
	
	/**
	 * Verifies that Illegal Argument Exception is thrown if 0 is passed in for request
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkIfEnoughQuantityShouldThrowIllegalExceptionForNullRequest(){
		pi.checkIfEnoughQuantity(product, 0);
	}
	
	
	/**
	 * Verifies that long productID value passed into getProductById is not 0
	 */
	/*
	 * Currently there is no database, so ID's are unknown, thus can't verify that passing in an ID returns a product
	@Test(expected = IllegalArgumentException.class)
	public void getProductByIDShouldReturnProduct(){
		pi.getProductByID(1);
	}
	*/
	
	/**
	 * Verifies that long productID value passed into getProductById is not 0
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getProductByIDShouldThrowIllegalExceptionForNullID(){
		pi.getProductByID(0);
	}
	
	/**
	 * Verifies that minimumPrice value entered is not greater than maximumPrice value entered
	 */
	@Test(expected = IllegalArgumentException.class)
	public void createProductListByPriceRangeShouldThrowIllegalArgumentExceptionForMinGreaterThanMax(){
		pi.createProductListByPriceRange(20.00, 10.00);
	}
	
}




























