package com.qac.sparkle_gardens.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.qac.sparkle_gardens.util.CreditStatus;

/**
 * 
 * @author Sean Connelly 
 * 
 */
 @Entity
 @Table (name = "customers")
 @NamedQueries ({
	 @NamedQuery (name = Customer.FIND_BY_ID, 
		      query="SELECT a FROM Customer a WHERE a.accountID = :accountID"),
	 @NamedQuery (name = Customer.FIND_BY_FIRST_NAME, 
			      query="SELECT a FROM Customer a WHERE a.firstName = :firstName"),
	 @NamedQuery (name = Customer.FIND_BY_LAST_NAME, 
		      query="SELECT a FROM Customer a WHERE a.lastName = :lastName"),
//	 @NamedQuery (name = Customer.FIND_BY_EMAIL, 
//		      query="SELECT a FROM Customer a WHERE a.EMAIL = :email"),
	 @NamedQuery (name = Customer.FIND_BY_CREDIT_STATUS, 
		      query="SELECT a FROM Customer a WHERE a.creditStatus = :creditStatus"),
//	 @NamedQuery (name = Customer.FIND_BY_ADDRESS, 
//		      query="SELECT a FROM Customer a WHERE a.address = :Address"),
	 @NamedQuery (name = Customer.FIND_BY_PHONE, 
	          query="SELECT a FROM Customer a WHERE a.phone = :phone"),
 })
 // may need to make new address query?
public class Customer implements Serializable  {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -6237268271859215384L;

	@Id
	@Column (name ="accountID")
	//@OneToMany 
	//fix this comeback  later
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
	
	@Column (name="password")
	@Size (min =6, max =255)
	private String password;
	
	@Column(name="phone")
	@Size (min =10, max=12 )
	private String phone; 
	
	//constructors 
	public Customer() {
		//blank constructor 
	}
	
	public Customer(long accountID, String firstName, String lastName, String email, CreditStatus creditStatus,
			String password, String phone) {
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creditStatus = creditStatus;
		this.password = password;
		this.phone=phone;
	}

	public Customer(String firstName, String lastName, String email, CreditStatus creditStatus,
					String password, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creditStatus = creditStatus;
		this.password = password;
		this.phone= phone;
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
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public void setPhone(String phone) {this.phone=phone;}
	public String getPhone(){return this.phone;}
	
	//named queries for each attribute 
	
	public static final String FIND_BY_ID="Customer.getAccountID()";
	public static final String FIND_BY_FIRST_NAME = "Customer.getFirstName()";
	public static final String FIND_BY_LAST_NAME = "Customer.getLastName()";
	public static final String FIND_BY_EMAIL = "Customer.getEmail()";
	public static final String FIND_BY_CREDIT_STATUS = "Customer.getCreditStatus()";
	public static final String FIND_BY_ADDRESS = "Customer.getAddress()";
	public static final String FIND_BY_PHONE ="Customer.getPhone()";
	//TODO: address is an entity now. probably need to rework this 
}
