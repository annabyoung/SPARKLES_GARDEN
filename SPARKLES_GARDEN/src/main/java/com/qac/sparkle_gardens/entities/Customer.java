package com.qac.sparkle_gardens.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
/**
 * 
 * @author Sean Connelly 
 * 
 */
//**Seannelly**//

 @Entity
 @Table (name = "customers")

 @NamedQueries ({
	 @NamedQuery (name = Customer.FIND_BY_FIRST_NAME, 
			      query="SELECT a FROM Customer a WHERE a.firstName = :firstName"),
	 @NamedQuery (name = Customer.FIND_BY_LAST_NAME, 
		      query="SELECT a FROM Customer a WHERE a.lastName = :lastName"),
	 @NamedQuery (name = Customer.FIND_BY_EMAIL, 
		      query="SELECT a FROM Customer a WHERE a.EMAIL = :email"),
	 @NamedQuery (name = Customer.FIND_BY_CREDIT_STATUS, 
		      query="SELECT a FROM Customer a WHERE a.creditStatus = :creditStatus"),
	 @NamedQuery (name = Customer.FIND_BY_ADDRESS, 
		      query="SELECT a FROM Customer a WHERE a.address = :Address")
 })
 
 
public class Customer {
	 
	@Id
	@Column (name ="accountID")
	@OneToMany 
	// not sure what the foreign key looks like 
	@JoinColumn(name = "PUT SOMETHING HERE ", nullable = false)
	//this may or may not be a thing in this thing 
	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String accountID;
	
	@Column (name="first name")
	@NotNull
	@Size (min =3, max =255)
	private String firstName;

	@Column (name="last name")
	@NotNull 
	@Size (min =3, max =255)
	private String lastName;
	
	@Column (name="email")
	@Size (min =3, max =255)
	private String email;  
	
	@Column (name="credit status")
	@Size (min =3, max =255)
	private String creditStatus;
	
	@Column (name="address")
	@Size (min =10, max =255)
	private String address;
	
	
	public Customer(String accountID, String firstName, String lastName, String email, String creditStatus,
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


	public String getAccountID() {
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
	
	
	public static final String FIND_BY_FIRST_NAME = "Customer.getFirstName()";
	public static final String FIND_BY_LAST_NAME = "Customer.getLastName()";
	public static final String FIND_BY_EMAIL = "Customer.getEmail()";
	public static final String FIND_BY_CREDIT_STATUS = "Customer.getCreditStatus()";
	public static final String FIND_BY_ADDRESS = "Customer.getAddress()";
	
}
