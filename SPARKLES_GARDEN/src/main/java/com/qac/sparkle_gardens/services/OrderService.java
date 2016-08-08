package com.qac.sparkle_gardens.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
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
	private static long ORDER_ID = 0;
	
	@Inject
	OrderRepository repository;
	
	@Inject
	ArrayList<OrderLine> basket;
	
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
	 * This function checks the order, ensuring the price is
	 * not negative, and the quantity ordered is agreeable
	 * with that product's stock levels.
	 * @param quantity
	 * @param price
	 * @return true if the order passes, false if otherwise
	 */
	public boolean checkOrderLine(int quantity, double price, int stocklevel)
	{
		if (quantity < 0 || price < 0)
			return false;
		
		if (quantity < stocklevel)
			return false;
		
		return true;
	}
	
	/**
	 * Return the total price of the order from all the 
	 * OrderLines therein.
	 * @param lines - The list of OrderLines to be passed
	 * @return
	 */
	public double getTotalPrice(long orderID)
	{
		ArrayList<OrderLine> lines = repository.getOrder(orderID).getOrderLines();
		double totalPrice = 0;
		
		for (OrderLine i : lines)
		{
			totalPrice += (i.getProduct().getPrice() * i.getQuantity());
		}
		
		if (totalPrice == 0)
			return 0.0;
		
		return totalPrice;
	}
	
	/**
	 * Generates a orderID that is unique and relates to an order.
	 * The order ID is a numerical decimal value.
	 * @return The identification number of the order
	 */
	private long generateOrderID()
	{
		return ++ORDER_ID;
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
		ArrayList<OrderLine> lines = repository.getOrder(orderID).getOrderLines();
		
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
	
	/**
	 * This function returns the product price multiplied by the quantity.
	 * It's a handy and useful function where it is required to determine
	 * a total product's price based on quantity. If you want the total price
	 * of an entire order, see getTotalPrice(..).
	 * @param p The product in question
	 * @param quantity The quantity thereof
	 * @return
	 */
	public double getPrice(Product p, int quantity)
	{
		return (p.getPrice() * quantity);
	}
	
	public boolean addProductToBasket(Product p, int quantity)
	{
		if (!checkOrderLine(quantity, p.getPrice(), p.getStockLevel()))
			return false;
		
		basket.add(new OrderLine(p, quantity));
		
		return true;
	}
	
	public boolean createOrder(long customerID)
	{
		long id = generateOrderID();
		repository.persistOrder(new Order(id, customerID));
		
		if (basket.isEmpty())
			return false;
		
		for (OrderLine i : basket)
			repository.getOrder(id).addOrderLine(i);
		
		return true;
	}
	
	public Order getOrder(long orderID)
	{
		return repository.getOrder(orderID);
	}
}
