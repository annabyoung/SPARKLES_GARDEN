/**
 * 
 */
package com.qac.sparkles_accounts.jms;
import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.qac.sparkle_gardens.entities.Customer;

/**
 * @author Annabelle Young
 * 
 * Point-to-Point Messaging: Sender
 * This is used to send a Customer's information to Sparkles Garden when they request a credit check
 * Customer may request the credit check only once, and it is so they can make buy now pay later orders
 *
 */
public class CommonMessageSender {
	private InitialContext context = null;
	private Queue requestQueue = null;
	private QueueConnection queueConnection = null;
	private QueueConnectionFactory queueConnectionFactory = null;
	private QueueSession queueSession = null;
	private QueueSender queueSender = null;
	
	public void sendObjectMessage(){
		try{
			context = new InitialContext();
			queueConnectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			requestQueue = (Queue) context.lookup("queue1");
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, AUTO_ACKNOWLEDGE);
			queueSender = queueSession.createSender(requestQueue);
			Customer customer = new Customer();
			ObjectMessage objectMessage = queueSession.createObjectMessage();
			objectMessage.setObject(customer);
			queueConnection.start();
			queueSender.send(objectMessage);			
		} catch (NamingException e){
			e.printStackTrace();
		} catch (JMSException e){
			e.printStackTrace();
		} finally { 
			if(context != null){
				try {
					context.close();
				} catch (NamingException e){
					e.printStackTrace();
				}
			}
			if (queueConnection != null){
				try {
					queueConnection.close();
				} catch (JMSException e){
					e.printStackTrace();
				}
			}
		}	
	}
}


