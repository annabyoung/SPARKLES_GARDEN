package com.qac.sparkle_gardens.util;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * MessageSender covers some of the magic behind sending a message
 * to a MessageReceiver.
 * @author Damien Lloyd
 *
 */
public class MessageSender 
{
	private Context context = null;
	private QueueConnection connect = null;
	private QueueConnectionFactory factory = null;
	private QueueSession session = null;
	private Queue queue = null;
	private QueueSender sender = null;
	
	/**
	 * The default constructor creating a MessageSender
	 * @param queuecf Queue construction factory name
	 * @param requestQ request queue
	 * @param responseQ response queue
	 */
	public MessageSender()
	{
		try
		{
			// Create a new environment for sending messages
			Context context = new InitialContext();
			
			/* Construct a queue connection factory which will create
			our objects for sending a message. */
			QueueConnectionFactory factory = (QueueConnectionFactory)
									context.lookup("ConnectionFactory");
			
			// Create a connection
			connect = factory.createQueueConnection();
			
			// Create a session which 
			session = connect.createQueueSession(false,  
					Session.AUTO_ACKNOWLEDGE);
			
			queue = (Queue) context.lookup("queue1");
			
			sender = session.createSender(queue);
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}
	
	public void send(Serializable s) throws JMSException
	{
		ObjectMessage om = session.createObjectMessage();
		om.setObject(s);
		connect.start();
		sender.send(om);
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
