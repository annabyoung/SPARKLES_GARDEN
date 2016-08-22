package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;

/**
 * Clear the basket
 * @author Damien Lloyd
 *
 */

@Deprecated
@Named (value = "clearBasket")
@RequestScoped
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
