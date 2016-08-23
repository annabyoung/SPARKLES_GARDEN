package com.qac.sparkle_gardens.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
//import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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

//@Named(value="search")
@Path(value="search")
@RequestScoped
public class SearchItemsController {
	@Inject	private ProductService productService;
	
	private List<Product> searchQueryResults = new ArrayList<Product>();
	private String error = "";
	
	/**
	 * 
	 * Takes the customer's input that they put into search bar and validates that there are search results
	 * Return search page with results if not empty
	 * Otherwise, return blank search page
	 * 
	 * @return search, blank_search
	 */
	@POST
	@Consumes("text/plain")
	@Path("createbytags")
	public String createProductListByTags(String customerInput){
		searchQueryResults.addAll(productService.createProductListWithAllTags(customerInput));
		searchQueryResults.addAll(productService.createProductListWithSomeTags(customerInput));
		if (productService.validateResultsOfSearch(searchQueryResults)){
			return "Created with: " + customerInput;
			//return "search/" + customerInput;
		}
		error = "No results found for your search.";
		return error;
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
	@POST
	@Consumes("text/plain")
	@Path("createbyprice")
	public String createProductListByPrice(@FormParam("minimum") double minimumPrice, @FormParam("maximum") double maximumPrice){
		searchQueryResults.addAll(productService.createProductListByPriceRange(minimumPrice, maximumPrice));
		if (productService.validateResultsOfSearch(searchQueryResults)){
			return "Created with: " + minimumPrice + " : " + maximumPrice;
		}
		error = "No results found for your search";
		return error;
	}
	
	/**
	 * This will clear the search query
	 * @return
	 */
	public String clearProductList(){
		productService.clearSearchQuery();
		return "home";
	}
	
	/**
	 * Retrieve the list of products that resulted from search queries
	 */
	@Path("{id}")
	@GET
	//@Produces("text/plain")
	public List<Product> getSearchResultList(){
		return searchQueryResults;
		//return (List<Product>)productService.getProductList();
	}
	
	/**
	 * Retrieve error message if there is one
	 */
	@Path("{id}")
	@GET
	@Produces("text/plain")
	public String getError(){
		return error;
	}
}







