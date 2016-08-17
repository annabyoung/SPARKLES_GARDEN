package com.qac.sparkle_gardens.repositories.online;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.repositories.CardRepository;

/*
@Stateless
public class CardRepositoryImpl implements CardRepository{

	//@PersistenceContext//(unitName="card-unit", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Override
	public void addCard(Card c) {
		entityManager.persist(c);
	}

	@Override
	public void removeCard(Card c) {
		entityManager.remove(c);
	}

//	@Override
//	public List<Card> findByCardNumber(String cardNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Card findByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card findByCardNumberAndExpiration(String cardNumber, String expirationDate) {
		// TODO Auto-generated method stub
		return (Card) entityManager.createQuery("Select 1 from Card c Where c.cardNumber equals "+ 
				cardNumber + " and c.expirationDate equals " + expirationDate).getResultList().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> getCardsByField(String orderField) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select c from Card c ORDER by c." + orderField).getResultList();
	}
}
*/