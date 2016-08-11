package com.qac.sparkles_accounts.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jms.JMSException;
import javax.jms.MapMessage;
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

/**
 * The Invoice entity generates an invoice based on the 
 * Customer and Order information.
 * @author Administrator
 *
 */
public class Invoice implements MessageListener
{	
	Customer customer;
	Order order;
	
	private QueueConnection connect = null;
	private QueueSession session = null;
	private Queue request = null;
	
	public Invoice()
	{
		this(null,null,"","");
	}
	
	public Invoice(Customer customer, Order order, String queuecf, String requestQueue)
	{
		this.customer = customer;
		this.order = order;
		
		try
		{
			Context context = new InitialContext();
			
			QueueConnectionFactory factory =
					(QueueConnectionFactory)context.lookup(queuecf);
			
			connect = factory.createQueueConnection();
			
			session = connect.createQueueSession(false,  
					Session.AUTO_ACKNOWLEDGE);
			
			request = (Queue)context.lookup(requestQueue);
			
			connect.start();
			
			QueueReceiver receiver = session.createReceiver(request);
			receiver.setMessageListener(this);
			
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		} catch (NamingException jne) {
			jne.printStackTrace();
		}
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

	public void onMessage(Message message) 
	{
		try
		{	
			TextMessage tm = session.createTextMessage(generate());
			tm.setJMSCorrelationID(message.getJMSMessageID());
			
			QueueSender sender = 
					session.createSender((Queue) 
							message.getJMSReplyTo());
			sender.send(tm);
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		try
		{
			connect.close();
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		}
	}
}
