package com.qac.sparkle_gardens.entities;
/*
 * Allen will work on this
 */
public class Payment 
{
	private String paymentID;
	private String name;
	private String cardNumber;
	private String expiryDate;
	
	public Payment(){
		
	}
	
	public Payment(String paymentID, String name, String cardNumber, String expiryDate) {
		super();
		this.paymentID = paymentID;
		this.name = name;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
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
