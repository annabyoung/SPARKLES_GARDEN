/**
 * 
 */
package com.qac.sparkle_gardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.repositories.ProductRepository;

/**
 * @author Annabelle Young
 *
 * The various services associated with Product are defined here
 * Stock is checked for in stock or if there's enough stock to meet a customer's request
 *
 */

@Stateless
public class ProductService {
	@Inject ProductRepository productRepository;
	/**
	 * Things to implement:
		 * add items - to order and to wishlist
		 * display items
		 * search items
		 * item info
	*/
	
	/**
	 * Check if the product is in stock, if it's not then a message should display
	 * to let the customer know that it is back order
	 */
	public boolean checkInStock(Product p){
		if (p.getStockLevel() == 0)
		/**
		 * Need to consult with Chris and Luke about further details for what exactly they want to happen
		 */
			return false;
		return true;
	}
	
	/**
	 * Check if the orderline's quantity request exceeds product's stocklevel/quantity 
	 */
	public boolean checkIfEnoughQuantity(Product p, OrderLine ol){
		//if quantity of items exceeds or equals orderline's quantity request then true will be returned, otherwise false
		return (p.getStockLevel() <= ol.getQuantity());
	}
	
	

}
