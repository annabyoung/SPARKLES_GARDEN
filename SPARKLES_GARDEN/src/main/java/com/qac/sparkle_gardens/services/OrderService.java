package com.qac.sparkle_gardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.OrderRepository;

@Stateless
public class OrderService 
{
	@Inject
	OrderRepository repository;
	
	public boolean isProductInStock(Product p)
	{
		if (p.getStockLevel() < 0)
			return false;
		
		return true;
	}
	
	public boolean isOrderEmpty()
}
