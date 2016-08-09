package com.qac.sparkle_gardens.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.qac.sparkle_gardens.util.PaymentStatus;

/*
 * @author Allen Su
 */
@Entity
@Table(name = "Payments")


public class Payment {

	@Id
	@Column(name = "paymentID", nullable = false, unique = true)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentID;
	@Column(name = "customerID", nullable = false)
	@NotNull
	private long customerID;
	@Column(name = "cardID", nullable = false)
	@NotNull
	private long cardID;
	@Column(name = "paidAmount")
	private long paidAmount;
	@Column(name = "paymentStatus", nullable = false)
	@NotNull
	private PaymentStatus paymentStatus;

	public Payment() {
	}

	/**
	 * 
	 * @param customerID
	 * @param cardID
	 */
	public Payment(long customerID, long cardID) {
		super();
		this.customerID = customerID;
		this.cardID = cardID;
	}

	/**
	 * 
	 * @return paymentID
	 */
	public long getPaymentID() {
		return paymentID;
	}

	/**
	 * 
	 * @param paymentID
	 */
	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	/**
	 * 
	 * @return customerID
	 */
	public long getCustomerID() {
		return customerID;
	}

	/**
	 * 
	 * @param customerID
	 */
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	/**
	 * 
	 * @return cardID
	 */
	public long getCardID() {
		return cardID;
	}

	/**
	 * 
	 * @param cardID
	 */
	public void setCardID(long cardID) {
		this.cardID = cardID;
	}

}
	
