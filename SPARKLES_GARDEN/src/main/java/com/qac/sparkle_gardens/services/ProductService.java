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
	 * If the product has enough stock to meet the request, return true and decrement stock
	 * if the product does not have enough stock to meet orderline's request, output error message
	 * 
	 * Additional functionality to be added later
	 * 
	 * stock is decremented when order is being finalized, 
	 * as soon as customer pushes 'checkout'
	 * stock is returned if customer cancels order, or removes items from order
	 * stock should be returned if customer doesn't complete order within a certain time frame
	 * 
	 *
	 * Decrement stock when order is being finalized
	 */
	
	public void decrementProductQuantity(Product p, int quantityRequest){
		if (checkIfEnoughQuantity(p, quantityRequest)){
			p.setStockLevel(p.getStockLevel() - quantityRequest);
		}
	}
	
	
	/**
	 * Check if the product is in stock, if it's not then a message should display
	 * to let the customer know that it is back order
	 * 
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
	 * Retrieve product's info from productID
	 * Find the product from its ID and return its description
	 */
	public String getProductDescriptionFromID(long productID){
		Product p = getProductByID(productID);
		return p.getProductDescription();
	}
	
	/**
	 * Check if the quantity request exceeds product's stocklevel/quantity 
	 * if the stock level is less than or equal to quantity requested, true will be returned
	 * if there is not enough stock to meet the quantity requested, false will be returned
	 */
	public boolean checkIfEnoughQuantity(Product p, int quantityRequested){
		return (p.getStockLevel() <= quantityRequested);
	}
	

	public Product getProductByID(long productID){
		return productRepository.findByProductID(productID);
	}
	

}
