package com.qac.sparkle_gardens.util;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 
 * @author Damien Lloyd
 *
 */
public class MessageReceiver implements MessageListener
{
	private QueueConnection connect = null;
	private QueueConnectionFactory factory = null;
	private QueueSession session = null;
	private Queue queue = null;
	private Context context = null;
	private QueueReceiver receiver = null;
	
	private Object object = null;
	
	private Serializable serial = null;
	
	public MessageReceiver(Serializable serial)
	{
		this.serial = serial;
	}
	
	void setup()
	{
		try
		{
			context = new InitialContext();
			
			QueueConnectionFactory factory =
					(QueueConnectionFactory) 
						context.lookup("ConnectionFactory");
			
			connect = factory.createQueueConnection();
			
			session = connect.createQueueSession(false,  
					Session.AUTO_ACKNOWLEDGE);
			
			queue = (Queue) context.lookup("queue1");
			
			connect.start();
			
			receiver = session.createReceiver(queue);
			receiver.setMessageListener(this);
		} 
		catch (JMSException jmse) {
			jmse.printStackTrace();
		} 
		catch (NamingException jne) {
			jne.printStackTrace();
		}
	}
	
	public void close()
	{
		try
		{
			connect.close();
		} 
		catch (JMSException jmse) {
			jmse.printStackTrace();
		}
	}
	
	@Override
	public void onMessage(Message msg) 
	{
		ObjectMessage om = (ObjectMessage) msg;
		try {
			object = om.getObject();
			this.respond(serial);
		} 
		catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void respond(Serializable s)
	{
		try
		{
			ObjectMessage om = session.createObjectMessage(s);
			om.setJMSCorrelationID(om.getJMSMessageID());
			
			QueueSender sender = 
					session.createSender((Queue) om.getJMSReplyTo());
			sender.send(om);
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public QueueConnection getConnection() 
	{
		return connect;
	}

	public QueueSession getSession() 
	{
		return session;
	}

	public Queue getQueue() 
	{
		return queue;
	}
}
