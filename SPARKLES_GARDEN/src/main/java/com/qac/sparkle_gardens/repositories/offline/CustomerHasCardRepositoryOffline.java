package com.qac.sparkle_gardens.repositories.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.repositories.CustomerHasCardRepository;

@Stateless
@Default
public class CustomerHasCardRepositoryOffline implements CustomerHasCardRepository {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomerHasCard(CustomerHasCard c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustomerHasCard(CustomerHasCard C) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCustomerHasCard(CustomerHasCard c) {
		// TODO Auto-generated method stub

	}


	public List<CustomerHasCard> findByCustomerID(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerHasCard> findByCardID(long cardID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerHasCard> findByAccountID(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
