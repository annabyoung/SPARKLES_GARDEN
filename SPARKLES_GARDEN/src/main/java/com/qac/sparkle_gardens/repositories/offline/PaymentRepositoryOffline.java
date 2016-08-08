package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Payment;
import com.qac.sparkle_gardens.repositories.PaymentRepository;
import com.qac.sparkle_gardens.util.CardInitialData;
import com.qac.sparkle_gardens.util.PaymentInitialData;

public class PaymentRepositoryOffline implements PaymentRepository
{
	@Inject
	PaymentInitialData initialPaymentData;
	@Inject
	CardInitialData initialCardData;
	
	public void persistPayment(Payment p) {
		initialPaymentData.addPayment(p);
	}
	public ArrayList<Payment> listPayments() {
		return initialPaymentData.getPayments(); 
	}
	public void persistPayments(ArrayList<Payment> p) {
		
	}
	public Payment findByID(long id) {
		for (Payment p : initialPaymentData.getPayments()){
			if(id == p.getPaymentID()){
				return p;
			}
		}
		return null;
	}
	public ArrayList<Payment> getPayments() {
		return initialPaymentData.getPayments();
	}
	public void updatePayment(Payment p) {
		
	}
	public void removePayment(Payment p) {
		//initialPaymentData.getPayments()...
	}
	@Override
	public List<Payment> findByCardNumber(String cardNumber) {
//		Cards = initialCardData.getCards();
//		
//		ArrayList<Payment> paymentsByCardNumber = new ArrayList<>();
//		for (Payment p : initialPaymentData.getPayments()){
//			if(cardNumber == p.getCardNumber()){
//				paymentsByCardNumber.add(p);
//			}
//		}
//		return paymentsByCardNumber;
		return null;
	}

}