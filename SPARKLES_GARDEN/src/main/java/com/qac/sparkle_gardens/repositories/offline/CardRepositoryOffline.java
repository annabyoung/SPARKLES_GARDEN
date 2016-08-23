package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.test_data.InitialData;


/**
 * 
 * @author Allen Su
 *
 */
@Stateless
@Default
public class CardRepositoryOffline implements CardRepository
{
	@Inject
	InitialData initialData = new InitialData();

	public void addCard(Card card) 
	{
		List<Card> cards = initialData.getCards();
		if (card.getCardID() == 0){
			card.setCardID(cards.get(cards.size() - 1).getCardID() + 1);
			/*
			 * If Card doesn't have an ID, set ID to the ID of the largest one in initialData
			 * +1. Doesn't work if there is one or less members in the initialData, but this is only
			 * for testing purposes anyway.
			 */
		}
		cards.add(card);
		initialData.setCards(cards);
	}
	
	public List<Card> listCards() 
	{
		return initialData.getCards(); 
	}
	
	public void persistCards(List<Card> c) 
	{
		initialData.setCards(c);
	}
	
	public Card findByID(long id) 
	{
		for (Card c : initialData.getCards())
		{
			if(id == c.getCardID())
			{
				return c;
			}
		}
		return null;
	}
	@Named("cards")
	public List<Card> getCards() 
	{
		return initialData.getCards();
	}


	public void removeCard(Card c) 
	{
		List<Card> cl = initialData.getCards();
		cl.remove(c);
	}
	
	public List<Card> findByCardNumber(String cardNumber) 
	{
		List<Card> cards = new ArrayList<Card>();
		for (Card c : initialData.getCards()){
			if(cardNumber == c.getCardNumber()){
				cards.add(c);
			}
		}
		return cards;
	}

	public Card findByCardNumberAndExpiration(String cardNumber, String expirationDate) 
	{
		for (Card c : initialData.getCards()){
			if(cardNumber == c.getCardNumber() && c.getExpirationDate() == expirationDate){
				return c;
			}
		}
		return null;
	}
}