package com.qac.sparkle_gardens.entities;

public class Customer {
	
	private int accountID;
	private String firstName;
	private String lastName;
	private String email;
	private String creditStatus;
	private String address;
	
	
	public Customer(int accountID, String firstName, String lastName, String email, String creditStatus,
			String address) {
		super();
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creditStatus = creditStatus;
		this.address = address;
	}


	public Customer(String firstName, String lastName, String email, String creditStatus, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creditStatus = creditStatus;
		this.address = address;
	}


	public int getAccountID() {
		return accountID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCreditStatus() {
		return creditStatus;
	}


	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
}
