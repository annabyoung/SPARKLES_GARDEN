/**
 * 
 */
package com.qac.sparkle_gardens.jms;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.qac.sparkle_gardens.controllers.Controller;

/**
 * @author Annabelle Young
 * 
 * <T> takes generic type
 * This MessageListener could be used for different types of Objects since it is set as generic.
 *
 *Accounts project needs its own Sender, receiver, and listener classes
 */
@Stateless
public class AccountsMessageListener<T> implements MessageListener {
//	@Inject
//	private Controller<T> controller;
	
	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message message) {
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			System.out.println("received " + objectMessage.getObject().toString());
			//generic object is taken
			T object = (T) objectMessage.getObject();
//			controller.handleMessage((T) objectMessage.getObject());
		} catch (ClassCastException castException){
			System.out.println("ERROR: Type T was not the type of the Object sent. check the setter for the message listener");
			castException.printStackTrace();
		} catch (JMSException e){
			e.printStackTrace();
		}

	}

}
