package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.repositories.WishlistRepository;
import com.qac.sparkle_gardens.util.MessageSender;
import com.qac.sparkle_gardens.util.OrderStatus;

/**
 * The OrderService provides the functionality required for 
 * the Order to have meaning and context within the system.
 * 
 * @author Damien Lloyd
 *
 */
@Stateless
public class OrderService 
{
	@Inject
	OrderRepository repository;
	
	@Inject
	WishlistRepository w_repository;
	
	List<OrderLine> basket = new ArrayList<OrderLine>();
	
<<<<<<< HEAD
	MessageSender sender = new MessageSender();
=======
//	@Inject
//	MessageSender sender;
>>>>>>> a0f8dbfaebece88cde011b8538a7caf32abec5ea
	
	/**
	 * Default constructor
	 */
	public OrderService()
	{
		//sender = new MessageSender();
	}
	
	/**
	 * Checks if the orderID is empty. If all the OrderLines have a
	 * total quantity of 0, then the order is empty.
	 * @param orderID
	 * @return
	 */
	public boolean isOrderEmpty(long orderID)
	{
		List<OrderLine> lines = 
			repository.getOrder(orderID).getOrderLines();
		int totalQuantity = 0;
		
		for (OrderLine i : lines)
		{
			totalQuantity += i.getQuantity();
		}
		
		if (totalQuantity == 0)
			return true;
		
		return false;
	}
	
	/**
	 * This function checks the order, ensuring the price is
	 * not negative, and the quantity ordered is agreeable
	 * with that product's stock levels.
	 * @param quantity
	 * @param price
	 * @return true if the order passes, false if otherwise
	 */
	public boolean isValid(int quantity, double price, int stocklevel)
	{
		if (quantity <= 0 || price <= 0.0 || 
		  stocklevel <= 0 || quantity > stocklevel)
			return false;
		return true;
	}
	
	/**
	 * Return the total price of the order from all the 
	 * OrderLines therein.
	 * @param lines - The list of OrderLines to be passed
	 * @return
	 */
	public double getTotalPrice(long orderID)
	{
		List<OrderLine> lines = repository.getOrder(orderID).getOrderLines();
		double totalPrice = 0;
		
		for (OrderLine i : lines)
		{
			totalPrice += (i.getProduct().getPrice() * i.getQuantity());
		}
		
		if (totalPrice == 0)
			return 0.0;
		
		return totalPrice;
	}
	
	/**
	 * Generate an invoice from the Order relating to
	 * orderID. The invoice will include word of appreciation
	 * as well as listing the products, their quantity and the total price
	 * of each OrderLine.
	 * 
	 * @param orderID
	 * @return This function will return a String which will be the invoice itself.
	 */
	public String generateInvoice(long orderID)
	{
//		String invoice = "";
//		List<OrderLine> lines = repository.getOrder(orderID).getOrderLines();
//		
//		invoice += "\n\n\n----------------------------------------------";
//		
//		invoice += "Thank you for shopping at NBGardens!\n";
//		invoice += "You have purchased the following items: \n";
//		QueueSession session = sender.getSession();
////		Queue queue = sender.getQueue();
//		String result = "";
//		
//		try
//		{
//			MapMessage msg = session.createMapMessage();
//			msg.setString("Invoice", "Invoice");
//			
//			QueueSender sender = session.createSender(queue);
//			sender.send(msg);
//			
//			String inv = "JMSCorrelationID = " + msg.getJMSMessageID();
//			QueueReceiver receiver = 
//					session.createReceiver(queue, inv);
//			
//			TextMessage tm = (TextMessage) receiver.receive(30_000);
//			
//			if (tm == null)
//			{
//				result = "No invoice!";
//			} else result = tm.getText();
//		} catch (JMSException jmse) {
//			jmse.printStackTrace();
//		}
//		return result;
		return "";
	}
	
	/**
	 * Add product to the basket with quantity
	 * @param p Product
	 * @param quantity Desired quantity
	 * @return If product can be added or not
	 */
	public boolean addProductToBasket(Product p, int quantity)
	{
		if (p == null)
			return false;
		
		if (!isValid(quantity, p.getPrice(), p.getStockLevel()))
			return false;
		
		basket.add(new OrderLine(p, quantity));
		
		return true;
	}
	
	/**
	 * Remove item from the basket by quantity
	 * @param p Product to be removed
	 * @return
	 */
	public boolean removeItemFromBasket(Product p)
	{
		if (isBasketEmpty())
			return false;
		
		for (int i = 0; i < basket.size(); i++)
		{
			if (basket.get(i).getProduct().equals(p))
			{
				basket.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Is basket empty?
	 * @return
	 */
	public boolean isBasketEmpty()
	{
		return basket.isEmpty();
	}
	
	/**
	 * Clears all 
	 * @return
	 */
	public boolean clearBasket()
	{
		if (basket.isEmpty())
			return false;
		
		return basket.removeAll(basket);
	}
	
	/**
	 * Returns the basket
	 */
	public List<OrderLine> getBasket()
	{
		return basket;
	}
	
	/**
	 * Create Order with the orderlines of the basket transferred.
	 * The ID of the order is automatically generated.
	 * @param customerID
	 * @return
	 */
	public boolean createOrder(boolean payLater)
	{
		if (basket.isEmpty())
			return false;
		
		Order order = new Order();
		order.setPayLater(payLater);
		
		for (OrderLine i : basket)
		{
			order.addOrderLine(i);
			
			if (w_repository.inWishlist(i.getProduct(), order.getCustomer().getAccountID()))
				w_repository.removeProduct(i.getProduct(), order.getCustomer().getAccountID());
		}
		
		order.setOrderStatus(OrderStatus.PLACED);
		repository.persistOrder(order);
		
		this.clearBasket();
		
		return true;
	}
	
	/**
	 * Returns Order based on order ID
	 * @param orderID
	 * @return The Order
	 */
	public Order getOrder(long orderID)
	{
		return repository.getOrder(orderID);
	}
	
	/**
	 * Get repository
	 */
	public final OrderRepository getRepository()
	{
		return repository;
	}
	
	/**
	 * Gets the number of days since an order 
	 * has been dispatched
	 * @param orderID The id of the order enquired
	 */
	public boolean isEligibleForRefund(long orderID)
	{
		// if the # of days since dispatch > 30 days
		// return false;
		return true;
	}
	
	 /**
	 * Validate whether an order's status allows for cancellation.
	 * If order is either placed or packing, it can still be cancelled
	 * 
	 * @param order
	 * @return true; false
	 */
	public boolean canCancelOrder(Order order)
	{
		OrderStatus orderStatus = order.getOrderStatus();
		
		if (orderStatus == OrderStatus.PLACED || 
			orderStatus == OrderStatus.PACKING)
		{
			return true;
		}
		return false;
	}
}
