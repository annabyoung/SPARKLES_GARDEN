/**
 * 
 */
package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.controllers.ProductInterface;
import com.qac.sparkle_gardens.repositories.ProductRepository;

/**
 * @author Annabelle Young
 *
 * The various services associated with Product are defined here
 * Stock is checked for in stock or if there's enough stock to meet a customer's request
 *
 */

@Stateless
public class ProductService implements ProductInterface{

	@Inject 
	private ProductRepository productRepository;
	
	private List<String> tags = new ArrayList<String>();
	
		
	/**
	 * If the product has enough stock to meet the request, return true and decrement stock
	 * if the product does not have enough stock to meet orderline's request, output error message
	 * 
	 * Additional functionality to be added later
	 * 
	 * stock is decremented when order is being finalized, 
	 * as soon as customer pushes 'checkout'
	 * stock is returned if customer cancels order, or removes items from order
	 * stock should be returned if customer doesn't complete order within a certain time frame
	 * 
	 *
	 * Decrement stock when order is being finalized
	 */
	@Deprecated
	public void decrementProductQuantity(Product p, int quantityRequest){
		if (checkIfEnoughQuantity(p, quantityRequest)){
			p.setStockLevel(p.getStockLevel() - quantityRequest);
		}
	}
	
	
	/**
	 * Check if the product is in stock, if it's not then a message should display
	 * to let the customer know that it is back order
	 * 
	 */
	public boolean checkInStock(Product p){
		if (p.getStockLevel() == 0)
		/**
		 * Need to consult with Chris and Luke about further details for what exactly they want to happen
		 */
			return false;
		return true;
	}
	
	/**
	 * Retrieve product's info from productID
	 * Find the product from its ID and return its description
	 */
	public String getProductDescriptionFromID(long productID){
		Product p = getProductByID(productID);
		return p.getProductDescription();
	}
	
	/**
	 * Check if the quantity request exceeds product's stocklevel/quantity 
	 * if the stock level is less than or equal to quantity requested, true will be returned
	 * if there is not enough stock to meet the quantity requested, false will be returned
	 */
	public boolean checkIfEnoughQuantity(Product p, int quantityRequested){
		return (p.getStockLevel() <= quantityRequested);
	}
	
	/**
	 * 
	 * Use a product's ID to find the whole product, including its other attributes
	 */
	public Product getProductByID(long productID){
		return productRepository.findByProductID(productID);
	}

	/**
	 * Verify that minimum price entered is not larger than maximum price
	 * Verify that minimum price and maximum price entered are not negative
	 */
	public boolean checkIfMinAndMaxAreValid(double minimumPrice, double maximumPrice){
		if (minimumPrice > maximumPrice || Double.compare(minimumPrice, 0.0) < 0 || Double.compare(maximumPrice, 0.0) < 0){
			return false;
		}
		return true;
	}
	/**
	 * Search for items within a price range entered
	 * @param minimumPrice
	 * @param maximumPrice
	 * @return productsInRange which is all the products within the price range the customer is searching for
	 */
	public List<Product> createProductListByPriceRange(double minimumPrice, double maximumPrice){		
		List<Product> productsInRange = new ArrayList<Product>();
		//List<Product> pl = productRepository.getProducts();
		for(Product p : productRepository.getProducts()){
			if(p.getPrice() >= minimumPrice && p.getPrice() <= maximumPrice){
				productsInRange.add(p);
			}
		}
//		productList.addAll(productsInRange);
		return productsInRange;
	}
	
	/**
	 * Search for items with all of the requested tags 
	 * This checks for products that contain all of the tags a customer is searching for
	 * These are to be displayed first for the customer
	 * 
	 * Search for items with one or more of the requested tags
	 * This checks for products that contain some of the tags a customer is searching for
	 * These are to be displayed after the products that contain all of the tags requested
	 * 
	 * May implement sorting items by those with most tags in common with search request
	 * 
	 * @param input
	 * @return productsWithTags
	 */

	
	/*public List<Product> createProductListWithAllTags(String input){
		if(input.isEmpty() || input == null){
			throw new IllegalArgumentException();
		}
		List<String> tagsToSearch = new ArrayList<String>(Arrays.asList(tag.split(" ")));
		//tags = convertStringToArrayList(input);
		List<Product> productsWithTags = new ArrayList<Product>();
		List<Product> productsWithAllTags = new ArrayList<Product>();
		List<Product> productsWithSubsetOfTags = new ArrayList<Product>();
		for(Product p : productRepository.getProducts()){
			if (p.getProductTags().containsAll(tags)){
				productsWithAllTags.add(p);
			} else if (!Collections.disjoint(p.getProductTags(), tags)){
				productsWithSubsetOfTags.add(p);
			}
		}
		productList.addAll(productsWithTags);
		productsWithTags.addAll(productsWithAllTags);
		productsWithTags.addAll(productsWithSubsetOfTags);
		return productsWithTags;
	}
	*/
	
	/**
	 * Search for items with all of the requested tags 
	 * This checks for products that contain all of the tags a customer is searching for
	 * Returns a list of all products that contain all of the tags searched for
	 */
	public List<Product> createProductListWithAllTags(String input){
		if(input.isEmpty()){
			throw new IllegalArgumentException();
		}
		tags = convertStringToArrayList(input);
		List<Product> productsWithAllTags = new ArrayList<Product>();
		for(Product p : productRepository.getProducts()){
			if (p.getProductTags().containsAll(tags)){
				productsWithAllTags.add(p);
			} 
		}
		return productsWithAllTags;
		
	}
	
	/**
	 * Search for items with one or more of the requested tags
	 * This checks for products that contain some of the tags a customer is searching for
	 * Returns a list of all products that contain one or more of the tags searched for
	 */
	public List<Product> createProductListWithSomeTags(String input){
		if(input.isEmpty() || input == null){
			throw new IllegalArgumentException();
		}
		tags = convertStringToArrayList(input);
		List<Product> productsWithSubsetOfTags = new ArrayList<Product>();
		for(Product p : productRepository.getProducts()){
			if (!Collections.disjoint(p.getProductTags(), tags)){
				productsWithSubsetOfTags.add(p);
			}
		}
		return productsWithSubsetOfTags;
	}
	
	
	/**
	 * 
	 * Customer enters into the search bar a string (i.e. "Blue Gnome")
	 * String will be split and put into arraylist so that both "blue" and "gnome" will be searched for as product tags
	 * ArrayList is returned so that findProducts() can use .containsAll() 
	 * 
	 * @param tags
	 * @return tagsToSearch
	 */
	
	public List<String> convertStringToArrayList(String tag){
		List<String> tagsToSearch = new ArrayList<String>(Arrays.asList(tag.split(" ")));
		
		return tagsToSearch;
	}
	
	/**
	 * If there are no results containing any of the tags searched, return false 
	 * Else if there are no results containing all tags searched, but results with some tags, return true
	 * Otherwise return true
	 * 
	 * @param productsWithTags
	 * @return false, true
	 */
	
	public boolean validateResultsOfSearch(List<Product> productList){
		if (productList.isEmpty()){
			return false;
		}
		return true;
	}
	
	/**
	 * Return the list of all products that meet the search parameters
	 */
//	public List<Product> getProductList(){
//		//There should be a query here, but we're not at that point yet
//		return productList;
//	}
	
	/**
	 * Clears the search query
	 */
//	public void clearSearchQuery(){
//		productList.clear();
//	}


	@Override
	public List<Product> createProductListByTags(String input) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void clearSearchQuery() {
		// TODO Auto-generated method stub
		
	}


}
