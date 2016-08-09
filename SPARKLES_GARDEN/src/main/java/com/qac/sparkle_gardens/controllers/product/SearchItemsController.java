package com.qac.sparkle_gardens.controllers.product;

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
	
	private ArrayList<Product> searchQueryByTags = new ArrayList<>();
	private ArrayList<Product> searchQueryByPrice = new ArrayList<>();
	private String error = "";
	
	/**
	 * 
	 * Takes the search query and validates that there are search results
	 * Return search page with results if not empty
	 * Otherwise, return blank search page
	 * 
	 * @return search
	 */
	public String searchItemsByTags(){
		if (productService.validateResultsOfSearch(searchQueryByTags)){
			//ProductList = searchResults?!?!
			return "search";
		}
		
		return "blank_search";
	}
	
	public String searchItemsByPrice(){
		if (productService.validateResultsOfSearch(searchQueryByPrice)){
			//ProductList = searchResults?!?!
			return "search";
		}
		
		return "blank_search";
	}
	
}
