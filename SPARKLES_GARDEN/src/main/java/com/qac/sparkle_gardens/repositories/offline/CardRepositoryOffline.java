package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.util.CardInitialData;


public class CardRepositoryOffline implements CardRepository
{
	@Inject
	PaymentInitialData initialPaymentData;
	@Inject
	CardInitialData initialCardData;
	
	public void persistCard(Card c) {
		initialCardData.addCard(c);
	}
	public ArrayList<Card> listCards() {
		return initialCardData.getCards(); 
	}
	public void persistCards(ArrayList<Card> p) {
		// TODO Auto-generated method stub
		
	}
	public Card findByID(String id) {
		// TODO Auto-generated method stub
		for (Card c : initialCardData.getCards()){
			if(id == c.getCardId()){
				return c;
			}
		}
		return null;
	}
	public ArrayList<Card> getCards() {
		// TODO Auto-generated method stub
		return initialCardData.getCards();
	}
	public void updateCard(Card p) {
		// TODO Auto-generated method stub
		
	}
	public void removeCard(Card p) {
		// TODO Auto-generated method stub
		//initialCardData.getCards()...
	}
	@Override
	public List<Card> findByCardNumber(String cardNumber) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (Card c : initialCardData.getCards()){
			if(cardNumber == c.getCardNumber()){
				cards.add(c);
			}
		}
		return cards;
	}
	@Override
	public void addCard(Card c) {
		// TODO Auto-generated method stub
		
	}
}