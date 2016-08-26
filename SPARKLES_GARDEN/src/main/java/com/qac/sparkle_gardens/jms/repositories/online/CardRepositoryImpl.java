package com.qac.sparkle_gardens.repositories.online;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.persistence.PersistanceManager;
import com.qac.sparkle_gardens.repositories.CardRepository;

@Alternative
public class CardRepositoryImpl implements CardRepository{

	@Inject private PersistanceManager pm;
	
	@Override
	public Card addCard(Card c) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return c;
	}

	@Override
	public void persistCards(List<Card> c) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for (Card card: c){
			em.persist(card);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public Card findByID(long id) {
		EntityManager em = pm.CreateEntityManager();
		Card result =  (Card) em.createQuery("1 from Cards c Where c.id equals " + id).getResultList().get(0);
		pm.CloseEntityManager(em);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> getCards() {
		EntityManager em = pm.CreateEntityManager();
		List<Card> result = em.createQuery("Select c from Cards c").getResultList();
		pm.CloseEntityManager(em);
		return result;
	}

	@Override
	public void removeCard(Card c) {
		long id = c.getCardID();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.createQuery("DELETE from Cards c Where c.id equals" + id);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
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
