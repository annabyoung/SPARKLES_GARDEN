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
<<<<<<< HEAD
	public boolean checkIfMinAndMaxAreValid(double minimumPrice, double maximumPrice);
	public List<Product> createProductListByPriceRange(double minimumPrice, double maximumPrice);
	//public List<Product> createProductListByTags(String input);
	public List<Product> createProductListWithAllTags(String input);
	public List<Product> createProductListWithSomeTags(String input);
	public List<String> convertStringToArrayList(String tags);
	public boolean validateResultsOfSearch(List<Product> productList);
	public List<Product> getProductList();
=======
	public ArrayList<Product> createProductListByPriceRange(double minimumPrice, double maximumPrice);
	public ArrayList<Product> createProductListByTags(String input);
	public ArrayList<String> convertStringToArrayList(String tags);
	public boolean validateResultsOfSearch(ArrayList<Product> productList);
	public ArrayList<Product> getProductList();
>>>>>>> a0f8dbfaebece88cde011b8538a7caf32abec5ea
	public void clearSearchQuery();
	
}
