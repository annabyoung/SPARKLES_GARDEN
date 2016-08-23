package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.ProductService;
import com.qac.sparkle_gardens.util.MethodAuthor;
import com.qac.sparkle_gardens.util.OrderStatus;
import com.qac.sparkle_gardens.util.PaymentStatus;

@Deprecated
@Named (value = "orderController")
@RequestScoped
public class OrderController 
{
	@Inject
	private OrderService service;
	
	@Inject
	private ProductService pService;
	
	@Inject
	private CardService cService;
	
	@Inject
	private RefundCard refundCard;
	
	@Inject
	private PayByCard pay;
	
	private int quantity;
	private double price;
	
	private long orderID;
	private long productID;
	
	private boolean payLater;
	
	private String cardName, cardNumber;
	private String expirationDate, cvs;
	
	/**
	 * Default constructor
	 */
	public OrderController()
	{
		quantity = 0;
		price = 0.0;
		
		orderID = 0;
		productID = 0;
	}
	
	/**
	 * Add product to basket by product ID
	 * @param productID
	 * @param quantity
	 * @return
	 */
	@RequestScoped
	public String addProductToBasket(long productID, int quantity)
	{
		Product p = pService.getProductByID(productID);

		if (!pService.checkInStock(p))
			return "product_not_in_stock";
		
		service.addProductToBasket(p, quantity);
		
		return "home";
	}
	
	/**
	 * Modify the quantity of the product
	 * @param productID
	 * @param quantity
	 * @return
	 */
	@RequestScoped
	public String modifyQuantity(long productID, int quantity)
	{
		removeProductFromBasket(productID);
		return addProductToBasket(productID, quantity);
	}
	
	/**
	 * Remove product from the basket
	 * @param productID
	 * @return
	 */
	@RequestScoped
	String removeProductFromBasket(long productID)
	{
		if (!service.isBasketEmpty())
			service.removeItemFromBasket(pService.getProductByID(productID));
		
		return "home";
	}
	
	/**
	 * Place order with the products in the basket
	 * @param orderID
	 * @param payLater
	 * @param cardOwnerName
	 * @param cardNumber
	 * @param expirationDate
	 * @param cvs
	 * @return
	 */
	@RequestScoped
	public String placeOrder(long orderID, boolean payLater, 
			String cardOwnerName, String cardNumber, 
			 String expirationDate, String cvs)
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
		
		service.generateInvoice(orderID);
		
		return "home";
	}
	
	/**
	 * Amend the quantity of the products in order
	 * @param orderID
	 * @param productID
	 * @param quantity
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestScoped
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
	 * Return the order; get refund if not paid later.
	 * @param orderID
	 * @param cardNumber
	 * @param expirationDate
	 * @return
	 */
	@RequestScoped
	public String returnOrder(long orderID, String cardNumber, 
				String expirationDate)
	{
		Order o = service.getOrder(orderID);
		o.setOrderStatus(OrderStatus.RETURNED);
		
		if (service.isEligibleForRefund(orderID) && !o.isPayLater())
		{
			cService.refundCard(cardNumber, expirationDate);
			return "order_history";
		}
		
		return "order_history";
	}
	
	/**
	 * Clear the basket
	 * @return
	 */
	@RequestScoped
	public String clearBasket()
	{
		service.clearBasket();
		return "home";
	}
	
	/**
	 * Create invoice from order
	 * @param orderID
	 * @return
	 */
	@RequestScoped
	public String createInvoice(long orderID)
	{
		service.generateInvoice(orderID);
		
		return "orders";
	}
	
	/**
	 * Cancel the order, removing items from basket
	 * @param orderID
	 * @return
	 */
	@RequestScoped
	@MethodAuthor(author = "Annabelle Young")
	public String cancelOrder(long orderID)
	{
		Order order = service.getOrder(orderID);
		if (service.isEligibleForRefund(orderID))
		{
			if(order.isPayLater())
			{
				order.setPaymentStatus(PaymentStatus.VOID);
			}
			refundCard.refundCard(order);
			return "cancelled_order";
		}
		return "cannot_cancel_order";
	}
	
	/**
	 * Get quantity 
	 * @return
	 */
	public int getQuantity(long productID) 
	{
		for (OrderLine ol : service.getBasket())
		{
			if (ol.getProduct().getProductID() == productID)
				return ol.getQuantity();
		}
		return -1;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}

	public long getOrderID() 
	{
		return orderID;
	}

	public void setOrderID(long orderID) 
	{
		this.orderID = orderID;
	}

	public long getProductID() 
	{
		return productID;
	}

	public void setProductID(long productID) 
	{
		this.productID = productID;
	}

	public boolean isPayLater() 
	{
		return payLater;
	}

	public void setPayLater(boolean payLater) 
	{
		this.payLater = payLater;
	}

	public String getCardName() 
	{
		return cardName;
	}

	public void setCardName(String cardName) 
	{
		this.cardName = cardName;
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

	public String getCvs() 
	{
		return cvs;
	}

	public void setCvs(String cvs) 
	{
		this.cvs = cvs;
	}
}
