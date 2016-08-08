package com.qac.sparkle_gardens.util;
import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Payment;

@Singleton
public class PaymentInitialData 
{
	private ArrayList<Payment> Payments = new ArrayList<Payment>();
	
	public PaymentInitialData()
	{
		Payments.add(new Payment());
		Payments.add(new Payment());
		Payments.add(new Payment());
	}
	
	public void addPayment(Payment p)
	{
		this.Payments.add(p);
	}
	
	public ArrayList<Payment> getPayments()
	{
		return Payments;
	}
	
	public void setPayments(ArrayList<Payment> Payments)
	{
		this.Payments = Payments;
	}
}