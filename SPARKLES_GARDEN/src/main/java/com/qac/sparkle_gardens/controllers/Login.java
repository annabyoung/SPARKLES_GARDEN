package com.qac.sparkle_gardens.controllers;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.qac.sparkle_gardens.services.CustomerService;

/**
 * logging in.
 * 
 * 
 * took from James' slides.
 * 
 * @author Sean Connelly 
 *
 */

@RequestScoped
// @Named (value ="login")
//going path now


@Path("/")

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

	  @Path("login")
	  @POST
	  @Consumes
	  public String login (@FormParam("username") String user, @FormParam("password") String password) {
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
