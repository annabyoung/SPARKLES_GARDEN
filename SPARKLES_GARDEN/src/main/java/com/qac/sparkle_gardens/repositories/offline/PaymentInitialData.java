package com.qac.sparkle_gardens.repositories.offline;
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
		Payments.add(new Payment("Bill", "5472123442349876", "05/16", new Customer()));
		Payments.add(new Payment("Steve", "5472123442349876", "0/16", new Customer()));
		Payments.add(new Payment("Bill", "547212344249876", "05/16", new Customer()));
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