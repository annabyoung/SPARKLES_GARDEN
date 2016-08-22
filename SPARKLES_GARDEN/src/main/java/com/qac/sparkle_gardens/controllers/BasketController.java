package com.qac.sparkle_gardens.controllers;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;

public class BasketController 
{
	@Inject
	private OrderService service;
	
	@Inject
	private ProductService pService;
	
	private int quantity = 0;
	private int price = 0;
	
	public String addItem(long productID)
	{
		Product p = pService.getProductByID(productID);

		if (!pService.checkInStock(p))
			return "product_not_in_stock";

		service.addProductToBasket(p, quantity);
		
		return "home";
	}
	
	String removeItem(long productID)
	{
		if (!service.isBasketEmpty())
			service.removeItemFromBasket(pService.getProductByID(productID));
		
		return "home";
	}
	
	public String clearBasket()
	{
		if (!service.clearBasket())
			return "basket_already_empty";
		return "basket_emptied";
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}
}
