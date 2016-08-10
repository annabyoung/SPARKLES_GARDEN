package com.qac.sparkle_gardens.util;

public enum PaymentStatus 
{
	/**
	 * Paid hasn't been made
	 */
	UNPAID,
	
	/**
	 * Payment is yet to be paid
	 */
	PENDING,
	
	/**
	 * Payment is paid.
	 */
	PAID,
	
	/**
	 * Payment is overdue.
	 */
	OVERDUE,
	
	/**
	 * Payment is voided if no longer necessary. I.E refund or broken on arrival
	 */
	VOID
}
