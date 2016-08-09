package com.qac.sparkle_gardens.services;

import javax.inject.Inject;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.util.PaymentStatus;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Payment;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.repositories.PaymentRepository;

/**
 * 
 * @author Allen Su.
 *
 */
public class PaymentService {
	@Inject PaymentRepository paymentRepository;
	@Inject CardRepository cardRepository;
	
	private String error;
	
	/**
	 * Checks whether or not the card is valid.
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
	/**
	 * 
	 * @return
	 */
	public String getError() {
		return error;
	}

	/**
	 * Make payment by card. if card not already in database, new card is added.
	 * @param Payment p
	 * @param cardOwnerName
	 * @param cardNumber
	 * @param expirationDate
	 * @param paymentAmount
	 * @return
	 */
	public String payByCard(Payment p, String cardOwnerName, String cardNumber, String expirationDate, double paymentAmount){
		
		//if(validateCardPayment())
		Card card = cardRepository.findByCardNumberAndExpiration(cardNumber, expirationDate);
		if (card == null){
			card = new Card(cardOwnerName, cardNumber, expirationDate, 000);//HAVENT FIGURED OUT FOREIGN KEYS YET
			cardRepository.addCard(card);
		}
		p.setCardID(card.getCardId());
		
		// if (SOMETHING SOMETHING PAYMENT failed){error = "failed payment"; return "#"}
		
		p.setPaymentStatus(PaymentStatus.PAID);
		
		error = "";
		return "#"; //placeholders
	}
	
	public String refundCard(Payment p){
		
		//SOMETHING SOMETHING PAYMENTS
		p.setPaymentStatus(PaymentStatus.VOID);
		error = "";
		return "#";
	}
}
