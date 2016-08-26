package com.qac.sparkle_gardens.rest;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.qac.sparkle_gardens.controllers.CurrentUserController;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.services.CardService;
import com.qac.sparkle_gardens.services.CustomerService;
import javax.enterprise.context.RequestScoped;

@Path("/cardrest")
@RequestScoped
public class CardRESTController {
	
    @Inject private Logger log;
    @Inject private CardService cardService;
    @Inject private CustomerService customerService;
    @Inject private CurrentUserController currentUserController;
    
 
    @GET
    @Path("/customerCards")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getCustomerCards(){
    	log.info("/cards/customerCards reached");
    	return cardService.getCardsByCustomer(currentUserController.getCustomerId());
    }
    
    @POST
    @Path("/registerCard")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createNewCard(@FormParam("cardOwnerName") String cardOwnerName, 
    		@FormParam("cardNumber") String cardNumber, @FormParam("expirationDate") String expirationDate){
    	log.info("creating new card");
    	Card newCard = cardService.setupCard(cardOwnerName, cardNumber, expirationDate);
    	cardService.registerCard(newCard, customerService.getCustomerByID(currentUserController.getCustomerId()));
    	return "registerPayment.xhtml";
    }
}
