package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;

/**
 * Remove an item from the basket.
 * @author Damien Lloyd
 *
 */
@Named (value = "removeItem")
@SessionScoped
public class RemoveItem 
{
	@Inject
	OrderService service;
	
	@Inject
	ProductService pService;
	
	/**
	 * Remove item from the basket by its product ID
	 * @param productID
	 * @return
	 */
	String removeItem(long productID)
	{
		if (!service.isBasketEmpty())
			service.removeItemFromBasket(pService.getProductByID(productID));
		
		return "home";
	}
}
