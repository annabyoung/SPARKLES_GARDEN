package com.qac.sparkles_accounts.entities;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CreditCheck implements MessageListener {
	private Context context= null;
	private QueueConnectionFactory conFact= null;
	private QueueConnection connect = null;
	private QueueSession session = null;
	private QueueReceiver receiver = null;
	private Queue requests = null;
	
	public void receiveCustomerMessage() {
		try {
			context = new InitialContext();
			conFact = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			requests = (Queue) context.lookup("queue1");
			connect = conFact.createQueueConnection();
			session = connect.createQueueSession(false, AUTO_ACKNOWLEDGE);
		} catch (NamingException e){
			
		} catch (JMSException e) {
			
		} finally {
			
		}
	}
	
	public void onMessage(Message messsage) {
		try {
			// Gets the customer data
			MapMessage msg = (MapMessage) message;
			
		}
	}
}
