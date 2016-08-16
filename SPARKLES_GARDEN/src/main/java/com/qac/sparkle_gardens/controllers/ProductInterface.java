/**
 * 
 */
package com.qac.sparkle_gardens.controllers;

import java.util.ArrayList;

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
	public ArrayList<Product> createProductListByPriceRange(double minimumPrice, double maximumPrice);
	public ArrayList<Product> createProductListByTags(String input);
	public ArrayList<String> convertStringToArrayList(String tags);
	public boolean validateResultsOfSearch(ArrayList<Product> productList);
	public ArrayList<Product> getProductList();
	public void clearSearchQuery();
	
}
