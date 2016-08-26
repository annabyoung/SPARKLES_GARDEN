package com.qac.sparkle_gardens.repositories;

import java.util.List;

import com.qac.sparkle_gardens.entities.CustomerHasCard;

/**
 * 
 * @author Allen Su
 *
 */
public interface CustomerHasCardRepository {
	/**
	 * Keeps CustomerHasCards in database.
	 * @param CustomerHasCard c
	 */
	public void persistCustomerHasCard(CustomerHasCard c);

	/**
	 * Keeps ArrayList of CustomerHasCards.
	 * @param ArrayList<CustomerHasCard> c
	 */
	public void persistCustomerHasCards(List<CustomerHasCard> c);


	/**
	 * Gets all of the CustomerHasCards in the repository
	 * @return
	 */
	public List<CustomerHasCard> getCustomerHasCards();
	
	/**
	 * Adds a new CustomerHasCard into repository. Might be useless because persist CustomerHasCard.
	 * @param c
	 */
	public void addCustomerHasCard(CustomerHasCard c);

	/**
	 * Updates a CustomerHasCard.
	 * @param C
	 */
	public void updateCustomerHasCard(CustomerHasCard C);

	/**
	 * Removes a CustomerHasCard.
	 * @param c
	 */
	public void removeCustomerHasCard(CustomerHasCard c);

	/**
	 * Finds instances of Customer Owning Cards by Customers.
	 * @param customerID
	 * @return
	 */
	public List<CustomerHasCard> findByAccountID(long customerID);
	
	/**
	 * Finds instances of Customer Owning Cards by Card.
	 * @param cardID
	 * @return
	 */
	public List<CustomerHasCard> findByCardID(long cardID);
}
