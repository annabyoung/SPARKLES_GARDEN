package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;

import javax.inject.Inject;

import com.qac.sparkle_gardens.entities.Payment;
import com.qac.sparkle_gardens.repositories.PaymentRepository;
import com.qac.sparkle_gardens.util.PaymentInitialData;

public class PaymentRepositoryOffline implements PaymentRepository
{
	@Inject
	PaymentInitialData initialPaymentData;
	
	public void persistPayment(Payment p) {
		initialPaymentData.addPayment(p);
	}
	public ArrayList<Payment> listPayments() {
		return initialPaymentData.getPayments(); 
	}
	public void persistPayments(ArrayList<Payment> p) {
		// TODO Auto-generated method stub
		
	}
	public Payment findByID(String id) {
		// TODO Auto-generated method stub
		for (Payment p : initialPaymentData.getPayments()){
			if(id == p.getPid()){
				return p;
			}
		}
		return null;
	}
	public ArrayList<Payment> getPayments() {
		// TODO Auto-generated method stub
		return initialPaymentData.getPayments();
	}
	public void updatePayment(Payment p) {
		// TODO Auto-generated method stub
		
	}
	public void removePayment(Payment p) {
		// TODO Auto-generated method stub
		//initialPaymentData.getPayments()...
	}
}