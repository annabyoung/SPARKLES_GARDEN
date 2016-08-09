package com.qac.sparkle_gardens.controllers.order;

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
	@Inject
	Product product;
	
	private ArrayList<String> searchQuery = new ArrayList<>();
	
	/**
	 * 
	 * Takes the search query and calls appropriate functions from ProductService
	 * 
	 * @return search
	 */
	public String searchItems(){
		
		return "search";
	}
	
}
