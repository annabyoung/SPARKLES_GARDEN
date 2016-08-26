/**
 * 
 */
package com.qac.sparkle_gardens.controllers;

/**
 * @author Annabelle Young
 * 
 * Controller interface: 
 * see updateCustomer for details on handleMessage
 *
 */
public interface Controller<T> {

	public void handleMessage(T messageObject);
}
