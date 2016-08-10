package com.qac.sparkle_gardens.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.qac.sparkle_gardens.util.OrderStatus;

/**
 * The Order class contains all the order lines along with 
 * the orderID and the customerID. This class does not hold 
 * all the products themselves; see OrderLine if you want to access
 * what products an Order has.
 * 
 * @author Damien Lloyd
 */
@Entity
@Table (name = "order")
public class Order 
{
	@Id
	@NotNull
	@Column (name = "orderID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderID;
	
	@Id
	@Column (name = "customerID", nullable = false)
	@NotNull
	private Customer customer;
	
	@Column (name = "payLater", nullable = true)
	@Null
	private boolean payLater;
	
	@Column (name = "Status", nullable = true)
	@Null
	private OrderStatus status;
	
	// List of orderlines in the order
	private ArrayList<OrderLine> lines;
	
	/**
	 * Default constructor
	 */
	public Order()
	{
		this(0, new Customer());
	}
	
	/**
	 * Construct Order with credentials such as orderID and customerID.
	 */
	public Order(long orderID, Customer customer)
	{
		this.status = OrderStatus.EMPTY;
		this.orderID = orderID;
		this.customer = customer;
	}
	
	/**
	 * Get the order ID
	 * @return orderID
	 */
	public long getOrderID() 
	{
		return orderID;
	}
	
	/**
	 * Get customer
	 * @return customerID
	 */
	public Customer getCustomer()
	{
		return customer;
	}
	
	/**
	 * This adds an OrderLine object into
	 * an order. See OrderLine for what it contains.
	 * @param ol
	 */
	public void addOrderLine(OrderLine ol)
	{
		lines.add(ol);
	}
	
	/**
	 * Remove an OrderLine object from the list.
	 * @param ol
	 */
	public void removeOrderLine(OrderLine ol)
	{
		lines.remove(ol);
	}
	
	/**
	 * Get all the OrderLines in the Order
	 * @return
	 */
	public ArrayList<OrderLine> getOrderLines()
	{
		return lines;
	}
	
	/**
	 * Is the order buy-now-pay-later? If yes, 
	 * feed me a boolean!
	 * @param payLater
	 */
	public void setPayLater(boolean payLater)
	{
		this.payLater = payLater;
	}
	
	/**
	 * Set the state of an order. See OrderStatus
	 * for all available states.
	 * @param status
	 */
	public void setStatus(OrderStatus status)
	{
		this.status = status;
	}
	
	/**
	 * Get the state of an order it's in.
	 * @return
	 */
	public OrderStatus getStatus()
	{
		return status;
	}

	public boolean isPayLater() {
		return payLater;
	}
}
