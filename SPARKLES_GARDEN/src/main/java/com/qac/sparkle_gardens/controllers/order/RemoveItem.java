package com.qac.sparkle_gardens.controllers.order;

import javax.inject.Inject;

import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;

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
