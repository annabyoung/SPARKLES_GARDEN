package com.qac.sparkle_gardens.repositories.online;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.repositories.CardRepository;

@Alternative
public class CardRepositoryImpl implements CardRepository{

	private EntityManager em;
	@Override
	public void addCard(Card c) {
		em.persist(c);
	}

	@Override
	public void persistCards(List<Card> c) {
		for (Card card: c){
			em.persist(card);
		}
	}

	@Override
	public Card findByID(long id) {
		// TODO Auto-generated method stub
		return (Card) em.createQuery("1 from Cards c Where c.id equals " + id).getResultList().get(0);
	}

	@Override
	public List<Card> getCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCard(Card c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> findByCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card findByCardNumberAndExpiration(String cardNumber, String expirationDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
