package com.qac.sparkle_gardens.controllers;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.util.MethodAuthor;
import com.qac.sparkle_gardens.util.OrderStatus;
import com.qac.sparkle_gardens.util.PaymentStatus;

public class OrderController 
{
	@Inject
	private OrderService service;
	
	@Inject
	private CardService cService;
	
	@Inject
	private RefundCard refund;
	
	@Inject
	private PayByCard pay;
	
	private String cardNumber = "", expirationDate = "";
	private String cardOwnerName = "", cvs = "";
	
	private long orderID, productID;
	private int quantity;
	
	private String invoice = "";
	
	@SuppressWarnings("unused")
	public String amendOrder(long orderID, long productID, int quantity)
	{
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
		
		Order o = service.getOrder(orderID);
		
		if (o.getOrderStatus() == OrderStatus.DISPATCHED)
			return "order_not_amended";
		
		for (int i = 0; i < o.getOrderLines().size(); i++)
		{
			if (o.getOrderLines().get(i).getProduct().getProductID() == productID)
				o.getOrderLines().get(i).setQuantity(quantity);
			
			return "order_amended";
		}
		return "order_not_amended";
	}
	
	/**
	 * Take the order's ID, check that the order's status is not empty, dispatched or delivered
	 * If status is valid for cancellation, check if the order is marked for 'pay later'
	 * If it is pay later, then payment status is set to void, if not then customer must be refunded
	 * 
	 * 
	 * @param orderID
	 * @return
	 */
	@MethodAuthor (author = "Annabelle Young")
	public String cancelOrder(long orderID)
	{
		Order order = service.getOrder(orderID);
		if (service.canCancelOrder(order))
		{
			if(order.isPayLater())
			{
				order.setPaymentStatus(PaymentStatus.VOID);
			}
			refund.refundCard(order);
			return "order_cancelled";
		}
		return "order_not_cancelled";
	}
	
	/**
	 * Generate an invoice once an order has been placed
	 * @param orderID
	 * @return
	 */
	public String createInvoice(long orderID)
	{
		invoice = service.generateInvoice(orderID);
		
		return "orders";
	}
	
	/**
	 * Place order with order ID and option to pay later
	 * @param orderID The order ID Order pertains to
	 * @param payLater Do you want to buy-now-pay-later?
	 * @return
	 */
	public String placeOrder(long orderID, boolean payLater)
	{
		if (service.isOrderEmpty(orderID))
			return "home";
		
		if (cardNumber.equals("") || cvs.equals("") || expirationDate.equals(""))
			return "home";
		
		service.createOrder(payLater);	
		
		if (!payLater)
		{
			double price = service.getTotalPrice(orderID);
			pay.payByCard(cardOwnerName, cardNumber, expirationDate, price, cvs);
			return "home";
		}
		
		this.createInvoice(orderID);
		
		return "home";
	}
	
	/**
	 * This function checks whether the Order is eligible for a refund 
	 * (30 days after dispatch) and refunds the order based on card.
	 * @param orderID
	 * @return
	 */
	public String returnOrder(long orderID)
	{
		Order o = service.getOrder(orderID);
		
		if (service.isEligibleForRefund(orderID) && !o.isPayLater())
		{
			o.setOrderStatus(OrderStatus.RETURNED);
			cService.refundCard(cardNumber, expirationDate);
			return "order_returned";
		}
		return "order_not_returned";
	}

	public long getOrderID() 
	{
		return orderID;
	}

	public long getProductID() 
	{
		return productID;
	}

	public int getQuantity() 
	{
		return quantity;
	}
	
	public String getCardNumber() 
	{
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) 
	{
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() 
	{
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) 
	{
		this.expirationDate = expirationDate;
	}

	public String getCardOwnerName() 
	{
		return cardOwnerName;
	}

	public void setCardOwnerName(String cardOwnerName) 
	{
		this.cardOwnerName = cardOwnerName;
	}

	public String getCvs() 
	{
		return cvs;
	}

	public void setCvs(String cvs) 
	{
		this.cvs = cvs;
	}
	
	public void setOrderID(long orderID) 
	{
		this.orderID = orderID;
	}

	public void setProductID(long productID) 
	{
		this.productID = productID;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public String getInvoice()
	{
		return invoice;
	}
}

