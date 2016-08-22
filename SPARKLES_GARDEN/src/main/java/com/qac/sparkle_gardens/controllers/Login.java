package com.qac.sparkle_gardens.controllers;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.qac.sparkle_gardens.services.CustomerService;

/**
 * logging in. probably need to do more or borrow 
 * a real library thats already done it.
 * 
 * @author Sean Connelly 
 *
 * took from 
 * http://docs.oracle.com/javaee/6/tutorial/doc/glxce.html
 * need to create a session bean now?
 */

	@Stateless
@Named (value ="Login")
public class Login {

	  private String username;
	  private String password;

	  public String getUsername() {
	    return this.username;
	  }

	  public void setUserName(String username) {
	    this.username = username;
	  }

	  public String getPassword() {
	    return this.password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	  public String login () {
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) 
	        context.getExternalContext().getRequest();
	    try {
	      request.login(this.username, this.password);
	    } catch (ServletException e) {
	      context.addMessage(null, new FacesMessage("Login failed."));
	      return "error";
	    }
	    return "admin/index";
	  }

	  public void logout() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) 
	        context.getExternalContext().getRequest();
	    try {
	      request.logout();
	    } catch (ServletException e) {
	      context.addMessage(null, new FacesMessage("Logout failed."));
	    }
	  }
	


}
