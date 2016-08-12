package com.qac.sparkle_gardens.util;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageSender 
{
	private QueueConnection connect = null;
	private QueueSession session = null;
	private Queue response = null;
	private Queue request = null;
	
	public MessageSender(String queuecf, String requestQ, String responseQ)
	{
		try
		{
			Context context = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory)
									context.lookup(queuecf);
			connect = factory.createQueueConnection();
			
			session = connect.createQueueSession(false,  
					Session.AUTO_ACKNOWLEDGE);
			
			response = (Queue) context.lookup(responseQ);
			request = (Queue) context.lookup(requestQ);
			
			connect.start();
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		} catch (NamingException ne) {
			ne.printStackTrace();
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

	public Queue getResponse() 
	{
		return response;
	}

	public Queue getRequest() 
	{
		return request;
	}	
}
