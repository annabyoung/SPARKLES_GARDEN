package com.qac.sparkle_gardens.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * @author Allen Su.
 */
@Entity
@Table(name = "Payments")

@NamedQueries ({
	 @NamedQuery (name = Payment.FIND_BY_CARD_NUMBER, 
			      query="SELECT a FROM Payments a WHERE a.cardNumber = :cardNumber"),
	 @NamedQuery (name = Payment.FIND_BY_PID, 
	 			query="SELECT a FROM Payments a WHERE a.pid = :pid")
})

public class Payment {
	@Id
	@Column(name = "pid")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String pid;
	@Column(name = "nameOnCard", nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String cardOwnerName;
	@Pattern(regexp="[0-9]{16}",
            message="{invalid.cardNumber}")
	@Column(name = "cardNumber", nullable = false, length = 16)
	@NotNull
	private String cardNumber;
	@Column(name = "expirationDate", nullable = false, length = 5)
	@NotNull
	@Pattern(regexp="[0-1][0-9]/[0-9]{2}",
            message="{invalid.expirationDate}")
	private String expirationDate;
	@JoinColumn(name="accountID_fk", nullable=false)
	@NotNull
	private Customer customer;
	//private String issueNumber; 
	
	public static final String FIND_BY_CARD_NUMBER = "Payment.getCardNumber";
	public static final String FIND_BY_PID = "Payment.getPid";

	public Payment() {
	}

	public Payment(String customerName, String cardNumber, String expirationDate, Customer customer) {
		this.cardOwnerName = customerName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.customer = customer;
	}
	
	public String getPid(){
		return pid;
	}

	public String getCardOwnerName() {
		return cardOwnerName;
	}

	public void setCardOwnerName(String name) {
		this.cardOwnerName = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Customer getCustomer() { return customer; }
	public void setCustomer(Customer customer) { this.customer = customer; }
}