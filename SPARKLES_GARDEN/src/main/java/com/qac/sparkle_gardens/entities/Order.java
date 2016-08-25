package com.qac.sparkle_gardens.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.qac.sparkle_gardens.util.OrderStatus;
import com.qac.sparkle_gardens.util.PaymentStatus;

/**
 * The Order class contains all the order lines along with 
 * the orderID and the customerID. This class does not hold 
 * all the products themselves; see OrderLine if you want to access
 * what products an Order has.
 * 
 * @author Damien Lloyd
 */
@NamedQueries (
		{
//			@NamedQuery (name = Order.FIND_BY_ID, query = "SELECT o FROM Order o WHERE o.orderID = :orderID"),
	
		}
)
@Entity
@Table (name = "Order")
public class Order 
{
	public class OrderLinePairs {
		
		@Column
		@NotNull
		private int quantity;
		
		@Column
		@NotNull 
		private Product product;
		//check quantity is 1 
		public OrderLinePairs(int quantity, Product product) {
			this.quantity = quantity;
			this.product = product;
		}
		public OrderLinePairs(Product product) {
			this.quantity = 1;
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
	}//order line pairs 	
	
	
	@Id
	@NotNull
	@Column (name = "orderID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderID;
	
	@ManyToOne
	@JoinTable (name = "customers")
	private Customer customer;
	
	@Column (name = "payLater", nullable = true)
	@Null
	private boolean payLater;
	
	@Column (name = "Order Status", nullable = false)
	@Null
	private OrderStatus orderStatus;
	
	@Column (name = "Payment Status", nullable = false)
	@NotNull
	private PaymentStatus paymentStatus;
	
	@Column (name = "cardID", nullable = true)
	@Null
	private Card card;
	
	// List of orderlines in the order
	public List<OrderLinePairs> lines = new ArrayList<OrderLinePairs>();
	
	/**
	 * Default constructor
	 */
	public Order(){}
	
	/**
	 * Construct Order with credentials such as orderID and customerID.
	 */
	public Order(long orderID, Customer customer)
	{
		this.orderStatus = OrderStatus.EMPTY;
		this.paymentStatus = PaymentStatus.UNPAID;
		this.orderID = orderID;
		this.customer = customer;
	}
	
	/**
	 * Construct Order with orderID, Customer and Card
	 * @param orderID
	 * @param customer
	 * @param card
	 */
	public Order(long orderID, Customer customer, Card card)
	{
		this(orderID, customer);
		this.card = card;
	}
	
	
	
	public void add(Product product){
		OrderLinePairs e = new OrderLinePairs(product);
		lines.add(e);
	}
	
	public void add( int quantity, Product product){
		OrderLinePairs e = new OrderLinePairs(quantity, product);
		lines.add(e);
	}
	
	
	// getters and setters
	
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
	public void addOrderLine(OrderLinePairs ol)
	{
		lines.add(ol);
	}
	
	/**
	 * Remove an OrderLine object from the list.
	 * @param ol
	 */
	public void removeOrderLine(OrderLinePairs ol)
	{
		lines.remove(ol);
	}
	
	/**
	 * Get all the OrderLines in the Order
	 * @return lines
	 */
	public List<OrderLinePairs> getOrderLines()
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
	 * Retrieves whether the order is payLater
	 * If isPayLater is true, then it is buy now pay later, otherwise it's buy now pay now
	 * 
	 * @return
	 */
	public boolean isPayLater() 
	{
		return payLater;
	}
	
	/**
	 * Set the state of an order. See OrderStatus
	 * for all available states.
	 * @param status
	 */
	public void setOrderStatus(OrderStatus orderStatus)
	{
		this.orderStatus = orderStatus;
	}
	
	/**
	 * Get the state of an order it's in.
	 * @return status
	 */
	public OrderStatus getOrderStatus()
	{
		return orderStatus;
	}
	
	/**
	 * Retrieve the payment status of an order.
	 * 
	 */
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	
	/**
	 * Set the payment status of an order
	 * See PaymentStatus for all status types
	 * @param paymentStatus
	 */
	public void setPaymentStatus(PaymentStatus paymentStatus) 
	{
		this.paymentStatus = paymentStatus;
	}
	
	
	

}



