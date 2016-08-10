package com.qac.sparkle_gardens.entities;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Allen Su
 *
 */
public class CustomerHasCard {
	// Composite key
	@Id
	@JoinColumn (name="customer_fk", nullable = false)
	@ManyToOne
	private Customer customer;
	
	@Id
	@JoinColumn (name="card_fk", nullable = false)
	@ManyToOne 
	private Card Card;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Card getCard() {
		return Card;
	}

	public void setCard(Card Card) {
		this.Card = Card;
	}
	
	
}
