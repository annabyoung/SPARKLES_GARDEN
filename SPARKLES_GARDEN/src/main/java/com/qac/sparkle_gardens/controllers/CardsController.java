package com.qac.sparkle_gardens.controllers;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Card;

@Named(value="cards")
@RequestScoped
public class CardsController {

	private List<Card> cards;
	
	public List<Card> getCards() {
		return cards;
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}