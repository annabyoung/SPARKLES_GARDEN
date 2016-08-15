package com.qac.sparkles_accounts.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.util.MessageReceiver;

/**
 * The Invoice entity generates an invoice based on the 
 * Customer and Order information.
 * @author Administrator
 *
 */
public class Invoice implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7791470121898410338L;
	
	Customer customer;
	Order order;
	
	private MessageReceiver receiver;
	
	public Invoice(Customer customer, Order order, String queuecf, String requestQueue)
	{
		this.customer = customer;
		this.order = order;
		
		receiver = new MessageReceiver();
	}

	public void onMessage(Message msg) 
	{
		try
		{
			TextMessage tm = 
					receiver.getSession().createTextMessage(this.generate());
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
	
	private String generate()
	{
		String invoice = "";
		ArrayList<OrderLine> lines = order.getOrderLines();
		
		invoice += "\n\n\n----------------------------------------------";
		
		invoice += "Thank you for shopping at NBGardens!\n";
		invoice += "You have purchased the following items: \n";
		
		for (OrderLine i : lines)
		{
			invoice += "\n\nProduct = " + i.getProduct().getProductName() + "\n" + 
						"   Quantity = " + i.getQuantity() + "\n" + 
						    "Price = " + (i.getProduct().getPrice() * i.getQuantity()) + "\n\n";
		}
				
		invoice += "\n\n\n----------------------------------------------";
		
		return invoice;
	}
}
