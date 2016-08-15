/**
 * 
 */
package com.qac.sparkles_accounts.controllers;

/**
 * @author Annabelle Young
 * 
 * Controller interface:
 *
 */
public interface Controller<T> {
	
	public void handleMessage(T messageObject);
}
