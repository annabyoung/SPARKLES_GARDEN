package com.qac.sparkle_gardens.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.CustomerService;

@Named(value="cards")
@RequestScoped
public class CardsController {
	@Inject private CurrentUserController currentUserController;
	@Inject private CardService cardService;
	@Inject private CustomerService customerService;
	
	@Named
	@Produces
	private Card newCard;
	
    @PostConstruct
    public void initNewCard() {
        newCard = new Card();
    }
	
	public List<Card> getCards() {
		return cardService.getCardsByCustomer(currentUserController.getCustomerId());
	}
	
	public void register(){
		cardService.registerCard(newCard, customerService.getCustomerByID(currentUserController.getCustomerId()));
		initNewCard();
	}
}