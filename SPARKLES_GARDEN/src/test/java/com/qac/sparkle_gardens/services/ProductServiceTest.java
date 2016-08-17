/**
 * 
 */
package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

//import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.controllers.ProductInterface;
import com.qac.sparkle_gardens.entities.Product;
//import com.qac.sparkle_gardens.repositories.ProductRepository;
//import com.qac.sparkle_gardens.test_data.InitialData;
//import com.qac.sparkle_gardens.test_data.InitialData;

/**
 * @author Annabelle Young
 * 
 * JUnit tests for ProductService class which implements ProductInterface
 * Verify that all functions in ProductService produce valid results
 *
 */
public class ProductServiceTest {
	//@Inject InitialData initialData;
	//@Inject ProductRepository productRepository;
	
	//Product product;
	Product p;
	ProductInterface pi;
	//List<Product> products;
	//InitialData initData;
	
	
	@Before
	public void setup(){
		System.out.println("Setup");
		pi = new ProductService();
		p = new Product("The Great American Challenge", 50, 79.99);
		
	}
	
	/**
	 * This test is checking checkInStock(Product p) to make sure that 'true' is returned if the stock level is greater than 0
	 */	
	@Test
	public void checkInStockShouldReturnValidOutputForInStock() {	
		System.out.println("checkInStockShouldReturnValidOutputForInStock");
		Boolean result = pi.checkInStock(p);
		assertTrue(result);
	}
	
	/**
	 * This test is checking checkInStock(Product p) to make sure that 'false' is returned if the stock level is 0
	 * Retrieve the first product in products list and set its stock level to 0
	 */
	@Test
	public void checkInStockShouldReturnValidOutputForNoStock() {
		System.out.println("checkInStockShouldReturnValidOutputForNoStock");
		//product = products.get(0);
		p.setStockLevel(0);
		Boolean result = pi.checkInStock(p);
		assertFalse(result);
	}
	
	/**
	 * This test is checking checkInStock(Product p) to make sure that IllegalArgumentException is thrown if null is passed into the function
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkInStockShouldThrowIllegalExceptionForNullProduct(){
		System.out.println("checkInStockShouldThrowIllegalExceptionForNullProduct");
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
		System.out.println("checkIfEnoughQuantityShouldReturnValidOutputForEnoughStock");
		Boolean result = pi.checkIfEnoughQuantity(p, 5);
		assertTrue(result);
	}
	
	/**
	 * Verifies that 'false' is returned by checkIfEnoughQuantity if the product does not have enough stock to meet the requested amount
	 * product's stock level is set to 10, so checking if 10 >= 15, which it isn't, so 'false'
	 */
	@Test
	public void checkIfEnoughQuantityShouldReturnValidOutputForNotEnoughStock(){
		System.out.println("checkIfEnoughQuantityShouldReturnValidOutputForNotEnoughStock");
		Boolean result = pi.checkIfEnoughQuantity(p, 55);
		assertFalse(result);
	}
	
	/**
	 * Verifies that Illegal Argument Exception is thrown if null is passed in for Product value
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkIfEnoughQuantityShouldThrowIllegalExceptionForNullProduct(){
		System.out.println("checkIfEnoughQuantityShouldThrowIllegalExceptionForNullProduct");
		pi.checkIfEnoughQuantity(null, 5);
	}
	
	/**
	 * Verifies that Illegal Argument Exception is thrown if 0 is passed in for request
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkIfEnoughQuantityShouldThrowIllegalExceptionForNullRequest(){
		System.out.println("checkIfEnoughQuantityShouldThrowIllegalExceptionForNullRequest");
		pi.checkIfEnoughQuantity(p, 0);
	}
	
	/**
	 * Verifies that Illegal Argument Exception is thrown if negative value is passed in for request
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkIfEnoughQuantityShouldThrowIllegalExceptionForNegativeRequest(){
		System.out.println("checkIfEnoughQuantityShouldThrowIllegalExceptionForNullRequest");
		pi.checkIfEnoughQuantity(p, -1);
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
		System.out.println("getProductByIDShouldThrowIllegalExceptionForNullID");
		pi.getProductByID(0);
	}
	
	
	
	/**
	 * Verifies that true is returned if minimumPrice value entered
	 * is not greater than maximumPrice value entered
	 */	
	@Test
	public void checkIfMinAndMaxAreValidShouldReturnValidOutputForValidInput(){
		System.out.println("checkIfMinAndMaxAreValidShouldReturnValidOutputForValidInput");
		boolean result = pi.checkIfMinAndMaxAreValid(10.00, 20.00);
		assertTrue(result);
	}
	
	/**
	 * Verifies that false is returned if minimumPrice value entered
	 * is greater than maximumPrice value entered
	 */	
	@Test
	public void checkIfMinAndMaxAreValidShouldReturnValidOutputForMaxLessThanMin(){
		System.out.println("checkIfMinAndMaxAreValidShouldReturnValidOutputForMaxLessThanMin");
		boolean result = pi.checkIfMinAndMaxAreValid(20.00, 10.00);
		assertFalse(result);
	}
	
	/**
	 * Verifies that false is returned if minimumPrice value entered is negative
	 */	
	@Test
	public void checkIfMinAndMaxAreValidShouldReturnValidOutputForNegativeMinimum(){
		System.out.println("checkIfMinAndMaxAreValidShouldReturnValidOutputForNegativeMinimum");
		boolean result = pi.checkIfMinAndMaxAreValid(-10.00, 20.00);
		assertFalse(result);
	}
	
	/**
	 * Verifies that false is returned if maximumPrice value entered is negative
	 */	
	@Test
	public void checkIfMinAndMaxAreValidShouldReturnValidOutputForNegativeMaximum(){
		System.out.println("checkIfMinAndMaxAreValidShouldReturnValidOutputForNegativeMaximum");
		boolean result = pi.checkIfMinAndMaxAreValid(10.00, -20.00);
		assertFalse(result);
	}
	
	/**
	 * Verifies that false is returned if products are added to list
	 * result will be false if the resultList is empty
	 */
	@Test
	public void createProductListByPriceRangeShouldAddProductInPriceRange(){
		System.out.println("createProductListByPriceRangeShouldAddProductInPriceRange");
		List<Product> resultList = pi.createProductListByPriceRange(10.00, 80.00);
		boolean result = resultList.isEmpty();
		//boolean result = (pi.createProductListByPriceRange(10.00, 80.00)).isEmpty();
		assertFalse(result);
	}
	
	@Test
	public void getProductListShouldReturnSomething(){
		pi.getProductList();
		//boolean result = (pi.getProductList()).isEmpty();
		//assertFalse(result);
	}
	
	/**
	 * Verifies that false is returned if products are added to list
	 * result will be false if the resultList is empty
	 */
	/*@Test
	public void createProductListByPriceRangeShouldAddProductInPriceRange(){
		System.out.println("createProductListByPriceRangeShouldAddProductInPriceRange");
		List<Product> resultList = pi.createProductListByPriceRange(10.00, 80.00);
		boolean result = resultList.isEmpty();
		assertFalse(result);
	*/
	@After
	public void teardown(){
		System.out.println("Teardown");
		//product = null;
		pi = null;
		//products.clear();
		p = null;
	}
	
	
}




























