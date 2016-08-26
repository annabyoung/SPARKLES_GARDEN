/**
 * 
 */
package com.qac.sparkle_gardens.jms;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import java.util.List;

import javax.ejb.Stateless;
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
import com.qac.sparkle_gardens.test_data.InitialData;

/**
 * @author Annabelle Young
 * 
 * Point-to-Point Messaging: Sender
 * This is used to send a Customer's information to Accounts when they request a credit check
 * Customer may request the credit check only once, and it is so they can make buy now pay later orders
 *
 */
@Stateless
public class AccountsMessageSender {
	private InitialContext context = null;
	private Queue requestQueue = null;
	private QueueConnection queueConnection = null;
	private QueueConnectionFactory queueConnectionFactory = null;
	private QueueSession queueSession = null;
	private QueueSender queueSender = null;
	private List<Customer> customer;
	private InitialData customerData = new InitialData();
	
	public void sendObjectMessage(){
		try{
			customer = customerData.getCustomers();
			Customer messageCustomer = customer.get(0);
			context = new InitialContext();
			queueConnectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			requestQueue = (Queue) context.lookup("queue1");
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, AUTO_ACKNOWLEDGE);
			queueSender = queueSession.createSender(requestQueue);
			
			ObjectMessage objectMessage = queueSession.createObjectMessage();
			objectMessage.setObject(messageCustomer);
			queueConnection.start();
			System.out.println(" Sending message containing Customer: " + messageCustomer.getFirstName() );
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
