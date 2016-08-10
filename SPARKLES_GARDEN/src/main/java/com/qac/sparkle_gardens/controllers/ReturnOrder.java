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
	
	/**
	 * This function checks whether the Order is eligible for a refund 
	 * (30 days after dispatch) and refunds the order based on card.
	 * @param orderID
	 * @return
	 */
	public String returnOrder(long orderID)
	{
		Order o = service.getOrder(orderID);
		o.setOrderStatus(OrderStatus.RETURNED);
		
		if (service.isEligibleForRefund(orderID) && !o.isPayLater())
		{
			cService.refundCard(cardNumber, expirationDate);
			return "order_history";
		}
		
		return "order_history";
	}
	
	/**
	 * Get the card number 
	 * @return
	 */
	public String getCardNumber() 
	{
		return cardNumber;
	}
	
	/**
	 * Set the card number
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) 
	{
		this.cardNumber = cardNumber;
	}
	
	/**
	 * Get the card's expiry date
	 * @return
	 */
	public String getExpiryDate() 
	{
		return expirationDate;
	}
	
	/**
	 * Set the card's expiry date
	 * @param expirationDate
	 */
	public void setExpirynDate(String expirationDate) 
	{
		this.expirationDate = expirationDate;
	}
	
	/**
	 * Get the security code of the card
	 * @return
	 */
	public String getCvs() 
	{
		return cvs;
	}
	
	/**
	 * Set the security code of the card
	 * @param cvs
	 */
	public void setCvs(String cvs) 
	{
		this.cvs = cvs;
	}
}
