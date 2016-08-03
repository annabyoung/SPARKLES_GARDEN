package com.qac.sparkle_gardens.entities;

public class Payment 
{
	private String paymentID;
	private String name;
	private String cardNumber;
	private String expiryDate;
	
	Payment()
	{
		this.paymentID = "";
		this.name = "";
		this.cardNumber = "";
		this.expiryDate = "";
	}

	public String getPaymentID() 
	{
		return paymentID;
	}

	public void setPaymentID(String paymentID) 
	{
		this.paymentID = paymentID;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
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
}
