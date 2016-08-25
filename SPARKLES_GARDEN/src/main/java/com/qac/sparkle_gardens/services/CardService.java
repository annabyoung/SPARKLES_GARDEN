package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless; 
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.repositories.CustomerHasCardRepository;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.repositories.offline.CardRepositoryOffline;
import com.qac.sparkle_gardens.repositories.offline.CustomerHasCardRepositoryOffline;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.sparkle_gardens.sample_data.Testpurposes;

/**
 * This is the Card Service Bean I have made as an example
 * 
 * @author Allen Su
 */
@Stateless
public class CardService {
	@Inject private CardRepository cardRepository = new CardRepositoryOffline();
	@Inject private CustomerHasCardRepository cardOwnershipRepository = new CustomerHasCardRepositoryOffline();
	@Inject private Logger log;
	
	/**
	 * TODO:PLACEHOLDER.
	 */
	public CardService(){
		
	}
	
	/**
	 * Registers a Card, and then adds a customerHasCard.
	 * @param newCard
	 * @param cardOwner
	 */
	public void registerCard(Card newCard, Customer cardOwner){
		cardChecker(newCard);
		Card card = returnIfExisting(newCard);
		if (card == null){
			card = cardRepository.addCard(newCard);
			CustomerHasCard cusCard = new CustomerHasCard(cardOwner, card);
			cardOwnershipRepository.addCustomerHasCard(cusCard);
			//log.info("Registering new card to customer.");
		}
		else{
			if (!checkIfCustomerRegisteredCardAlready(newCard, cardOwner)){
				CustomerHasCard cusCard = new CustomerHasCard(cardOwner, card);
				cardOwnershipRepository.addCustomerHasCard(cusCard);
				//log.info("Linking Customer to previously registered Card.");
			}
			else{
				//log.info("Customer has already registered Card.");
			}
		}
	}
	
	public void cardChecker(Card card){
		if (!validateCardDetails(card.getCardOwnerName(), card.getCardNumber(), card.getExpirationDate()))
			throw new IllegalArgumentException("Invalid inputs");
		if (!checkInDate(card.getExpirationDate())){
			throw new IllegalArgumentException("Card expiration past");}
		if (!checkNotBlacklisted(card.getCardNumber(), card.getExpirationDate())){
			throw new IllegalArgumentException("Card Black Listed");}
	}
	
	/**
	 * Returns an existing card if every parameter is found on repository.
	 * @param card
	 * @return
	 */
	public Card returnIfExisting(Card card){
		cardChecker(card);
		List<Card> cards = cardRepository.getCards();
		for (Card existingCard: cards){
			if (card.getCardNumber() == existingCard.getCardNumber() && 
					card.getExpirationDate() == existingCard.getExpirationDate()){
				return existingCard;
			}
		}
		return null;
	}
	
	public boolean checkIfCustomerRegisteredCardAlready(Card card, Customer cardOwner){
		cardChecker(card);
		List<Card> cusCards = getCardsByCustomer(cardOwner.getAccountID());
		for (Card cusCard: cusCards){
			if (cusCard.getCardNumber() == card.getCardNumber() && cusCard.getExpirationDate() == card.getExpirationDate())
				return true;
		}
		return false;
	}
	
	public Card setupCard(String cardOwnerName, String cardNumber, String expirationDate){
		return new Card(cardOwnerName, cardNumber, expirationDate);
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
		if (cardOwnerName.isEmpty() || cardNumber.isEmpty() || expirationDate.isEmpty() || 
				!cardNumber.matches("[0-9]{16}") || !expirationDate.matches("[0-2][0-9]/[0-9][0-9]")) {
			return false;
		}
		return true;
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
		int currentYear = calendar.get(Calendar.YEAR) % 100;
		
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
		//System.out.println(">>> Customer ID: " + customer + " <<<");
		if (customer == 0)
			throw new IllegalArgumentException("CustomerID is missing");
		return filterCards(cardOwnershipRepository.findByAccountID(customer));
	}
	
	/**
	 * Returns an ArrayList of <Card>'s based on customer.
	 * @param customer
	 * @return List<Card>
	 */
	
	private List<Card> filterCards(List<CustomerHasCard> cardsOwnedByCustomer) {
		List<Card> cards = new ArrayList<>();
		//System.out.println(">>> cursomers Cards: " + cardsOwnedByCustomer.isEmpty() + " <<<");
		for(CustomerHasCard customerHasCard : cardsOwnedByCustomer) {
			cards.add(cardRepository.findByID(customerHasCard.getCard().getCardID()));
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
	public boolean deleteCardOfCustomer(long cardID, long accountID){
		//DeleteFlag is here so I don't get concurrent modification.
		if (cardID == 0){
			throw new IllegalArgumentException("Missing CardID");
		}
		if (accountID == 0){
			throw new IllegalArgumentException("Missing AccountID");
		}
		CustomerHasCard deleteFlag = new CustomerHasCard();
		for (CustomerHasCard co: cardOwnershipRepository.getCustomerHasCards()){
			if (co.getCustomer().getAccountID() == accountID && co.getCard().getCardID() == cardID){
				deleteFlag = co;
			}
		}
		if (deleteFlag.getCard() == null){
			return false;}
		cardOwnershipRepository.removeCustomerHasCard(deleteFlag);
		if (!checkIfAnyoneOwnsCard(cardID)){
			cardRepository.removeCard(deleteFlag.getCard());
		}
		return true;
	}
	
	
	/**
	 * Returns true if anyone owns the card. Mostly used after deleteCardOfCustomer
	 * to see if it is safe to delete a Card nobody uses anymore.
	 * @param card
	 * @return
	 */
	public boolean checkIfAnyoneOwnsCard(long cardId){
		for (CustomerHasCard co: cardOwnershipRepository.getCustomerHasCards()){
			if (co.getCard().getCardID() == cardId){
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