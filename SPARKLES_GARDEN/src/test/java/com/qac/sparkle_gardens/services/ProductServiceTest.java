/**
 * 
 */
package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

//import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
=======
>>>>>>> a0f8dbfaebece88cde011b8538a7caf32abec5ea
import org.junit.Test;

import com.qac.sparkle_gardens.controllers.ProductInterface;
import com.qac.sparkle_gardens.entities.Product;
<<<<<<< HEAD
//import com.qac.sparkle_gardens.repositories.ProductRepository;
//import com.qac.sparkle_gardens.test_data.InitialData;
//import com.qac.sparkle_gardens.test_data.InitialData;
=======
>>>>>>> a0f8dbfaebece88cde011b8538a7caf32abec5ea

/**
 * @author Annabelle Young
 *
 */
public class ProductServiceTest {
<<<<<<< HEAD
	//@Inject InitialData initialData;
	//@Inject ProductRepository productRepository;
	
	//Product product;
	Product p;
	ProductInterface pi;
	List<Product> resultList;
	//InitialData initData;
	
	
	@Before
	public void setup(){
		System.out.println("Setup");
		pi = new ProductService();
		p = new Product("The Great American Challenge", 50, 79.99, "/images/gnome0.jpg");
		resultList = new ArrayList<>();
		
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
=======

>>>>>>> a0f8dbfaebece88cde011b8538a7caf32abec5ea
	@Test
	public void checkInStockShouldReturnValidOutput() {
		ProductInterface pi = new ProductService();
<<<<<<< HEAD
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
	 * Verifies that true is returned if products are added to list
	 * result will be true if list is not empty
	 */
	@Test
	public void createProductListByPriceRangeShouldReturnNotEmptyListForProductsInRange(){
		System.out.println("createProductListByPriceRangeShouldReturnNotEmptyListForProductsInRange");
		List<Product> resultList = pi.createProductListByPriceRange(10.00, 80.00);
		boolean result = !(resultList.isEmpty());
		//boolean result = (pi.createProductListByPriceRange(10.00, 80.00)).isEmpty();
		assertTrue(result);
	}
	
	
	/**
	 * Verifies that false is returned if no products are added to list
	 * result will be false if the resultList is empty
	 */
	@Test
	public void createProductListByPriceRangeShouldReturnEmptyListForNoProductsInRange(){
		System.out.println("createProductListByPriceRangeShouldReturnEmptyListForNoProductsInRange");
		resultList = pi.createProductListByPriceRange(300.00, 400.00);
		boolean result = !(resultList.isEmpty());
		assertFalse(result);
	}
	
	/**
	 * Product Initial Data only contains three items that are within the price range of 10.00 and 80.00
	 * The Great American Challenge at 79.99, Power Bullet at 24.99 and The Screaming O at 19.99
	 * The result list should then only contain 3 items, test will pass if the list's size is 3
	 */
	@Test
	public void createProductListByPriceRangeShouldReturnListContainingOnlyProductsWithinRange(){
		System.out.println("createProductListByPriceRangeShouldReturnListContainingOnlyProductsWithinRange");
		resultList = pi.createProductListByPriceRange(10.00, 80.00);
		assertEquals(resultList.size(), 3);
	}
	
	
	/**
	 * createProductListWithAllTags should throw illegal argument exception for empty String
	 */
	@Test(expected = IllegalArgumentException.class)
	public void createProductListWithAllTagsShouldThrowIllegalExceptionForEmptyString(){
		System.out.println("createProductListWithAllTagsShouldThrowIllegalExceptionForEmptyString");
		pi.createProductListWithAllTags("");
	}
	
	/**
	 * Returned list should not be empty if there are products matching all tags searched for
	 */
	@Test
	public void createProductListWithAllTagsShouldReturnNotEmptyListForValidInput(){
		System.out.println("createProductListWithAllTagsShouldReturnNotEmptyListForValidInput");
		resultList = pi.createProductListWithAllTags("dildo dong american challenge");
		boolean result = !(resultList.isEmpty());
		assertTrue(result);
	}
	
	/**
	 * Returned list should be empty if there are no products matching all tags searched for
	 */
	@Test
	public void createProductListWithAllTagsShouldReturnEmptyListForInvalidInput(){
		System.out.println("createProductListWithAllTagsShouldReturnEmptyListForInvalidInput");
		resultList = pi.createProductListWithAllTags("dildo dong american challenge poop");
		boolean result = !(resultList.isEmpty());
		assertFalse(result);
	}
	
	/**
	 * Returned list should only contain products matching all tags searched for
	 */
	@Test
	public void createProductListWithAllTagsShouldOnlyContainItemsWithAllTags(){
		System.out.println("createProductListWithAllTagsShouldOnlyContainItemsWithAllTags");
		resultList = pi.createProductListWithAllTags("vibrating multi_speed");
		assertEquals(resultList.size(), 2);
	}
	
	/**
	 * createProductListWithSomeTags should throw illegal argument exception for empty String
	 */
	@Test(expected = IllegalArgumentException.class)
	public void createProductListWithSomeTagsShouldThrowIllegalExceptionForEmptyString(){
		System.out.println("createProductListWithAllTagsShouldThrowIllegalExceptionForEmptyString");
		pi.createProductListWithSomeTags("");
	}
	
	
	/*
	@Test
	public void convertStringToArrayListShouldReturnValidOutput(){
		System.out.println("convertStringToArrayListShouldReturnValidOutput");
		resultList
		
	}
	
	*/
	
	@After
	public void teardown(){
		System.out.println("Teardown");
		//product = null;
		pi = null;
		//products.clear();
		p = null;
		resultList.clear();
	}
	
	
}



























=======
		Product product = new Product("The Great American Challenge", 50, 79.99); 
		Boolean result = pi.checkInStock(product);
		assertNotNull(result);
		assertEquals(true, result);
	}
>>>>>>> a0f8dbfaebece88cde011b8538a7caf32abec5ea

}
