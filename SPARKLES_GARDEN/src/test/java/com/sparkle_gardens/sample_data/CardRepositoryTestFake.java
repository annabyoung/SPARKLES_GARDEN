package com.sparkle_gardens.sample_data;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.repositories.CardRepository;


@Alternative @Testpurposes
public class CardRepositoryTestFake implements CardRepository{

	private List<Card> cards;
	
	public CardRepositoryTestFake(){}
	
	@Override
	public Card addCard(Card c) {
		if (c.getCardID() == 0){
			
			if (cards.size() == 0){
				c.setCardID(1);
				return c;
			}
			c.setCardID(cards.get(cards.size() - 1).getCardID() + 1);
			cards.add(c);
			return c;
		}
		cards.add(c);
		return c;
	}

	@Override
	public void persistCards(List<Card> c) {
		for (Card card: c){
			cards.add(card);
		}
	}

	@Override
	public Card findByID(long id) {
		for (Card card: cards){
			if(card.getCardID() == id){
				return card;
			}
		}
		return null;
	}

	@Override
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public void removeCard(Card c) {
		cards.remove(c);
	}

	@Override
	public List<Card> findByCardNumber(String cardNumber) {
		
		List<Card> matchingCards = new ArrayList<Card>();
		for (Card card: cards){
			if(card.getCardNumber() == cardNumber){
				matchingCards.add(card);
			}
		}
		return matchingCards;
	}

	@Override
	public Card findByCardNumberAndExpiration(String cardNumber, String expirationDate) {
		for (Card card: cards){
			if(card.getCardNumber() == cardNumber && card.getExpirationDate() == expirationDate){
				return card;
			}
		}
		return null;
	}

}
