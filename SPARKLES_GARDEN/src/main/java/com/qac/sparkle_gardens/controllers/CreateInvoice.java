package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.RequestScoped;

import com.qac.sparkle_gardens.services.OrderService;

/**
 * 
 * @author Damien Lloyd
 *
 */

@Deprecated
@RequestScoped
public class CreateInvoice 
{
	OrderService service;
	
	public String createInvoice(long orderID)
	{
		service.generateInvoice(orderID);
		
		return "orders";
	}
}
