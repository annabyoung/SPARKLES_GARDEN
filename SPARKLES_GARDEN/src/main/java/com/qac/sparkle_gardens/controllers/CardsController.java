package com.qac.sparkle_gardens.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.CustomerService;

@Path("cards")
@RequestScoped
public class CardsController {
	@Inject private CurrentUserController currentUserController;
	@Inject private CustomerService cusService;
	@Inject private CardService cardService;

	@Produces
	@Named
	private Card newCard;
	
	
	@POST
	@Consumes("text/plain")
	@Path("registerCard")
	public void register(@FormParam("cardOwnerName") String cardOwnerName, 
			@FormParam("cardNumber") String cardNumber, @FormParam("expirationDate") String expirationDate){
		
		Card newCard = cardService.setupCard(cardOwnerName, cardNumber, expirationDate);
		Customer currentCustomer = cusService.getCustomerByID(currentUserController.getCustomerId());
		cardService.registerCard(newCard, currentCustomer);
	}
	
	public List<Card> getCards() {
		return cardService.getCardsByCustomer(currentUserController.getCustomerId());
	}
}