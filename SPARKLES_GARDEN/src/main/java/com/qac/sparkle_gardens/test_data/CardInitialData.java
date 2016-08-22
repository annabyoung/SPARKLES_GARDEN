package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Card;

/**
 * deprecated in favour of InitialData (9/8/16)
 */
@Singleton
public class CardInitialData 
{
	private List<Card> Cards = new ArrayList<Card>();
	
	public CardInitialData()
	{
		Cards.add(new Card(1, "Connect", "4412345647894531", "12/12"));
		Cards.add(new Card(2, "Head", "4212345647894531", "11/12"));
		Cards.add(new Card(3, "Hammer", "4552345647894531", "12/13"));
	}
	
	public void addCard(Card p)
	{
		this.Cards.add(p);
	}
	
	public List<Card> getCards()
	{
		return Cards;
	}
	
	public void setCards(List<Card> Cards)
	{
		this.Cards = Cards;
	}
}