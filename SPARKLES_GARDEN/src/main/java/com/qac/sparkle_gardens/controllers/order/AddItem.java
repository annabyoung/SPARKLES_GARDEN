package com.qac.sparkle_gardens.controllers.order;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;

public class AddItem 
{
	@Inject
	OrderService service;
	
	@Inject
	ProductService pService;
	
	private long productID = 0;
	private int quantity = 0;
	private int price = 0;

	public String addItem(long productID, int quantity, int price)
	{
		Product p = pService.getProduct(productID);
		
		if (!pService.checkInStock(p))
			return "product_not_in_stock";
		
		service.
		
		service.addProduct(p, quantity);
		
		return "home";
	}
	
	public long getProductID() 
	{
		return productID;
	}

	public void setProductID(long productID) 
	{
		this.productID = productID;
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
