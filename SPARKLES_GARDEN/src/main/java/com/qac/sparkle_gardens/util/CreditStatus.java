package com.qac.sparkle_gardens.util;

/**
 * 
 * @author James Thompson
 *
 */
public enum CreditStatus {
	/**
	 * customer has applied for an account
	 */
	VALIDATING, 
	/**
	 * Customers account is active
	 */
	VALID, 
	/**
	 * customer is waiting to pay for order
	 */
	ONHOLD, 
	/**
	 * Customer faild to pay
	 */
	BLACKLISTED, 
	/**
	 * Customers application for an account was rejected
	 */
	REJECTED,
	/**
	 * The customers account was deactivated
	 */
	DEACTIVATED
}