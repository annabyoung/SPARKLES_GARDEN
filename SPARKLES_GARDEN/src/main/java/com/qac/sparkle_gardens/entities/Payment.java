package com.qac.sparkle_gardens.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * @author Allen Su
 */
@Entity
@Table(name = "Payments")


public class Payment {
//	@Id
//	@Column(name = "pid")	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long pid;
//	@Column(name = "nameOnCard", nullable = false, length = 225)
//	@NotNull
//	@Size(min = 2, max = 225)
//	private String cardOwnerName;
//	@Pattern(regexp="[0-9]{16}",
//            message="{invalid.cardNumber}")
//	@Column(name = "cardNumber", nullable = false, length = 16)
//	@NotNull
//	private String cardNumber;
//	@Column(name = "expirationDate", nullable = false, length = 5)
//	@NotNull
//	@Pattern(regexp="[0-1][0-9]/[0-9]{2}",
//            message="{invalid.expirationDate}")
//	private String expirationDate;
//	@JoinColumn(name="accountID_fk", nullable=false)
//	@NotNull
//	private Customer customer;
	//private String issueNumber; 
	@Id
	@Column(name = "paymentID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentID;
	@Column(name = "customerID", nullable = false)
	@NotNull
	private long customerID;
	@Column(name = "cardID", nullable = false)
	@NotNull
	private long cardID;
	@Column(name = "paidAmount", nullable = false)
	@NotNull
	private long paidAmount;

	public Payment() {
	}

	public Payment(long customerID, long cardID) {
		super();
		this.customerID = customerID;
		this.cardID = cardID;
	}

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public long getCardID() {
		return cardID;
	}

	public void setCardID(long cardID) {
		this.cardID = cardID;
	}

}
	
