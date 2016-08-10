package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Payment;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.repositories.PaymentRepository;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.qac.sparkle_gardens.util.PaymentStatus;

/**
 * 
 * @author Allen Su
 *
 */
@Named(value = "PayByCard")
@SessionScoped
public class PayByCard {
	@Inject PaymentRepository paymentRepository;
	@Inject CardRepository cardRepository;
	
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
			card = new Card(cardOwnerName, cardNumber, expirationDate, 
					new Customer(000, "Brazen", "Moo", "HappyCows@gmail.com", CreditStatus.VALID, new Address(), "0302", "1231233"));//HAVENT FIGURED OUT FOREIGN KEYS YET
			cardRepository.persistCard(card);
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
		if (cs.validateCardDetails(cardOwnerName, cardNumber, expirationDate)){
			error = "";
			return "#"; //placeholders.
		}
		error = cs.getError();
		return "#";
	}
	
	public String getError(){
		return error;
	}
}
