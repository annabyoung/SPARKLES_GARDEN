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
 * This controller handles the search queries of customers
 *
 */
@Named(value="search")
@SessionScoped
public class SearchItemsController {
	@Inject
	ProductService productService;
	
	
	private ArrayList<String> searchQuery = new ArrayList<>();
	private String error = "";
	
	/**
	 * 
	 * Takes the search query and calls appropriate functions from ProductService
	 * 
	 * @return search
	 */
	public String searchItems(){
		if (searchQuery.isEmpty()){
			error = "Please enter what you're searching for";
		}
		return "search";
	}
	
}
