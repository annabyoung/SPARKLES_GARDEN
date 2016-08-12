package com.qac.sparkles_accounts.entities;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.TextMessage;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.qac.sparkle_gardens.util.MessageReceiver;

public class CreditCheck implements Serializable
{
	private Card card;
	private Customer customer;
	
	private MessageReceiver receiver;
	
	public CreditCheck(Card card, Customer customer, String queuecf, String requestQueue)
	{
		this.card = card;
		this.customer = customer;
		
		receiver = new MessageReceiver(queuecf, requestQueue, this);
	}

	public void onMessage(Message msg) 
	{
		try
		{
			TextMessage tm = 
					receiver.getSession().createTextMessage(this.calculate());
			tm.setJMSCorrelationID(msg.getJMSMessageID());
			
			QueueSender sender = 
					receiver.getSession()
							.createSender((Queue) msg.getJMSReplyTo());
			sender.send(tm);
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		receiver.close();
	}
	
	private String calculate()
	{
		String result = "Credit check: UNKNOWN";
		
		if (customer.getCreditStatus() == CreditStatus.BLACKLISTED)
		{
			result = "Credit check: FAIL";
		}
		else result = "Credit check: PASS";
		return result;
	}
}
