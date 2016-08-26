package com.qac.sparkle_gardens.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.qac.sparkle_gardens.util.PaymentStatus;

/*
 * @author Allen Su
 */
@Entity
@Table(name = "Payments")
@Deprecated
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
	private double paidAmount;
	@Column(name = "paymentStatus", nullable = false)
	@NotNull
	private PaymentStatus paymentStatus;

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Payment() {
	}

	/**
	 * 
	 * @param customerID
	 * @param cardID
	 */
	public Payment(long customerID, long cardID, long paidAmount, PaymentStatus paymentStatus) {
		this.customerID = customerID;
		this.cardID = cardID;
		this.paidAmount = paidAmount;
		this.paymentStatus = paymentStatus;
	}

	/**
	 * 
	 * @param customerID
	 * @param cardID
	 */
	public Payment(long paymentID, long customerID, long cardID, long paidAmount, PaymentStatus paymentStatus) {
		this.paymentID = paymentID;
		this.customerID = customerID;
		this.cardID = cardID;
		this.paidAmount = paidAmount;
		this.paymentStatus = paymentStatus;
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