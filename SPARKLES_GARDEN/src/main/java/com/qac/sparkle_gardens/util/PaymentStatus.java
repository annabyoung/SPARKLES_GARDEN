package com.qac.sparkle_gardens.util;

public enum PaymentStatus 
{

	/**
	 * Payment default status. Not paid.
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
