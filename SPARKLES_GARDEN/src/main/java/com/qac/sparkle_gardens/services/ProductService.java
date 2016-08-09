/**
 * 
 */
package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.ProductRepository;

/**
 * @author Annabelle Young
 *
 * The various services associated with Product are defined here
 * Stock is checked for in stock or if there's enough stock to meet a customer's request
 *
 */

@Stateless
public class ProductService {
	@Inject ProductRepository productRepository;
		
	/**
	 * Add item to wishlist
	 */
	public void addItemToWishlist(Product p, Wishlist wishlist){
		
	}
	
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
	 * Search items within a price range
	 * @param minimumPrice
	 * @param maximumPrice
	 * @return prodcutsInRange which is all the products within the price range the customer is searching for
	 */
	public ArrayList<Product> findProductsByPriceRange(double minimumPrice, double maximumPrice){		
		ArrayList<Product> productsInRange = new ArrayList<>();
		for(Product p : productRepository.getProducts()){
			if(p.getPrice() >= minimumPrice && p.getPrice() <= maximumPrice){
				productsInRange.add(p);
			}
		}
		return productsInRange;
	}
	
	/**
	 * Search for items with all of the requested tags 
	 * This checks for products that contain all of the tags a customer is searching for
	 * An arrayList of products with all tags is returned, these are to be displayed first for the customer
	 * 
	 * @param tags
	 * @return productsWithAllTags
	 */
	public ArrayList<Product> findProductsWithAllTags(ArrayList<String> tags){
		ArrayList<Product> productsWithAllTags = new ArrayList<>();
		for(Product p : productRepository.getProducts()){
			if (p.getProductTags().containsAll(tags)){
				productsWithAllTags.add(p);
			}
		}
		findProductsWithSubsetOfTags(tags);
		return productsWithAllTags;
	}
	
	/**
	 * Search for items with some of the requested tags
	 * This checks for products that contain some of the tags a customer is searching for
	 * An arrayList of products that have some of the requested tags is returned, these are to be displayed after
	 * the products that contain all of the tags requested
	 * 
	 * May implement sorting items by those with most tags in common with search request
	 * 
	 * @param tags
	 * @return productsWithSubsetOfTags
	 */
	public ArrayList<Product> findProductsWithSubsetOfTags(ArrayList<String> tags){
		ArrayList<Product> productsWithSubsetOfTags = new ArrayList<>();
		for(Product p : productRepository.getProducts()){
			if(!Collections.disjoint(p.getProductTags(), tags)){
				productsWithSubsetOfTags.add(p);
			}
		}
		return productsWithSubsetOfTags;
	}
	
	/**
	 * Put all products matching search results into one arraylist<product>
	 * 
	 * @param productsWithAllTags
	 * @param productsWithSubsetOfTags
	 * @return searchResults
	 */
	public ArrayList<Product> mergeSearchResults(ArrayList<Product> productsWithAllTags, ArrayList<Product> productsWithSubsetOfTags){
		ArrayList<Product> searchResults = new ArrayList<>();
		searchResults.addAll(productsWithAllTags);
		searchResults.addAll(productsWithSubsetOfTags);
		return searchResults;
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
	public ArrayList<String> convertStringToArrayList(String tags){
		ArrayList<String> tagsToSearch = new ArrayList<String>(Arrays.asList(tags.split(" ")));
		
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
	
	public boolean validateResultsOfSearch(ArrayList<Product> productsWithTags){
		if (productsWithTags.isEmpty()){
			return false;
		}
		return true;
	}
	
	/*public boolean resultsForSearch(ArrayList<String> productsWithAllTags, ArrayList<String> productsWithSubsetOfTags){
		if (productsWithAllTags.isEmpty() && productsWithSubsetOfTags.isEmpty()){
			System.out.println("Could not find any products with any of the tags you requested.");
			return false;
		}
		else if(productsWithAllTags.isEmpty()){
			System.out.println("Could not find any products with all tags you requested.");
			return true;
		}
		return true;
	}
*/
}
