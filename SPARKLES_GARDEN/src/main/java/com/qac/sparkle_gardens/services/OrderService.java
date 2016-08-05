package com.qac.sparkle_gardens.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.repositories.ProductRepository;

/**
 * The OrderService provides the functionality required for 
 * the Order to have meaning and context within the system.
 * 
 * @author Damien Lloyd
 *
 */
@Stateless
public class OrderService 
{
	@Inject
	OrderRepository repository;
	
	/**
	 * Checks if the orderID is empty. If all the OrderLines have a
	 * total quantity of 0, then the order is empty.
	 * @param orderID
	 * @return
	 */
	public boolean isOrderEmpty(long orderID)
	{
		ArrayList<OrderLine> lines = repository.getOrder(orderID).getOrderLines();
		int totalQuantity = 0;
		
		for (OrderLine i : lines)
		{
			totalQuantity += i.getQuantity();
		}
		
		if (totalQuantity == 0)
			return true;
		
		return false;
	}
	
	/**
	 * Return the total price of the order from all the 
	 * OrderLines therein.
	 * @param orderID
	 * @return
	 */
	public double getTotalPrice(long orderID)
	{
		ArrayList<OrderLine> lines = repository.getOrder(orderID).getOrderLines();
		double totalPrice = 0;
		
		for (OrderLine i : lines)
		{
			totalPrice += (i.getPrice() * i.getQuantity());
		}
		
		if (totalPrice == 0)
			return 0.0;
		
		return totalPrice;
	}
	
	/**
	 * Generate an invoice from the Order relating to
	 * orderID. The invoice will include word of appreciation
	 * as well as listing the products, their quantity and the total price
	 * of each OrderLine.
	 * 
	 * @param orderID
	 * @return This function will return a String which will be the invoice itself.
	 */
	public String generateInvoice(long orderID)
	{
		String invoice = "";
		ProductRepository pr;
		
		invoice += "\n\n\n----------------------------------------------";
		
		invoice += "Thank you for shopping at NBGardens!\n";
		invoice += "You have purchased the following items: \n";
		
		//invoice += pr.
				
		invoice += "\n\n\n----------------------------------------------";
		
		return invoice;
	}
}
