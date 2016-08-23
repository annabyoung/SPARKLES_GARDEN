package com.qac.sparkle_gardens.controllers;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.util.MethodAuthor;
import com.qac.sparkle_gardens.util.OrderStatus;
import com.qac.sparkle_gardens.util.PaymentStatus;

public class OrderController 
{
	@Inject
	private OrderService service;
	
	@Inject
	private CardService cService;
	
	@Inject
	private RefundCard refund;
	
	private String invoice = "";
	
	private int quantity;
	
	public OrderController()
	{
		
	}
	
	/**
	 * Amend the quantity of a product in an Order AFTER it is placed.
	 * @param orderID
	 * @param productID
	 * @param quantity
	 * @return
	 */
	public String amendOrder(long orderID, long productID, int quantity)
	{
		if (service.amendOrder(orderID, productID, quantity))
			return "order_amended";
		return "order_not_amended";
	}
	
	/**
	 * Cancel the order based on the criteria that the order
	 * is still in the warehouse; i.e. in packing stage. If the order
	 * is a pay later kind, then the payment is rendered void.
	 * 
	 * @param orderID
	 * @return
	 */
	@MethodAuthor (author = "Annabelle Young")
	public String cancelOrder(long orderID)
	{
		Order order = service.getOrder(orderID);
		
		if (!service.canCancelOrder(orderID))
			return "order_not_cancelled";
		
		if(order.isPayLater())
		{
			order.setPaymentStatus(PaymentStatus.VOID);
			return "order_cancelled";
		}
		refund.refundCard(order);
		return "order_cancelled";
	}
	
	/**
	 * Generate an invoice once an order has been placed
	 * @param orderID
	 * @return
	 */
	public String createInvoice(long orderID)
	{
		invoice = service.generateInvoice(orderID);
		
		return "orders";
	}
	
	/**
	 * This function checks whether the Order is eligible for a refund 
	 * (30 days after dispatch) and refunds the order based on card.
	 * @param orderID
	 * @return
	 */
	public String returnOrder(long orderID, 
			String cardNumber, String expirationDate)
	{
		if (service.returnOrder(orderID, cardNumber, expirationDate))
			return "order_return_accepted";
		return "order_return_rejected";
	}
	
	public String getInvoice()
	{
		return invoice;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
}

