package com.qac.sparkle_gardens.util;
import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Card;

@Singleton
public class CardInitialData 
{
	private ArrayList<Card> Cards = new ArrayList<Card>();
	
	public CardInitialData()
	{
		Cards.add(new Card());
		Cards.add(new Card());
		Cards.add(new Card());
	}
	
	public void addCard(Card p)
	{
		this.Cards.add(p);
	}
	
	public ArrayList<Card> getCards()
	{
		return Cards;
	}
	
	public void setCards(ArrayList<Card> Cards)
	{
		this.Cards = Cards;
	}
}