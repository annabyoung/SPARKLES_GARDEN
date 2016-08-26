package com.qac.sparkle_gardens.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 


/**
 * 
 * @author Sean Connelly
 * composite key for card to customer 
 * which has a many to many relationship 
 *
 */
@Entity
@IdClass(CustomerHasCardId.class)
@Table(name="customerHasCard")
public class CustomerHasCard {
	
	@Id private Customer customer;
	
	@Id private Card card;

	public CustomerHasCard() {}
	
	public CustomerHasCard(Customer customer, Card card) {
		this.customer = customer;
		this.card = card;
	}

	public Customer getCustomer(){
		return customer;
	}
	
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	
	public Card getCard(){
		return card;
	}
	
	public void setCard(Card card){
		this.card = card;
	}
}

class CustomerHasCardId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5678850189784439008L;

	@JoinColumn(name="customer_fk", nullable = false)
	@ManyToOne
	private Customer customer;
	
	@JoinColumn (name="card_fk", nullable= false)
	@ManyToOne
	private Card card;

	public CustomerHasCardId() { }
	
	public CustomerHasCardId(Customer customer, Card card) {
		this.customer = customer;
		this.card = card;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Card getCard() {
		return card;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerHasCardId other = (CustomerHasCardId) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
}