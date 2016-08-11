package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;

/**
 * Add item to the basket; last step before placing an order.
 * @author Damien Lloyd
 *
 */
@Named (value = "addItem")
@RequestScoped
public class AddItem
{
	@Inject
	OrderService service;
	
	@Inject
	ProductService pService;
	
	private int quantity = 0;
	private int price = 0;
	
	/**
	 * Get Add item to the basket by its product ID
	 * @param productID
	 * @return
	 */
	public String addItem(long productID)
	{
		Product p = pService.getProductByID(productID);

		if (!pService.checkInStock(p))
			return "product_not_in_stock";

		service.addProductToBasket(p, quantity);
		
		return "home";
	}
	
	/**
	 * Set quantity of product desired
	 * @param quantity
	 */
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	/**
	 * Set price of product desired
	 * @param price
	 */
	public void setPrice(int price) 
	{
		this.price = price;
	}
}
