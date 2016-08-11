package com.qac.sparkle_gardens.controllers;

import com.qac.sparkle_gardens.services.OrderService;

/**
 * 
 * @author Damien Lloyd
 *
 */
public class CreateInvoice 
{
	OrderService service;
	
	public String createInvoice(long orderID)
	{
		service.generateInvoice(orderID);
		
		return "orders";
	}
}
