package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.repositories.CustomerHasCardRepository;
import com.qac.sparkle_gardens.test_data.InitialData;

@Stateless
@Default
public class CustomerHasCardRepositoryOffline implements CustomerHasCardRepository {
	@Inject private InitialData initialData;
	
	@Override
	public void persistCustomerHasCard(CustomerHasCard cusCard) {
		List<CustomerHasCard> cusCards = initialData.getCusHasCards();
		cusCards.add(cusCard);
		initialData.setCusHasCards(cusCards);
	}

	@Override
	public void persistCustomerHasCards(List<CustomerHasCard> c) {
		List<CustomerHasCard> cusCards = initialData.getCusHasCards();
		for (CustomerHasCard cusCard: c){
			cusCards.add(cusCard);
		}
		initialData.setCusHasCards(cusCards);
	}

	@Override
	public List<CustomerHasCard> getCustomerHasCards() {
		return initialData.getCusHasCards();
	}

	@Override
	public void addCustomerHasCard(CustomerHasCard cusCard) {
		List<CustomerHasCard> cusCards = initialData.getCusHasCards();
		cusCards.add(cusCard);
		initialData.setCusHasCards(cusCards);
	}

	@Override
	public void updateCustomerHasCard(CustomerHasCard cusCard) {
		//Why is this here???
	}

	@Override
	public void removeCustomerHasCard(CustomerHasCard c) {
		List<CustomerHasCard> cusCards = initialData.getCusHasCards();
		for (CustomerHasCard cusCard: cusCards){
			if (cusCard.equals(c)){
				cusCards.remove(cusCard);
			}
		}
		initialData.setCusHasCards(cusCards);
	}

	@Override
	public List<CustomerHasCard> findByCardID(long cardID) {
		List<CustomerHasCard> customerHasCards = new ArrayList<CustomerHasCard>();
		for(CustomerHasCard hasCard : initialData.getCusHasCards()) {
			if(hasCard.getCard().getCardID() == cardID)
				customerHasCards.add(hasCard);
		}
		return customerHasCards;
	}

	@Override
	public List<CustomerHasCard> findByAccountID(long accountID) {
		List<CustomerHasCard> customerHasCards = new ArrayList<CustomerHasCard>();
		//System.out.println(">>> Customer Cards " + customerHasCards.isEmpty() + " <<< ");
		for(CustomerHasCard hasCard : initialData.getCusHasCards()) {
			//System.out.println(">>> Card belongs to " + hasCard.getCustomer().getAccountID() + " <<< ");
			if(hasCard.getCustomer().getAccountID() == accountID)
				customerHasCards.add(hasCard);
		}
		//System.out.println(">>> Customer Cards " + customerHasCards.size() + " <<< ");
		return customerHasCards;
	}
}