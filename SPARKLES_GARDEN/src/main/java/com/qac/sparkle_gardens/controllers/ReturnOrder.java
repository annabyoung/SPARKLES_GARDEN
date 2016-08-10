package com.qac.sparkle_gardens.controllers;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.util.OrderStatus;

/**
 * Return order controller
 * @author Damien Lloyd
 *
 */
public class ReturnOrder 
{
	@Inject
	OrderService service;
	
	@Inject
	CardService cService;
	
	String cardNumber;
	String expirationDate;
	String cvs;
	
	public String returnOrder(long orderID)
	{
		Order o = service.getOrder(orderID);
		o.setStatus(OrderStatus.RETURNED);
		
		if (service.isEligibleForRefund(orderID))
		{
			cService.refundCard(cardNumber, expirationDate);
			return "order_history";
		}
		
		return "order_history";
	}

	public String getCardNumber() 
	{
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) 
	{
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() 
	{
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) 
	{
		this.expirationDate = expirationDate;
	}

	public String getCvs() 
	{
		return cvs;
	}

	public void setCvs(String cvs) 
	{
		this.cvs = cvs;
	}
}
