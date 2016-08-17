package com.qac.sparkle_gardens.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * @author Allen Su
 */
@Entity
public class Card implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -145211994927591022L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cardId;
	
	@NotNull
	@Size(min = 2, max = 25)
	private String cardOwnerName;
	
	@NotNull
	@Pattern(regexp = "[0-9]{16}", message = "{invalid.cardNumber}")
	private String cardNumber;
	
	@NotNull
	@Pattern(regexp = "[0-1][0-9]/[0-9]{2}", message = "{invalid.expirationDate}")
	private String expirationDate;

	public Card() {
	}

	/**
	 * 
	 * @param customerName
	 * @param cardNumber
	 * @param expirationDate
	 * @param customer
	 */
	//@Deprecated
	public Card(String customerName, String cardNumber, String expirationDate) {
		this.cardOwnerName = customerName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}

	/**
	 * Only for the purposes of testing offline data.
	 * 
	 * @param cardID
	 * @param customerName
	 * @param cardNumber
	 * @param expirationDate
	 * @param customer
	 */
	//@Deprecated
	public Card(long cardID, String customerName, String cardNumber, String expirationDate) {
		this.cardId = cardID;
		this.cardOwnerName = customerName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}

	/**
	 * Returns Card ID
	 * 
	 * @return
	 */
	public long getCardId() {
		return cardId;
	}

	/**
	 * Returns name of owner of card.
	 * 
	 * @return cardId
	 */
	public String getCardOwnerName() {
		return cardOwnerName;
	}

	/**
	 * Allows corrections for Card Owner Name
	 * 
	 * @param name
	 */
	public void setCardOwnerName(String name) {
		this.cardOwnerName = name;
	}

	/**
	 * Returns card Number
	 * 
	 * @return cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Set card number
	 * 
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	} 

	/**
	 * 
	 * @return expirationDate
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
	 * @param anotherCard
	 * @return boolean
	 */
	public boolean equals(Card anotherCard){
		return anotherCard.getCardId() == cardId;
	}


}