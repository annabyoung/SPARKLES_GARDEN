package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.repositories.CardRepository;
//import com.qac.sparkle_gardens.repositories.PaymentRepository;
import com.qac.sparkle_gardens.util.PaymentStatus;

/**
 * 
 * @author Allen Su
 *
 */
@Named(value = "RefundCard")
@RequestScoped
public class RefundCard {
	//@Inject PaymentRepository paymentRepository;
	@Inject private CardRepository cardRepository;

	private String error = "";
	/**
	 * Refund card checks what status the payment was at previously. And then
	 * it either voids the payment or sets up a refund based on whether or not
	 * someone was paid before.
	 * 
	 * @param p
	 * @return
	 */
	public String refundCard(Order o){
		
		switch(o.getPaymentStatus()){
		case PAID:
			//payout.
			break;
		case PENDING:
			o.setPaymentStatus(PaymentStatus.VOID);
			error = "";
			break;
		case OVERDUE:
			//have to confirm business rules.
			break;
		default:
			error = "Previous Payment Status Error";
		}
		error = "";     
		return "#";
	}
	
	public String getError(){
		return error;
	}
}
