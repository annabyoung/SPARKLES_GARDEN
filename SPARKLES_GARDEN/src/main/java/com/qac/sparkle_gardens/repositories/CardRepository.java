package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qac.sparkle_gardens.entities.Card;

public interface CardRepository {
	public void persistCard(Card c);

	public void persistCards(ArrayList<Card> c);

	public Card findByID(String id);

	public ArrayList<Card> getCards();
	
	public void addCard(Card c);

	public void updateCard(Card C);

	public void removeCard(Card c);

	public List<Card> findByCardNumber(String cardNumber);

}
