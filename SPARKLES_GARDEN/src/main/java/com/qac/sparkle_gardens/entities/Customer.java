package com.qac.sparkle_gardens.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.qac.sparkle_gardens.util.CreditStatus;

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
	// not sure what the foreign key looks like or if this is correct 
	@JoinColumn(name = "accountID_fk ", nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long accountID;
	
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
	private CreditStatus creditStatus;
	
	//TODO: Convert address into an Entity
	@Column (name="address")
	@Size (min =10, max =255)
	private String address;

	@Column (name="password")
	@Size (min =6, max =255)
	private String password;
	
	//constructors 
	public Customer() {
		//blank constructor 
	}
	
	public Customer(long accountID, String firstName, String lastName, String email, CreditStatus creditStatus,
			String address, String password) {
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creditStatus = creditStatus;
		this.address = address;
		this.password = password;
	}

	public Customer(String firstName, String lastName, String email, CreditStatus creditStatus, String address, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creditStatus = creditStatus;
		this.address = address;
		this.password = password;
	}


	//getters and setters 
	public long getAccountID() {
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


	public CreditStatus getCreditStatus() {
		return creditStatus;
	}


	public void setCreditStatus(CreditStatus creditStatus) {
		this.creditStatus = creditStatus;
	}


	public String getAddress() {
		return address;
	}

	public String getPassword() { return password; }
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPassword(String password) { this.password = password; }
	
	//named queries for each attribute 
	public static final String FIND_BY_FIRST_NAME = "Customer.getFirstName()";
	public static final String FIND_BY_LAST_NAME = "Customer.getLastName()";
	public static final String FIND_BY_EMAIL = "Customer.getEmail()";
	public static final String FIND_BY_CREDIT_STATUS = "Customer.getCreditStatus()";
	public static final String FIND_BY_ADDRESS = "Customer.getAddress()";
	
}
