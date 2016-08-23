package com.qac.sparkle_gardens.controllers;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.qac.sparkle_gardens.services.CustomerService;

/**
 * logging in. probably need to do more or borrow 
 * gotta rework this 
 * 
 * @author Sean Connelly 
 *
 * took from 
 * http://docs.oracle.com/javaee/6/tutorial/doc/glxce.html
 * need to create a session bean now?
 */

@RequestScoped
@Named (value ="login")
public class Login {

	@Inject 
	CustomerService customerService;
	@Inject
	CurrentUserController userCredentials;
	
	
	  private String username="";
	  private String password="";
      private String error = "";
      
	  public String getUsername() {
	    return this.username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getPassword() {
	    return this.password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	  public String login () {
		  if (username.equals("")){
			  error = "please enter a username";
			  password="";
			  return "login";
		  }
		  if (password.equals("")){
			  error = "please enter a password";
					  password="";
			  return "login";
		  }
		  
		  if(!customerService.validateDetails(username, password)){
			  error = "Invalid Login";
					  password= "";
			  return "login";
		  }
		  userCredentials.setCustomerId(customerService.getUserID(username).getAccountID());
		  return "home";	  
		  
		  
	  }

	  public String logout() {
	    userCredentials.setCustomerId(0);
	    return "home"; 
	  }
}
