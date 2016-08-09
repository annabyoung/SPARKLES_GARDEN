package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;

/**
 * Clear the basket
 * @author Damien Lloyd
 *
 */

@Named (value = "clearBasket")
@SessionScoped
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
