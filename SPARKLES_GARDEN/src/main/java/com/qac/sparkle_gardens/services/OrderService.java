package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Order.OrderLinePairs;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.repositories.OrderRepository;
import com.qac.sparkle_gardens.repositories.WishlistRepository;
import com.qac.sparkle_gardens.util.MessageSender;
import com.qac.sparkle_gardens.util.OrderStatus;
import com.qac.sparkle_gardens.util.PaymentStatus;
import com.qac.sparkle_gardens.util.MethodAuthor;

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
	
	@Inject
	CardService cService;
	
	
	/**
	 * Default constructor
	 */
	public OrderService()
	{

	}
	
	/**
	 * Checks if the orderID is empty. If all the OrderLines have a
	 * total quantity of 0, then the order is empty.
	 * @param orderID
	 * @return
	 */
	public boolean isOrderEmpty(long orderID)
	{
		List<OrderLinePairs> lines = repository.getOrder(orderID).getOrderLines();
		int totalQuantity = 0;
		
		for (OrderLinePairs i : lines )
		{
			totalQuantity += i.getQuantity();
		}
		
		if (totalQuantity == 0)
			return true;
		
		return false;
	}
	
	
	/**
	 * Is basket empty?
	 * @return
	 */
	public boolean isBasketEmpty(Order basket)
	{
		return basket.lines.isEmpty();
	}
	
	/**
	 * Clears all 
	 * @return
	 */
	public void clearBasket(Order basket)
	{
		basket.lines.clear();
		
	}
	/**
	 * This function checks the order, ensuring the price is
	 * not negative, and the quantity ordered is agreeable
	 * with that product's stock levels.
	 * @param quantity
	 * @param price
	 * @return true if the order passes, false if otherwise
	 */
	public boolean isValid(Order basket,int quantity, double price, int stocklevel)
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
	public double getTotalPrice(Order basket)
	{
		double totalPrice = 0;
		
		for (OrderLinePairs i : basket.getOrderLines())
		{
			totalPrice += (i.getProduct().getPrice() * i.getQuantity());
		}
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
	public String generateInvoice(Order basket, long orderID)
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
		return "Thank you for shopping at NBGardens!";
	}
	
	/**
	 * Add product to the basket with quantity
	 * @param p Product
	 * @param quantity Desired quantity
	 * @return If product can be added or not
	 */
	//added order to paramaters.... STILL TINKERING DUNNO IF WORK DO SCIENCE DANK MEME.GIF
	public boolean addProductToBasket(Order basket, Product product, int quantity)
	{
		if (product == null)
			return false;
		
		if (!isValid(basket, quantity, product.getPrice(), product.getStockLevel()))
			return false;
//		check if product is already in basket.
//		if(orderhasProduct(basket, product)){
//			basket.lines.get(i).setQuanity( += quanity);
//		}
//		else 
		basket.add(quantity, product);
		//TODO: FIX 
		
		return true;
	}
	
	public int orderHasProduct(Order order, Product product ){
			
		for(int i= 0; i>order.lines.size(); i++){
			if (order.lines.get(i).getProduct() == product)
				return i;
		}
		return -1;
	
	}
		
	
	
	/**
	 * Remove item from the basket by quantity
	 * @param p Product to be removed
	 * @return
	 */
	public boolean removeItemFromBasket(Order basket, Product p)
	{
		if (isBasketEmpty(basket))
			return false;
		
		for (int i = 0; i < basket.lines.size(); i++)
		{
			if (basket.lines.get(i).getProduct().
					getProductID() == p.getProductID())
			{
				basket.lines.remove(i);
				return true;
			}
		}
		return false;
	}
	

	
	/**
	 * Returns the basket
	 */
	public List<OrderLinePairs> getBasket(Order basket)
	{
		return basket.lines;
	}
	
	/**
	 * Create Order with the orderlines of the basket transferred.
	 * The ID of the order is automatically generated.
	 * @param customerID
	 * @return
	 */
	
	/// WHAT THE HELL IS THIS NOISE 
	public boolean createOrder(Order basket, boolean payLater)
	{
		if (basket.lines.isEmpty())
			return false;
		
		Order order = new Order();
		order.setPayLater(payLater);
		
		for (OrderLinePairs i : basket.getOrderLines())
		{
			order.addOrderLine(i);
			
			if (w_repository.inWishlist(i.getProduct(), order.getCustomer().getAccountID()))
				w_repository.removeProduct(i.getProduct(), order.getCustomer().getAccountID());
		}
		
		order.setOrderStatus(OrderStatus.PLACED);
		repository.persistOrder(order);
		
		//this.clearBasket();
		
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
	@MethodAuthor(author="Annabelle Young")
	public boolean canCancelOrder(long orderID)
	{
		Order order = repository.getOrder(orderID);
		OrderStatus orderStatus = order.getOrderStatus();
		
		if (orderStatus == OrderStatus.PLACED || 
			orderStatus == OrderStatus.PACKING)
		{
			return true;
		}
		return false;
	}
	
	public Order amendOrder(Order order,  long productID, int quantity)
	{
		//Order o = repository.getOrder(orderID);
		
		if (order.getOrderStatus() == OrderStatus.DISPATCHED)
			return null;
		   //send error message. order dispatched too late to amend 
		
		for (int i = 0; i < order.getOrderLines().size(); i++)
		{
			if (order.getOrderLines().get(i).getProduct().getProductID() == productID)
				order.getOrderLines().get(i).setQuantity(quantity);
			
			return order;
		}
		return null;
	}
	
	/**
	 *  returning an order to warehouse. 
	 *  
	 * @param orderID
	 * @param cardNumber
	 * @param expirationDate
	 * @return
	 */
	
	public boolean returnOrder(long orderID, String cardNumber, String expirationDate)
	{
		Order o = repository.getOrder(orderID);
		
		if (this.isEligibleForRefund(orderID) && !o.isPayLater())
		{
			o.setOrderStatus(OrderStatus.RETURNED);
			cService.refundCard(cardNumber, expirationDate);
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * given a set product 
	 * @param p
	 * @return
	 */
	public int getQuanity(Product p){
		
		 Order order = repository.getOrder(1);
		for( OrderLinePairs orderline : order.getOrderLines() )
		{
			//presumes product is not on multiple order lines.
			if (orderline.getProduct().equals(p))
      			return orderline.getQuantity();	
		}
		return 0; 
		
	}
}
