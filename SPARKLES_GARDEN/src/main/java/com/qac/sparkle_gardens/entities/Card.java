package com.qac.sparkle_gardens.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * @author Allen Su
 */
@Entity
@Table(name = "Cards")

@NamedQueries ({
	 @NamedQuery (name = Card.FIND_BY_CARD_NUMBER, 
			      query="SELECT a FROM Cards a WHERE a.cardNumber = :cardNumber"),
	 @NamedQuery (name = Card.FIND_BY_cardId, 
	 			query="SELECT a FROM Cards a WHERE a.cardId = :cardId")
})

public class Card {
	@Id
	@Column(name = "cardId")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cardId;
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
	
	public static final String FIND_BY_CARD_NUMBER = "Card.getCardNumber";
	public static final String FIND_BY_cardId = "Card.getcardId";

	public Card() {
	}
	/**
	 * 
	 * @param customerName
	 * @param cardNumber
	 * @param expirationDate
	 * @param customer
	 */
	public Card(String customerName, String cardNumber, String expirationDate, Customer customer) {
		this.cardOwnerName = customerName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.customer = customer;
	}
	
	/**
	 * Returns Card ID
	 * @return
	 */
	public String getCardId(){
		return cardId;
	}

	/**
	 * Returns name of owner of card.
	 * @return cardId
	 */
	public String getCardOwnerName() {
		return cardOwnerName;
	}

	/**
	 * Allows corrections for Card Owner Name
	 * @param name
	 */
	public void setCardOwnerName(String name) {
		this.cardOwnerName = name;
	}

	/**
	 * Returns card Number
	 * @return cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Set card number
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 
	 * @return
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * 
	 * @param expirationDate
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	/**
	 * 
	 * @return customer;
	 */
	public Customer getCustomer() { return customer; }
	/**
	 * Set's Card's customer.
	 * @param customer
	 */
	public void setCustomer(Customer customer) { this.customer = customer; }
}