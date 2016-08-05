package com.qac.sparkle_gardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.OrderLineRepository;
import com.qac.sparkle_gardens.repositories.OrderRepository;

@Stateless
public class OrderService 
{
	@Inject
	OrderRepository repository;
	
	@Inject
	OrderLineRepository ol_repository;

	public boolean isOrderEmpty(String orderID)
	{
		if (repository.findByID(orderID).getQuantity() == 0)
			return true;
		return false;
	}
	
	public double getTotalPrice(String orderID)
	{
		int q = repository.findByID(orderID).getQuantity();
		
	}
}
