package com.qac.sparkles_accounts.entities;

import java.io.Serializable;
import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;

public class Invoice implements Serializable
{
	/**
	 * Serial ID of Invoice
	 */
	private static final long serialVersionUID = 2259219866064562568L;
	
	Customer customer;
	Order order;
	
	public Invoice()
	{
		
	}
	
	public Invoice(Customer customer, Order order)
	{
		this.customer = customer;
		this.order = order;
	}
	
	public String generate()
	{
		String invoice = "";
		ArrayList<OrderLine> lines = order.getOrderLines();
		
		invoice += "\n\n\n----------------------------------------------";
		
		invoice += "Thank you for shopping at NBGardens!\n";
		invoice += "You have purchased the following items: \n";
		
		for (OrderLine i : lines)
		{
			invoice += "\n\nProduct = " + i.getProduct().getProductName() + "\n" + 
						"   Quantity = " + i.getQuantity() + "\n" + 
						    "Price = " + (i.getProduct().getPrice() * i.getQuantity()) + "\n\n";
		}
				
		invoice += "\n\n\n----------------------------------------------";
		
		return invoice;
	}
}
