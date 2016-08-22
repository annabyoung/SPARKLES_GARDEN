package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import com.qac.sparkle_gardens.services.CustomerService;

/**
 * logging in. probably need to do more or borrow 
 * a real library thats already done it.
 * 
 * @author Sean Connelly 
 *
 */

@RequestScoped

@Named (value ="login")
public class Login {

	CustomerService services;  

	String email="";
	String password="";
	//validate emails
	long userID = services.getUserIDAtLogin(email, password); 
	
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return password;
	}
}
