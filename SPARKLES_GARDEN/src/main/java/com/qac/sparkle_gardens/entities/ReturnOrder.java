package com.qac.sparkle_gardens.entities;

import javax.inject.Inject;

import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.util.OrderStatus;

public class ReturnOrder 
{
	@Inject
	OrderService service;
	
	@Inject
	CardService cService;
	
	public String returnOrder(long orderID)
	{
		Order o = service.getOrder(orderID);
		o.setStatus(OrderStatus.RETURNED);
		
		if (service.isEligibleForRefund(orderID))
		{
			//cService.
			return "order_history";
		}
		
		return "order_history";
	}
}
