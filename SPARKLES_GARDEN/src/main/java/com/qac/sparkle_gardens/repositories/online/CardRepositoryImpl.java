package com.qac.sparkle_gardens.repositories.online;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.repositories.CardRepository;


@Stateless
public class CardRepositoryImpl implements CardRepository{
	@PersistenceContext(unitName = "management-unit", type = PersistenceContextType.EXTENDED)
	EntityManager entityManager;

	@Override
	public void persistCard(Card c) {
		entityManager.persist(c);
	}

	@Override
	public void persistCards(List<Card> c) {
		for (Card card: c){
			entityManager.persist(card);
		}
	}

	@Override
	public Card findByID(long id) {
		return entityManager.find(Card.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> getCards() {
		return entityManager.createQuery("Select c FROM Cards c").getResultList();
	}

	@Override
	public void removeCard(Card c) {
		entityManager.remove(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> findByCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select c from Cards c WHERE c.cardNumber LIKE :cardNumber")
				.setParameter("cardNumber", cardNumber)
				.getResultList();
	}

	@Override
	public Card findByCardNumberAndExpiration(String cardNumber, String expirationDate) {
		return (Card) entityManager.createQuery("Select c from Cards c WHERE c.cardNumber LIKE :cardNumber "
				+ "AND c.expirationDate LIKE :expirationDate")
				.setParameter("cardNumber", cardNumber)
				.setParameter("expirationDate", expirationDate)
				.getResultList().get(0);
	}
	
}
