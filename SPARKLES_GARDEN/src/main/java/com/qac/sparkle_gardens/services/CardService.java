package com.qac.sparkle_gardens.services;

import java.util.ArrayList;
import java.util.Calendar;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Payment;
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
		if (cardYear < currentYear)
			return false;
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
		ArrayList<Payment> payments = (ArrayList<Payment>) paymentRepository.findByCardNumber(cardNumber);
		for(Payment payment:payments) {
			if (payment.getExpirationDate().equals(expirationDate) && payment.getCustomer().getCreditStatus().equals(CreditStatus.BLACKLISTED))
				return false;
		}
		return true;
	}
}