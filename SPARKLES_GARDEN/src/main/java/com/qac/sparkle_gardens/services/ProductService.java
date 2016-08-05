/**
 * 
 */
package com.qac.sparkle_gardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.ProductRepository;

/**
 * @author Annabelle Young
 *
 */

@Stateless
public class ProductService {
	@Inject ProductRepository productRepository;
	//add items - to order and to wishlist
	
	
	//display items
	//search items
	//item info
	//check if in stock
	public boolean checkInStock(Product p){
		if (p.getStockLevel() == 0)
			return false;
		return quantityInStock(p);
	}
	
	public boolean quantityInStock(Product p){
		
	}

}
