/**
 * 
 */
package com.qac.sparkle_gardens.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.ProductService;

/**
 * @author Annabelle Young
 *
 */
@Path("/search")
@RequestScoped
public class SearchItemsRESTController {

	@Inject	private ProductService productService;
	
	private List<Product> searchQueryResults = new ArrayList<Product>();
	private String error = "";
	private long productID = 0;
	private String productName = "";
	private int stockLevel = 0;
	private double price = 0.00;
	private String productDescription = "";
	private List<String> productTags = new ArrayList<>();
	private String tag = "";
	
	
	/**
	 * 
	 * Takes the customer's input that they put into search bar and validates that there are search results
	 * Return search page with results if not empty
	 * Otherwise, return blank search page
	 * 
	 * @return search, blank_search
	 */
	@POST
	@Path("/createbytags")
	//@Consumes(MediaType.APPLICATION_JSON)
	public String createProductListByTags(@FormParam("customerInput") String customerInput){
		searchQueryResults.addAll(productService.createProductListWithAllTags(customerInput));
		searchQueryResults.addAll(productService.createProductListWithSomeTags(customerInput));
		if (productService.validateResultsOfSearch(searchQueryResults)){
			return "Created with: " + customerInput;
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
	@Path("/createbyprice")
	//@Consumes(MediaType.APPLICATION_JSON)
	public String createProductListByPrice(@FormParam("minimumPrice") String minimumPrice, @FormParam("maximumPrice") String maximumPrice){
		double minimum = Double.parseDouble(minimumPrice);
		double maximum = Double.parseDouble(maximumPrice);
		searchQueryResults.addAll(productService.createProductListByPriceRange(minimum, maximum));
		if (productService.validateResultsOfSearch(searchQueryResults)){
			return "Created with: " + minimum + " : " + maximum;
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
	 * Retrieve the list of all products
	 * 
	 * TODO:
	 * ArrayList<GroupItem> groupsList =... ;
	 * JSONArray JSONArray = new JSONArray(groupsList);
	 */
	@GET
	@Path("/productList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductList(){
		return (List<Product>)productService.getProductList();
	}
	
	/**
	 * Retrieve first item in product list
	 */
	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductListProduct(){
		 List<Product> prod = productService.getProductList();
		 return prod.get(0);
	}
	
	/**
	 * Retrieve the list of products that resulted from search queries
	 */
	@GET
	@Path("/searchResult")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getSearchResultList(){
		return searchQueryResults;
	}
	
	/**
	 * Retrieve error message if there is one
	 */
	@GET
	@Path("/error")
	@Produces(MediaType.APPLICATION_JSON)
	public String getError(){
		return error;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getSearchQueryResults() {
		return searchQueryResults;
	}

	public void setSearchQueryResults(List<Product> searchQueryResults) {
		this.searchQueryResults = searchQueryResults;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public List<String> getProductTags() {
		return productTags;
	}

	public void setProductTags(List<String> productTags) {
		this.productTags = productTags;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	
}
