package com.qac.sparkle_gardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Tyler Deans
 * 
 * I created the Address entity which contain attributes of an address 
 * 
 * 18/08/16 (08/18/16)
 * I had to make some changes so that it aligns with the front end
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
	
	//The number of the building
	@Column
	@NotNull
	private String buildingNum;
	
	/**
	 * In an address form a person can write their address in one or two lines which can
	 * contain the street address, the floor number, etc.
	 * 
	 * I added two more attributes addressLine1 and addressLine2 to account for this.
	 */
	@Column
	@NotNull
	@Size (min = 1, max = 200)
	private String addressLine1;
	
	@Column
	@Size (min = 1, max = 200)
	private String addressLine2;

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
	
	@Column
	@NotNull
	@Size (min = 1, max = 30)
	private String addressType;

	public Address() {
		this.buildingNum = "";
		this.addressLine1 = "";
		this.addressLine2 = "";
		this.city = "";
		this.county = "";
		this.country = "";
		this.postCode = "";
		this.addressType = "";
	}
	
	/**
	 * 
	 * @param buildingNum
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param county
	 * @param country
	 * @param postCode
	 */
	public Address(String buildingNum, String addressLine1, String addressLine2, String city, String county, String country, String postCode, String addressType) {
		this.buildingNum = buildingNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.county = county;
		this.country = country;
		this.postCode = postCode;
		this.addressType = addressType;
	}
	
	/**
	 * 
	 * @param buildingNum
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param country
	 * @param postCode
	 * @param addressType
	 */
	public Address(String buildingNum, String addressLine1, String addressLine2, String city, String country, String postCode, String addressType) {
		this.buildingNum = buildingNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.country = country;
		this.postCode = postCode;
		this.addressType = addressType;
	}
	
	
	/**
	 * 
	 * @param buildingNum
	 * @param addressLine1
	 * @param city
	 * @param country
	 * @param postCode
	 */
	public Address(String buildingNum, String addressLine1, String city, String country, String postCode, String addressType) {
		this.buildingNum = buildingNum;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.country = country;
		this.postCode = postCode;
		this.addressType = addressType;
	}

	// Getters and setters for all the attributes
	/**
	 * 
	 * @return long
	 */
	public long getAddressId() {
		return addressId;
	}
	
	/**
	 * 
	 * @param addressId
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getBuildingNum() {
		return buildingNum;
	}
	
	/**
	 * 
	 * @param buildingNum
	 */
	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}

	public String getCity() {
		return city;
	}
	
	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}
	
	/**
	 * 
	 * @param county
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}
	
	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	
	/**
	 * 
	 * @param addressLine1
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}
	
	/**
	 * 
	 * @param addressLine2
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public boolean equals(Address anotherAddress){
		return (this.addressId == anotherAddress.addressId);
	}
	
	public String getAddressType() {
		return addressType;
	}
	
	/**
	 * 
	 * @param addressType
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	@Deprecated
	public CustomerHasAddress getCustAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Deprecated
	public long getCustomerId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
