package com.qac.sparkle_gardens.controllers;

import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.*;
import com.qac.sparkle_gardens.repositories.*;
import com.qac.sparkle_gardens.services.*;

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

//validate emails
long userID = services.getUserIDAtLogin(email, password); 




}
