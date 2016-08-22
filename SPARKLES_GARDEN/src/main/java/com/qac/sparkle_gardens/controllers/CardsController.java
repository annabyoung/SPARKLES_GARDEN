package com.qac.sparkle_gardens.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.services.CardService;

@Named(value="cards")
@RequestScoped
public class CardsController {
	@Inject private CurrentUserController currentUserController;
	@Inject private CardService cardService;
	
	private List<Card> cards;
	
	public List<Card> getCards() {
		//return cardService.getCardsByCustomer(currentUserController.getCustomerId());
		return cardService.getCardsByCustomer(3);
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}