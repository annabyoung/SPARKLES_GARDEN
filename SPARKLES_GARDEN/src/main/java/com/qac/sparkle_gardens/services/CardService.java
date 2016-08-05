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
	
	/**
	 * Check to make sure that the card details are valid.
	 * 
	 * @param customerName
	 * @param cardNumber
	 * @param expirationDate
	 * @return
	 */
	public boolean validateCardDetails(String customerName, String cardNumber, String expirationDate) {
		if (customerName.isEmpty() || cardNumber.isEmpty() || expirationDate.isEmpty() && cardNumber.matches("[0-9]{16}")) {
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
		Integer year = Integer.parseInt(expirationDate.substring(3));
		String currentDate = Calendar.getInstance().getTime().toString();
		Integer currentYear = Integer.parseInt(currentDate.substring(24));
		if (year < currentYear)
			return false;
		if (year == currentYear) {
			Integer month = Integer.parseInt(expirationDate.substring(0, 2));
			if (month > Calendar.getInstance().getTime().getMonth()+1)
				return true;
			return false;
		}
		return true;
	}
	
	/**
	 * Check to make sure that the card has not been registered by a blacklisted customer
	 * 
	 * @param cardNumber
	 * @param expiryDate
	 * @return
	 */
	public boolean checkNotBlacklisted(String cardNumber, String expiryDate) {
		ArrayList<Payment> payments = (ArrayList<Payment>) paymentRepository.findByCardNumber(cardNumber);
		for(Payment payment:payments) {
			if (payment.getExpiryDate().equals(expiryDate) && payment.getCustomer().getCreditStatus().equals(CreditStatus.BLACKLISTED))
				return false;
		}
		return true;
	}
}