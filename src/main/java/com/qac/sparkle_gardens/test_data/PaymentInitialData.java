package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Payment;

@Deprecated
@Singleton
public class PaymentInitialData 
{
	private List<Payment> Payments = new ArrayList<Payment>();
	
	public PaymentInitialData()
	{
	}
	
	public void addPayment(Payment p)
	{
		this.Payments.add(p);
	}
	
	public List<Payment> getPayments()
	{
		return Payments;
	}
	
	public void setPayments(List<Payment> Payments)
	{
		this.Payments = Payments;
	}
}