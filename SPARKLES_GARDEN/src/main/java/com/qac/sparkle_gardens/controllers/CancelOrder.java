package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.util.OrderStatus;
import com.qac.sparkle_gardens.util.PaymentStatus;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.controllers.RefundCard;

/**
 * 
 * @author Annabelle Young
 * 
 * Allows the customer to cancel an order before it has left the warehouse.
 * In case customer realizes they ordered incorrect quantity, item, or no longer desire the item before it is dispatched to them.
 *
 */

@Named (value = "cancelOrder")
@RequestScoped
public class CancelOrder 
{
	@Inject
	OrderService service;
	
	@Inject
	RefundCard refund;
	
	/**
	 * Take the order's ID, check that the order's status is not empty, dispatched or delivered
	 * If status is valid for cancellation, check if the order is marked for 'pay later'
	 * If it is pay later, then payment status is set to void, if not then customer must be refunded
	 * 
	 * 
	 * @param orderID
	 * @return
	 */
	public String cancelOrder(long orderID)
	{
		Order order = service.getOrder(orderID);
		if (service.isEligibleForRefund(orderID));
		{
			if(order.isPayLater())
			{
				order.setPaymentStatus(PaymentStatus.VOID);
			}
			refund.refundCard(order);
			return "cancelled_order";
		}
		return "order_not_cancelled";
	}
	
	public String cancelOrder(long orderID)
	{
		Order order = service.getOrder(orderID);
		
		if (order.getOrderStatus() == OrderStatus.DISPATCHED
				order.getOrderStatus() == OrderStatus.DELIVERED)
		{
			return "cannot_cancel_order";
		}
	}
}
