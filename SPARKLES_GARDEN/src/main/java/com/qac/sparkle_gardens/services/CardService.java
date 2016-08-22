package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless; 
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.repositories.CustomerHasCardRepository;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.util.CreditStatus;

/**
 * This is the Card Service Bean I have made as an example
 * 
 * @author Allen Su
 */
@Stateless
public class CardService {
	@Inject CardRepository cardRepository;
	@Inject CustomerRepository customerRepository;
	@Inject CustomerHasCardRepository cardOwnershipRepository;
	
	/**
	 * TODO:PLACEHOLDER.
	 */
	public CardService(){
		
	}
	
	/**
	 * Check to make sure that the card details are valid.
	 * 
	 * @param cardOwnerName
	 * @param cardNumber
	 * @param expirationDate
	 * @return
	 */
	public boolean validateCardDetails(String cardOwnerName, String cardNumber, String expirationDate) {
		if (!cardOwnerName.isEmpty() || !cardNumber.isEmpty() || !expirationDate.isEmpty() && cardNumber.matches("[0-9]{16}")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check to make sure the card is in date
	 * 
	 * @param expirationDate
	 * @return
	 */
	public boolean checkInDate(String expirationDate) {

		java.util.Date currentDate = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		int currentMonth = 1 + calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);
		
		Integer cardYear = Integer.parseInt(expirationDate.substring(3));
		if (cardYear < currentYear){
			return false;
		}
		if (cardYear == currentYear) {
			Integer cardMonth = Integer.parseInt(expirationDate.substring(0, 2));
			if (cardMonth > currentMonth){
				return true;
			}
			return false;
		}
		return true;
	}
	
	/**
	 * Check to make sure that the card has not been registered by a blacklisted customer
	 * 
	 * @param cardNumber
	 * @param expirationDate
	 * @return
	 */
	public boolean checkNotBlacklisted(String cardNumber, String expirationDate) {

		Card card = cardRepository.findByCardNumberAndExpiration(cardNumber, expirationDate);
		for (CustomerHasCard co: cardOwnershipRepository.getCustomerHasCards()){
			if (co.getCard().equals(card) && co.getCustomer().getCreditStatus() == CreditStatus.BLACKLISTED){
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns an ArrayList of <Card>'s based on customerId.
	 * @param customerId
	 * @return List<Card>
	 */
	public List<Card> getCardsByCustomer(long customer){
		System.out.println(">>> Customer ID: " + customer + " <<<");
		if (customer == 0)
			return new ArrayList<Card>();
		return filterCards(cardOwnershipRepository.findByAccountID(customer));
	}
	
	/**
	 * Returns an ArrayList of <Card>'s based on customer.
	 * @param customer
	 * @return List<Card>
	 */
	@Deprecated
	public List<Card> getCardsByCustomer(Customer customer){
		if (customer.equals(null))
			return new ArrayList<Card>();
		return filterCards(cardOwnershipRepository.findByAccountID(customer.getAccountID()));
	}
	
	private List<Card> filterCards(List<CustomerHasCard> cardsOwnedByCustomer) {
		List<Card> cards = new ArrayList<>();
		System.out.println(">>> cursomers Cards: " + cardsOwnedByCustomer.isEmpty() + " <<<");
		for(CustomerHasCard customerHasCard : cardsOwnedByCustomer) {
			cards.add(cardRepository.findByID(customerHasCard.getCard().getCardId()));
		}
		return cards;
	}
	
	/**
	 * Deletes the card of a customer. Requires both a card and a customer.
	 * Checks if there are any other people who own this card. If not, then the card
	 * is deleted.
	 * 
	 * Method returns false if there was no card owned by such customer in the first place.
	 * @param card
	 * @param customer
	 * @return
	 */
	public boolean deleteCardOfCustomer(Card card, Customer customer){
		for (CustomerHasCard co: cardOwnershipRepository.getCustomerHasCards()){
			if (co.getCustomer().equals(customer) && co.getCard().equals(card)){
				cardOwnershipRepository.removeCustomerHasCard(co);
				if (!checkIfAnyoneOwnsCard(card)){
//					cardRepository.removeCard(card.getCardId());
				}
			}
		}
		return false;
	}
	
	/**
	 * Deletes the card of a customer. Requires both a card and a customer.
	 * Checks if there are any other people who own this card. If not, then the card
	 * is deleted.
	 * 
	 * Method returns false if there was no card owned by such customer in the first place.
	 * @param card
	 * @param customer
	 * @return
	 */
	public boolean deleteCardOfCustomer(long cardId, long accountId){
		for (CustomerHasCard co: cardOwnershipRepository.getCustomerHasCards()){
			if (co.getCustomer().getAccountID() == accountId && co.getCard().getCardId() == cardId){
				cardOwnershipRepository.removeCustomerHasCard(co);
				if (!checkIfAnyoneOwnsCard(cardId)){
//					cardRepository.removeCard(cardId);
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns true if anyone owns the card. Mostly used after deleteCardOfCustomer
	 * to see if it is safe to delete a Card nobody uses anymore.
	 * @param card
	 * @return
	 */
	public boolean checkIfAnyoneOwnsCard(Card card){
		for (CustomerHasCard co: cardOwnershipRepository.getCustomerHasCards()){
			if (co.getCard().equals(card)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns true if anyone owns the card. Mostly used after deleteCardOfCustomer
	 * to see if it is safe to delete a Card nobody uses anymore.
	 * @param card
	 * @return
	 */
	public boolean checkIfAnyoneOwnsCard(long cardId){
		for (CustomerHasCard co: cardOwnershipRepository.getCustomerHasCards()){
			if (co.getCard().getCardId() == cardId){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Checks if a Customer Owns a Card given both objects.
	 * @param card
	 * @param customer
	 * @return
	 */
	public boolean checkIfCustomerOwnsCard(Card card, Customer customer){
		for (CustomerHasCard co: cardOwnershipRepository.getCustomerHasCards()){
			if (co.getCustomer().equals(customer) && co.getCard().equals(card)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Refunds Card based on cardnumber and expiration.
	 * @param cardNumber
	 * @param expirationDate
	 * @return
	 */
	public boolean refundCard(String cardNumber, String expirationDate){
		return true;
	}
}