package com.qac.sparkle_gardens.entities;

import javax.persistence.*;
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
	
	@OneToMany 
	@JoinColumn(name = "Order_fk", nullable = false)
	//this may or may not be a thing in this thing 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	@Column(name = "customerName", nullable = false, length = 225)
	@Size(min = 2, max = 225)
	private String cardOwnerName;
	@Pattern(regexp="[0-9]{16}",
            message="{invalid.cardNumber}")
	@Column(name = "cardNumber", nullable = false, length = 16)
	private String cardNumber;
	@Column(name = "expirationDate", nullable = false, length = 5)
	@Pattern(regexp="[0-9]{2}/[0-9]{2}",
            message="{invalid.expirationDate}")
	private String expirationDate;
	private String issueNumber;
	
	public static final String FIND_BY_CARD_NUMBER = "Payment.getCardNumber";
	public static final String FIND_BY_PID = "Payment.getPid";

	public Payment() {

	}

	public Payment(String customerName, String cardNumber, String expirationDate) {
		super();
		this.cardOwnerName = customerName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}
	
	public Long getPid(){
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

	public String getExpiryDate() {
		return expirationDate;
	}

	public void setExpiryDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
}
