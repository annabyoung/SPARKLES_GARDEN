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
		Cards.add(new Card(1, "Connect", "4412345647894531", "12/12", 1));
		Cards.add(new Card(2, "Head", "4212345647894531", "11/12", 2));
		Cards.add(new Card(3, "Hammer", "4552345647894531", "12/13", 3));
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