package com.qac.sparkle_gardens.rest;

import java.util.logging.Logger;

import javax.faces.bean.RequestScoped;
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


@Path("/cards")
@RequestScoped
public class CardRESTService {
	
    @Inject private Logger log;
    @Inject private CardService cardService;
    @Inject private CurrentUserController currentUserController;
    
 
    @GET
    @Path("/customerCards")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getCustomerCards(){
    	log.info("/cards/customerCards reached");
    	return cardService.getCardsByCustomer(currentUserController.getCustomerId());
    }
    
//    @POST
//    @Path("")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    
}
