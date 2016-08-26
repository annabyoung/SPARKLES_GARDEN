package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.repositories.CardRepository;
//import com.qac.sparkle_gardens.repositories.PaymentRepository;
import com.qac.sparkle_gardens.services.CardService;

/**
 * 
 * @author Allen Su
 *
 */
@Named(value = "PayByCard")
@RequestScoped
public class PayByCard {
	@Inject private CardRepository cardRepository;
	
	private String error = "";
	
	/**
	 * Make payment by card. if card not already in database, new card is added.
	 * If all goes well, payment status is set to PAID
	 * 
	 * @param Payment p
	 * @param cardOwnerName
	 * @param cardNumber
	 * @param expirationDate
	 * @param paymentAmount
	 * @return
	 */
	public String payByCard(String cardOwnerName, String cardNumber, String expirationDate, double paymentAmount, String CVS){
		
		//if(validateCardPayment())
		Card card = cardRepository.findByCardNumberAndExpiration(cardNumber, expirationDate);
		if (card == null){
			card = new Card(cardOwnerName, cardNumber, expirationDate);
			cardRepository.addCard(card);
		}
		//STUFF TO BE DONE BECAUSE NO PAYMENT CLASS.
		error = "";
		return "#"; //placeholders
	}

	
	/**
	 * Checks whether or not the card is valid. Returns errors if card format,
	 * card number, expiration date, or cardOwnerName are invalid entiries.
	 * 
	 * @param cardOwnerName
	 * @param cardNumber
	 * @param expirationDate
	 * @return 
	 */
	public String validateCardPayment(String cardOwnerName, String cardNumber, String expirationDate){
		CardService cs = new CardService();
		if (!cs.validateCardDetails(cardOwnerName, cardNumber, expirationDate)){
			error = "Check Card Details";
			return "#"; //placeholders.
		}
		if (!cs.checkInDate(expirationDate)){
			error = "Card has Expired";
			return "#";
		}
		if (!cs.checkNotBlacklisted(cardNumber, expirationDate)){
			error = "You are blacklisted";
			return "#";
		}
		error = "";
		return "#";
	}
	
	public String getError(){
		return error;
	}
}
