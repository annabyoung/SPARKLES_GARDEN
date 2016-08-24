package com.qac.sparkle_gardens.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.CustomerService;
/**
 * 
 * @author allensu
 *
 */
@Named(value="cards")
@RequestScoped
public class CardsController {
	@Inject private CurrentUserController currentUserController;
	@Inject private CustomerService cusService;
	@Inject private CardService cardService;

	@Produces
	@Named
	private Card newCard;
	
	@PostConstruct
	public void initNewCard(){
		newCard = new Card();
	}
	
	public void register(){
		Customer currentCustomer = cusService.getCustomerByID(currentUserController.getCustomerId());
		cardService.registerCard(newCard, currentCustomer);
		initNewCard();
	}
	
	public List<Card> getCards() {
		return cardService.getCardsByCustomer(currentUserController.getCustomerId());
	}
}