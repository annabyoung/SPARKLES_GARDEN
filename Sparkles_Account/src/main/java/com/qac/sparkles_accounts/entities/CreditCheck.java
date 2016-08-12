package com.qac.sparkles_accounts.entities;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.TextMessage;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.qac.sparkle_gardens.util.MessageReceiver;

public class CreditCheck implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2035175086074314039L;
	
	private Card card;
	private Customer customer;
	
	private MessageReceiver receiver;
	
	public CreditCheck(Card card, Customer customer)
	{
		this.card = card;
		this.customer = customer;
		
		receiver = new MessageReceiver(this);
	}
	
	public void close()
	{
		receiver.close();
	}
	
	public Boolean calculate()
	{
		Boolean result = false;
		
		if (customer.getCreditStatus() == CreditStatus.BLACKLISTED)
		{
			result = false;
		}
		else result = true;
		
		return result;
	}
}
