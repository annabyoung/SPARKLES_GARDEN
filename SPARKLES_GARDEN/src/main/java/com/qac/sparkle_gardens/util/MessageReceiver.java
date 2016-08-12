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
	private QueueConnectionFactory factory = null;
	private QueueSession session = null;
	private Queue queue = null;
	private Context context = null;
	private QueueReceiver receiver = null;
	
	public MessageReceiver(MessageListener ml)
	{
		setup(ml);
	}
	
	void setup(MessageListener ml)
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
			receiver.setMessageListener(ml);
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
