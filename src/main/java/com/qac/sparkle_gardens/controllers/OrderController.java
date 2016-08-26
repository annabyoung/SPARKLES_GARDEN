package com.qac.sparkle_gardens.controllers;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;
import com.qac.sparkle_gardens.util.MethodAuthor;
import com.qac.sparkle_gardens.util.OrderStatus;
import com.qac.sparkle_gardens.util.PaymentStatus;

public class OrderController 
{

	@Inject
	private CardService cService;
	
	@Inject
	private RefundCard refund;
	
	
	
	@Inject
	private OrderService service;
	
	@Inject
	private ProductService pService;
	
	@Inject
	private PayByCard pay;
	
	
	 
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
	
	
	/**
	 * Add product to the basket
	 * @param productID ID of product to add
	 * @param quantity The quantity thereof
	 * @return
	 */
	public String addItem(long orderID, long productID, int quantity)
	{
		Product product = pService.getProductByID(productID);
		if (quantity < 1)
			return "Quantity must be greater than zero";
		
		if (!pService.checkIfEnoughQuantity(product, quantity))
			return "Not enough stock of product";

		service.addProductToBasket(service.getOrder(orderID), product, quantity);
		return "Added item successfully";
	}
	
	/**
	 * Remove product from basket
	 * @param productID ID of product to remove
	 * @return
	 */
	public String removeItem(long productID)
	{
		if (service.isBasketEmpty())
			return "basket_is_empty";
		
		service.removeItemFromBasket(pService.getProductByID(productID));
		return "successfully_removed_item";
		
	}
	
	/**
	 * Modify the quantity of the product before placing an order.
	 * See OrderController.amendOrder(..) for amending an order
	 * after it is placed.
	 * @param productID
	 * @param quantity
	 * @return
	 */
	public String modifyItemQuantity(long orderID, long productID, int quantity)
	{
		this.removeItem(productID);
		this.addItem(productID, quantity);
		return "modified quantity";
	}
	

	/**
	 * Place order with order ID and option to pay later
	 * @param orderID The order ID Order pertains to
	 * @param payLater Do you want to buy-now-pay-later?
	 * @return
	 */
	public String placeOrder(boolean payLater, String cardName, 
			String cardNumber, String cvs, String expirationDate)
	{
		if (service.isBasketEmpty())
			return "basket_is_empty";
		
		if (cardNumber.equals("") || cvs.equals("") 
				|| expirationDate.equals(""))
			return "invalid_card_details";
		
		service.createOrder(payLater);	
		
		if (!payLater)
		{
			double price = service.getTotalPrice();
			pay.payByCard(cardName, cardNumber, expirationDate, price, cvs);
			return "order_placed_paidNow";
		}
		
		return "order_placed_payLater";
	}
	
	

	
	
	
}
