package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;

/**
 * Place an order with all the items in the basket.
 * @author Damien Lloyd
 *
 */
@Named (value = "placeOrder")
@SessionScoped
public class PlaceOrder 
{	
	@Inject
	OrderService service;
	
	@Inject
	PayByCard pay;
	
	String cardNumber = "", expiryDate = "";
	String cardOwnerName = "", cvs = "";
	
	/**
	 * Place order with order ID and option to pay later
	 * @param orderID The order ID Order pertains to
	 * @param payLater Do you want to buy-now-pay-later?
	 * @return
	 */
	public String placeOrder(long orderID, boolean payLater)
	{
		if (service.isOrderEmpty(orderID))
			return "home";
		
		if (cardNumber.equals("") || cvs.equals("") || expiryDate.equals(""))
			return "home";
		
		service.createOrder(payLater);	
		
		if (!payLater)
		{
			double price = service.getTotalPrice(orderID);
			pay.payByCard(cardOwnerName, cardNumber, expiryDate, price);
			return "home";
		}
		
		service.generateInvoice(orderID);
		
		return "home";
	}

	public String getCardNumber() 
	{
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) 
	{
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() 
	{
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) 
	{
		this.expiryDate = expiryDate;
	}

	public String getCardOwnerName() 
	{
		return cardOwnerName;
	}

	public void setCardOwnerName(String cardOwnerName) 
	{
		this.cardOwnerName = cardOwnerName;
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
