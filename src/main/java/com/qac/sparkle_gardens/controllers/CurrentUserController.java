package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class CurrentUserController {
	private long accountId = 3;
	
	
	public long getCustomerId() {
		return accountId;
	}

	public void setCustomerId(long accountId) {
		this.accountId = accountId;
	}
}