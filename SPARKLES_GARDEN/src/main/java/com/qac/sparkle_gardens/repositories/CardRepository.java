package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qac.sparkle_gardens.entities.Card;

/**
 * 
 * @author Allen Su
 *
 */
public interface CardRepository 
{
	/**
	 * Keeps cards in database.
	 * @param Card c
	 */
	public void persistCard(Card c);

	/**
	 * Keeps ArrayList of cards.
	 * @param ArrayList<Card> c
	 */
	public void persistCards(ArrayList<Card> c);

	/**
	 * Finds a card using unique identifier
	 * @param id
	 * @return Card
	 */
	public Card findByID(long id);

	/**
	 * Gets all of the cards in the repository
	 * @return
	 */
	public ArrayList<Card> getCards();

	/**
	 * Removes a card.
	 * @param c
	 */
	public void removeCard(long id);

	/**
	 * Finds all cards using cardNumber.
	 * @param cardNumber
	 * @return List<Card>
	 */
	public List<Card> findByCardNumber(String cardNumber);
	
	/**
	 * Since cards are unique by expiration and cardNumber, this returns a single unique card based on those two parameters.
	 * @param cardNumber
	 * @param expirationDate
	 * @return Card
	 */
	public Card findByCardNumberAndExpiration(String cardNumber, String expirationDate);
	
}
