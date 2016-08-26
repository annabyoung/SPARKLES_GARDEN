package com.qac.sparkle_gardens.controllers;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;
@Deprecated 
public class BasketController 
{
	@Inject
	private OrderService service;
	
	@Inject
	private ProductService pService;
	
	@Inject
	private PayByCard pay;
	
	/**
	 * Default constructor
	 */
	public BasketController()
	{
		
	}
	
	/**
	 * Add product to the basket
	 * @param productID ID of product to add
	 * @param quantity The quantity thereof
	 * @return
	 */
	public String addItem(long productID, int quantity)
	{
		if (quantity < 1)
			return "product_quantity_invalid";
		
		Product p = pService.getProductByID(productID);

		if (!pService.checkInStock(p))
			return "product_not_in_stock";

		service.addProductToBasket(p, quantity);
		
		return "product_successfully_added";
	}
	
	/**
	 * Remove product from basket
	 * @param productID ID of product to remove
	 * @return
	 */
	public String removeItem(long productID)
	{
		if (!service.isBasketEmpty())
		{
			service.removeItemFromBasket(pService.getProductByID(productID));
			return "successfully_removed_item";
		}
		
		return "basket_is_empty";
	}
	
	/**
	 * Modify the quantity of the product before placing an order.
	 * See OrderController.amendOrder(..) for amending an order
	 * after it is placed.
	 * @param productID
	 * @param quantity
	 * @return
	 */
	public String modifyItemQuantity(long productID, int quantity)
	{
		this.removeItem(productID);
		this.addItem(productID, quantity);
		return "modified quantity";
	}
	
	/**
	 * Clear basket, emptying the contents therein
	 * @return
	 */
	public String clearBasket()
	{
		if (!service.clearBasket())
			return "basket_already_empty";
		return "basket_emptied";
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