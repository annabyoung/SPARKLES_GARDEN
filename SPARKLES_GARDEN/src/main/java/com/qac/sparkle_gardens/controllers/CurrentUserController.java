package com.qac.sparkle_gardens.controllers;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class CurrentUserController {
	private long customerId;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
}