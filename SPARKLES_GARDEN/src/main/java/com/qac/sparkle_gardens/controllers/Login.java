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

@Named (value ="Login")
public class Login {

	CustomerService services;  

	String email="";
	String password="";
	String didItWork="Did not work";
	//validate emails
	long userID = services.getUserIDAtLogin(email, password); 
	public void beanCheck(String e, String p){
		System.out.println("Email is: " + e);
		System.out.println("Password is: " + p);
		didItWork="It Worked!";
	}


}
