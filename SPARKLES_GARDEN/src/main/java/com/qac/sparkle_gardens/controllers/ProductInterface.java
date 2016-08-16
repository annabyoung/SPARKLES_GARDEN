/**
 * 
 */
package com.qac.sparkle_gardens.controllers;

import java.util.ArrayList;
import java.util.List;

import com.qac.sparkle_gardens.entities.Product;

/**
 * @author Annabelle Young
 *
 */
public interface ProductInterface {
	public boolean checkInStock(Product p);
	public String getProductDescriptionFromID(long productID);
	public boolean checkIfEnoughQuantity(Product p, int quantityRequested);
	public Product getProductByID(long productID);
	public boolean checkIfMinIsLessThanMax(double minimumPrice, double maximumPrice);
	public List<Product> createProductListByPriceRange(double minimumPrice, double maximumPrice);
	public List<Product> createProductListByTags(String input);
	public List<String> convertStringToArrayList(String tags);
	public boolean validateResultsOfSearch(ArrayList<Product> productList);
	public List<Product> getProductList();
	public void clearSearchQuery();
	
}
