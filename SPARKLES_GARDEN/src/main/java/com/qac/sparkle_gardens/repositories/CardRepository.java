package com.qac.sparkle_gardens.repositories;

import java.util.List;

import javax.ejb.Stateless;

import com.qac.sparkle_gardens.entities.Card;

/**
 * 
 * @author Allen Su
 *
 */
@Stateless
public interface CardRepository 
{
	/**
	 * Keeps cards in database.
	 * @param Card c
	 */
	public void addCard(Card c);

	/**
	 * Removes a card.
	 * @param c
	 */
	public void removeCard(Card c);

//	/**
//	 * Finds all cards using cardNumber.
//	 * @param cardNumber
//	 * @return List<Card>
//	 */
//	public List<Card> findByCardNumber(String cardNumber);
	
	/**
	 * Finds a card using unique identifier
	 * @param id
	 * @return Card
	 */
	public Card findByID(long id);

	/**
	 * Since cards are unique by expiration and cardNumber, this returns a single unique card based on those two parameters.
	 * @param cardNumber
	 * @param expirationDate
	 * @return Card
	 */
	public Card findByCardNumberAndExpiration(String cardNumber, String expirationDate);
	
	/**
	 * Gets all of the cards in the repository
	 * @return
	 */
	public List<Card> getCardsByField(String orderField);

}
