package com.qac.sparkle_gardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Tyler Deans
 * 
 * I created the Address entity which contain attributes of an address 
 */

@Entity
@Table(name = "Address")

public class Address {
	/**
	 * These are the attributes of an address object
	 */
	@Id 
	@Column (name = "addressID")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long addressId;
	
	@ManyToOne
	@JoinColumn(name="customerID", nullable = false)
	private long customerId;
	

	public long getCustomerId() {
		return customerId;
	}
	public void setCustomer(long customerId) {
		this.customerId = customerId;
	}

	//The number of the building
	@Column
	@NotNull
	private int buildingNum;
	
	@Column
	@NotNull
	@Size (min = 1, max = 200)
	private String streetName;
	
	@Column
	@NotNull
	@Size (min = 1, max = 200)
	private String city;
	
	@Column
	@NotNull
	@Size (min = 1, max = 200)
	private String county;
	
	@Column
	@NotNull
	@Size (min = 1, max = 100)
	private String country;
	
	@Column
	@NotNull
	@Size (min = 1, max = 20)
	private String postCode;
	
	public Address() {
		this.customerId = 0;
		this.buildingNum = 0;
		this.streetName = "";
		this.city = "";
		this.county = "";
		this.country = "";
		this.postCode = "";
	}
	public Address(long customerId, int buildingNum, String streetName, String city, String county, String country, String postCode) {
		this.customerId = customerId;
		this.buildingNum = buildingNum;
		this.streetName = streetName;
		this.city = city;
		this.county = county;
		this.country = country;
		this.postCode = postCode;
	}
	// Getters and setters for all the attributes
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public int getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(int buildingNum) {
		this.buildingNum = buildingNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
}