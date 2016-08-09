package com.qac.sparkle_gardens.controllers.order;

import javax.inject.Inject;

import com.qac.sparkle_gardens.services.OrderService;

/**
 * 
 * @author Damien Lloyd
 *
 */
public class ClearBasket 
{
	@Inject
	OrderService service;
	
	public String clearBasket()
	{
		service.clearBasket();
		return "home";
	}
}
