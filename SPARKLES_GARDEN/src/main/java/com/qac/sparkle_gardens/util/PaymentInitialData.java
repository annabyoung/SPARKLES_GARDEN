package com.qac.sparkle_gardens.util;
import java.util.ArrayList;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Payment;

/**
 * deprecated in favour of InitialData (9/8/16)
 */
@Singleton
@Deprecated
public class PaymentInitialData 
{
	private ArrayList<Payment> Payments = new ArrayList<Payment>();
	
	public PaymentInitialData()
	{
		//long paymentID, long customerID, long cardID, long paidAmount, PaymentStatus paymentStatus
		Payments.add(new Payment(1, 1, 1, PaymentStatus.PENDING));
		Payments.add(new Payment(2, 2, 2, PaymentStatus.PENDING));
		Payments.add(new Payment(3, 3, 3, PaymentStatus.PENDING));
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