package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.repositories.CustomerHasCardRepository;
import com.qac.sparkle_gardens.test_data.InitialData;

@Stateless
@Default
public class CustomerHasCardRepositoryOffline implements CustomerHasCardRepository {
	@Inject private InitialData initialData;
	
	@Override
	public void persistCustomerHasCard(CustomerHasCard c) {
		
		// TODO Auto-generated method stub

	}

	@Override
	public void persistCustomerHasCards(List<CustomerHasCard> c) {
		
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerHasCard> getCustomerHasCards() {
		
	
		return null;
	}

	@Override
	public void addCustomerHasCard(CustomerHasCard c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustomerHasCard(CustomerHasCard C) {
		// TODO Auto-generated method stub
		//initialData.getCusHasCards().
		

	}

	@Override
	public void removeCustomerHasCard(CustomerHasCard c) {
		// TODO Auto-generated method stub
			
		
	}

	@Override
	public List<CustomerHasCard> findByCardID(long cardID) {
		List<CustomerHasCard> customerHasCards = new ArrayList<CustomerHasCard>();
		
		
		
		return customerHasCards;
	}

	@Override
	public List<CustomerHasCard> findByAccountID(long accountID) {
		List<CustomerHasCard> customerHasCards = new ArrayList<CustomerHasCard>();
		System.out.println(">>> Customer Cards " + customerHasCards.isEmpty() + " <<< ");
		for(CustomerHasCard hasCard : initialData.getCusHasCards()) {
			System.out.println(">>> Card belongs to " + hasCard.getCustomer().getAccountID() + " <<< ");
			if(hasCard.getCustomer().getAccountID() == accountID)
				customerHasCards.add(hasCard);
		}
		System.out.println(">>> Customer Cards " + customerHasCards.size() + " <<< ");
		return customerHasCards;
	}
}