package com.qac.sparkle_gardens.controllers;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.ProductService;

import javax.inject.Inject;



/**
 * @author Annabelle Young
 * 
 * Search Items controller
 * This controller handles the search queries of customers and returns list of products based on search parameters
 *
 */
@Named(value="search")
@SessionScoped
public class SearchItemsController {
	@Inject
	ProductService productService;
	
	private ArrayList<Product> searchQueryResults = new ArrayList<>();
	//private ArrayList<String> searchQuery = new ArrayList<>();
	private String error = "";
	
	/**
	 * 
	 * Takes the customer's input that they put into search bar and validates that there are search results
	 * Return search page with results if not empty
	 * Otherwise, return blank search page
	 * 
	 * @return search, blank_search
	 */
	public String createProductList(String customerInput){
		searchQueryResults = productService.createProductListByTags(customerInput);
		if (productService.validateResultsOfSearch(searchQueryResults)){
			return "search";
		}
		error = "No results found for your search.";
		return "blank_search";
	}
	
	/**
	 * Takes in the minimum a customer is willing to spend and the maximum that a customer is willing to spend
	 * If there are items in that price range, then return the search page with those items
	 * If the product list is empty then return a blank page
	 * 
	 * @param minimumPrice
	 * @param maximumPrice
	 * @return search, blank_search
	 */
	public String createProductList(double minimumPrice, double maximumPrice){
		searchQueryResults = productService.createProductListByPriceRange(minimumPrice, maximumPrice);
		if (productService.validateResultsOfSearch(searchQueryResults)){
			return "search";
		}
		error = "No results found for your search";
		return "blank_search";
	}
	
	/**
	 * This will clear the search query
	 * @return
	 */
	public String clearProductList(){
		productService.clearSearchQuery();
		return "home";
	}
	
	public String getProductList(){
		searchQueryResults = productService.getProductList();
		return "search";
	}
}