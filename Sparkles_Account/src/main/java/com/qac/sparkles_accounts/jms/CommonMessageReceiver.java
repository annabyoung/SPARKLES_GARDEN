/**
 * 
 */
package com.qac.sparkles_accounts.jms;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;


import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.qac.sparkle_gardens.jms.AccountsMessageListener;

/**
 * @author Annabelle Young
 * 
 * Point-to-Point Messaging: Receiver
 * This is used to receive a Customer's information from Sparkles Garden after they have requested a credit check
 * Customer's CreditStatus will be changed by Accounts after Credit Check and then be sent back to Sparkles Garden
 *
 */
public class CommonMessageReceiver {
	private InitialContext context = null;
	private Queue responseQueue = null;
	private QueueConnection queueConnection = null;
	private QueueConnectionFactory queueConnectionFactory = null;
	private QueueSession queueSession = null;
	private QueueReceiver queueReceiver = null;
	
	public void receiveObjectMessage(){
		try {
			
			context = new InitialContext();
			queueConnectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			responseQueue = (Queue) context.lookup("queue1");
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, AUTO_ACKNOWLEDGE);
			queueReceiver = queueSession.createReceiver(responseQueue);
			queueConnection.start();
			queueReceiver.setMessageListener(new AccountsMessageListener());
		} catch(NamingException e){
			e.printStackTrace();
		}catch (JMSException e){
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