package com.qac.sparkle_gardens.util;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageReceiver 
{
	private QueueConnection connect = null;
	private QueueSession session = null;
	private Queue request = null;
	
	public MessageReceiver(String queuecf, String requestQueue, MessageListener ml)
	{
		setup(queuecf, requestQueue, ml);
	}
	
	void setup(String queuecf, String requestQueue, MessageListener ml)
	{
		try
		{
			Context context = new InitialContext();
			
			QueueConnectionFactory factory =
					(QueueConnectionFactory) context.lookup(queuecf);
			
			connect = factory.createQueueConnection();
			
			session = connect.createQueueSession(false,  
					Session.AUTO_ACKNOWLEDGE);
			
			request = (Queue) context.lookup(requestQueue);
			
			connect.start();
			
			QueueReceiver receiver = session.createReceiver(request);
			receiver.setMessageListener(ml);
			
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		} catch (NamingException jne) {
			jne.printStackTrace();
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

	public QueueConnection getConnection() 
	{
		return connect;
	}

	public QueueSession getSession() 
	{
		return session;
	}

	public Queue getRequest() 
	{
		return request;
	}
}
