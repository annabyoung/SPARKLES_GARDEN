package com.qac.sparkle_gardens.util;

/**
 * The OrderStatus enum contains a set of states an order can be in. 
 * This can be useful as a customer may want to know what the state
 * of the Order is in.
 * 
 * @author Damien Lloyd
 *
 */
public enum OrderStatus 
{
	/**
	 * The order is a null state with no items in it
	 */
	//EMPTY,
	//not going to use this
	/**
	 * Order has items in it but has not made it to checkout yet 
	 */
	
	BASKET,
	
	/**
	 * The order has been placed, whether it's paid now or not
	 */
	PLACED,
	
	/**
	 * The order is packed and awaiting dispatch
	 */
	PROCESSED,
	
	/**
	 * the order has been cancled by the user. 
	 * NOTE: After an order is DISPATCHED it cannot be CANCELED
	 */
	CANCELED, 
	/**
	 * The order has been handed over to the courier for dispatch
	 */
	DISPATCHED,
	
	/**
	 * The order has been delivered to the customer
	 */
	DELIVERED,
	
	/**
	 * The order has been returned to the warehouse and refunded
	 * within 30 days of delivery.
	 */
	RETURNED
}
