package com.qac.sparkle_gardens.controllers;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.repositories.CustomerHasCardRepository;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.CustomerService;

/**
 * 
 * @author allensu
 *
 */
@Named(value="registerCard")
@RequestScoped
public class RegisterCard {
	@Inject CardRepository cardRepository;
	@Inject CustomerHasCardRepository customerHasCardRepository;
	@Inject CustomerService customerService;
	@Inject CardService cardService;
	@Inject Logger log;
	
	private String nameOnCard = "";
	private String cardNumber = "";
	private String expirationDate = "";
	
	public void register(){
		System.out.println(">>> " + nameOnCard + "'s card: " + cardNumber + " <<<");
		Card newCard = cardService.setupCard(nameOnCard, cardNumber, expirationDate);
		cardRepository.addCard(newCard);
		customerHasCardRepository.addCustomerHasCard(new CustomerHasCard(customerService.getCustomerByID(3), newCard));
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

	public String getNameOnCard() {
		return nameOnCard;
	}
	
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
}