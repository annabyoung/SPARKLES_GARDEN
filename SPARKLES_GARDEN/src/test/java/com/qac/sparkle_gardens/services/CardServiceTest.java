package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.controllers.CurrentUserController;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.util.CreditStatus;

public class CardServiceTest {

	private CardService cardServ;
//	private CustomerService cusServ;
//	private CurrentUserController curUser;
	private Card card;
	private Customer customer;
	
	@Before
	public void setUp() throws Exception {
		card = new Card("Test", "4412345647894531", "10/10");
		cardServ = new CardService();
		//long accountID, String firstName, String lastName, String email, CreditStatus creditStatus,
		//String password, String phone
		customer = new Customer(5, "Bob", "Bobby", "hello@gmail.com", CreditStatus.VALID, "hunter123", "2122122122");
//		cusServ = new CustomerService();
//		curUser = new CurrentUserController();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSetupCard() {
		Card card2 = cardServ.setupCard("Test", "4412345647894531", "10/10");
		assertEquals(card.getCardNumber(), card2.getCardNumber());
		
	}
	
	@Test
	public void testSetupCardIncorrect(){
		Card card2 = cardServ.setupCard("Test", "4412345647894531", "10/10");
		Card card3 = new Card("Test", "4412345647894530", "10/10");
		assertNotEquals(card2.getCardNumber(),card3.getCardNumber());
	}
	
	@Test
	public void testRegisterCard() {
		int startNumber = cardServ.getCardsByCustomer(customer.getAccountID()).size();
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.getCardsByCustomer(customer.getAccountID()).size() > startNumber);
	}

	@Test
	public void testReturnIfExisting() {
		cardServ.registerCard(card, customer);
	}

	@Test
	public void testCheckIfCustomerRegisteredCardAlready() {
		fail("Not yet implemented");
	}


	@Test
	public void testValidateCardDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckInDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNotBlacklisted() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCardsByCustomerLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCardsByCustomerCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCardOfCustomerCardCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCardOfCustomerLongLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckIfAnyoneOwnsCardCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckIfAnyoneOwnsCardLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckIfCustomerOwnsCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testRefundCard() {
		fail("Not yet implemented");
	}

}
