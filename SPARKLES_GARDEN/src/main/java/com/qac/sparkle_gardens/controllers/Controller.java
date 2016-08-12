/**
 * 
 */
package com.qac.sparkle_gardens.controllers;

/**
 * @author Annabelle Young
 * 
 * Controller interface
 *
 */
public interface Controller<T> {

	public void handleMessage(T messageObject);
}
