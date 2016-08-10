package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.Calendar;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.repositories.PaymentRepository;
import com.qac.sparkle_gardens.util.CreditStatus;

/**
 * This is the Card Service Bean I have made as an example
 * 
 * @author James Thompson
 */
@Stateless
public class CardService {
	@Inject PaymentRepository paymentRepository;
	@Inject CardRepository cardRepository;
	@Inject CustomerRepository customerRepository;
	
	private String error = "";
	
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
			return checkInDate(expirationDate);
		}
		error = "Check Card Details";
		return false;
	}
	
	public String getError() {
		return error;
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
			error = "Card has expired";
			return false;
		}
		if (cardYear == currentYear) {
			Integer cardMonth = Integer.parseInt(expirationDate.substring(0, 2));
			if (cardMonth > currentMonth){
				return true;
			}
			error = "Card has expired";
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
//		ArrayList<Card> cards = (ArrayList<Card>) cardRepository.findByCardNumber(cardNumber);
//		for(Card card:cards) {
//			if (card.getExpirationDate().equals(expirationDate)) {
//				Customer cust = customerRepository.findByID(card.getCustomerID());
//				if (cust.getCreditStatus().equals(CreditStatus.BLACKLISTED)){
//					error = "You are blacklisted";
//					return false;
//				}
//			}
//		}
		Card card = cardRepository.findByCardNumberAndExpiration(cardNumber, expirationDate);
		return true;
	}
	public boolean refundCard(String cardNumber, String expirationDate){
		return true;
	}
}