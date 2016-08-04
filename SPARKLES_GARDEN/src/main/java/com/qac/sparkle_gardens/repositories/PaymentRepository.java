package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;

import com.qac.sparkle_gardens.entities.Payment;

public interface PaymentRepository {
	public void persistPayment(Payment p);

	public void persistPayments(ArrayList<Payment> p);

	public Payment findByID(String id);

	public ArrayList<Payment> getPayments();

	public void updatePayment(Payment p);

	public void removePayment(Payment p);
}