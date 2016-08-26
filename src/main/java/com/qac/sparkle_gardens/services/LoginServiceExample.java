package com.qac.sparkle_gardens.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Deprecated
@Path("/")
public class LoginServiceExample {
	@Path("logintest")
	@POST
	public String logintest(@FormParam("email") String e, @FormParam("password") String p) {
		System.out.println("Passed through " + e + " and " + p);
		return "Logged in with " + e + " " + p;
	}
}