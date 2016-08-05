package com.qac.sparkle_gardens.services;

import javax.inject.Inject;
import com.qac.sparkle_gardens.services.CardService;

import com.qac.sparkle_gardens.repositories.PaymentRepository;

public class PaymentService {
	@Inject PaymentRepository paymentRepository;
	
	public boolean validateCardPayment(String cardOwnerName, String cardNumber, String expirationDate){
		CardService cs = new CardService();
		return (cs.validateCardDetails(cardOwnerName, cardNumber, expirationDate) &&
				cs.checkInDate(expirationDate) &&
				cs.checkNotBlacklisted(cardNumber, expirationDate));
	}
}
