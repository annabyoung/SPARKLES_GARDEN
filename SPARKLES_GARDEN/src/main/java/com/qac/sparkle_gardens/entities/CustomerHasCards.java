package com.qac.sparkle_gardens.entities;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 


/**
 * 
 * @author Sean Connelly
 * composite key for card to customer 
 * which has a many to many relationship 
 *
 */

public class CustomerHasCards {
	
	@Id 
	@JoinColumn(name="customer_fk", nullable = false)
	@ManyToOne
	private Customer customer;
	
	@Id 
	@JoinColumn (name="card_fk", nullable= false)
	@ManyToOne
	private Card card;
	
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
