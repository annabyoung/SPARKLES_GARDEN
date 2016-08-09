package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;

/**
 * Cancel an order
 * @author Damien Lloyd
 *
 */
@Named (value = "cancelOrder")
@SessionScoped
public class CancelOrder 
{
	@Inject
	OrderService service;
	
	public String cancelOrder(long orderID)
	{
		return "home";
	}
}
