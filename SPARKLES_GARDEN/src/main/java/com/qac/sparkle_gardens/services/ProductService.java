/**
 * 
 */
package com.qac.sparkle_gardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Wishlist;
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
		 * display items
		 * search items
		 * item info
	*/
	
	/**
	 * Add item to wishlist
	 */
	public void addItemToWishlist(Product p, Wishlist wishlist){
		
	}
	
	/**
	 * Add item to orderline
	 * If the product has enough stock to meet the orderline's request, return true and add to orderline
	 * if the product does not have enough stock to meet orderline's request, output error message
	 * 
	 * Additional functionality to be added later
	 */
	public void addItemToOrderline(Product p, OrderLine orderline){
		if (checkIfEnoughQuantity(p, orderline.getQuantity())){
			orderline.setProduct(p, orderline.getQuantity());
		}
		System.out.println("Request exceeds stock level");
	}
	
	
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
	 * Check if the quantity request exceeds product's stocklevel/quantity 
	 * if the stock level is less than or equal to quantity requested, true will be returned
	 * if there is not enough stock to meet the quantity requested, false will be returned
	 */
	public boolean checkIfEnoughQuantity(Product p, int quantityRequested){
		return (p.getStockLevel() <= quantityRequested);
	}
	

}
