package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

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
	InitialData initialData;

	public void persistCard(Card c) 
	{
		initialData.addCard(c);
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
			if(id == c.getCardId())
			{
				return c;
			}
		}
		return null;
	}
	
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