package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
	private Logger log;
	@Inject
	InitialData initialData = new InitialData();

	public Card addCard(Card card) 
	{
		List<Card> cards = initialData.getCards();
		if (card.getCardID() == 0){
			long largestID = cards.get(cards.size() - 1).getCardID();
			card.setCardID(largestID + 1);
		}
		cards.add(card);
		initialData.setCards(cards);
		log.info(">>>>>> Adding card to repository" + card.getCardNumber());
		return card;
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