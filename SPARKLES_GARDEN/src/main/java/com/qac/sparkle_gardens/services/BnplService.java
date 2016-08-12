/**
 * 
 */
package com.qac.sparkle_gardens.services;

import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.ObjectMessage;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.MessageInterpolator.Context;

import com.qac.sparkle_gardens.entities.Customer;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import javax.annotation.Resource;

/**
 * @author Annabelle Young
 *
 *Buy now, pay later
 *If a customer wishes to have a BNPL account, they can request a credit check
 *A message with 'Customer' which is all customer's information will be sent to Sparkles_Account
 *Inside of Account the credit check will be run and the results of if the credit check was successful will be returned
 *Customer's account will be updated to reflect if they are or are not eligible for BNPL
 */

@Stateless
public class BnplService {
	@Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
	private static ConnectionFactory connectionFactory;
	@Resource(lookup = "jms/MyQueue")
	private static Queue queue;
	@Resource(lookup = "jms/MyTopic")
	private static Topic topic;
	
	private InitialContext context = null;
	private QueueConnection queueConnection = null;
	private QueueConnectionFactory queueConnectionFactory = null;
	private QueueSession queueSession = null;
	private QueueSender queueSender = null;
	private QueueReceiver queueReceiver = null;

	
	/**
	 * Function to try and send a point-to-point message
	 * Messages consist of header, properties and body
	 * Message body type ObjectMessage contains Customer Serializable object
	 * Message header JMSCorrelationID links reply message with requesting message
	 * Message properties
	 */
	public void sendObjectMessage(){
		try{
			context = new InitialContext();
			queueConnectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			queue = (Queue) context.lookup("queue1");
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, AUTO_ACKNOWLEDGE);
			queueSender = queueSession.createSender(queue);
			//TextMessage textMessage =
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
	
	public void receiveObjectMessage() {
		try {
			context = new InitialContext();
			queueConnectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			queue = (Queue) context.lookup("queue1");
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, AUTO_ACKNOWLEDGE);
			queueReceiver = queueSession.createReceiver(queue);
			queueConnection.start();
			//queueReceiver.setMessageListener(new ExampleListener());
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














