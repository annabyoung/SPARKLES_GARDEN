package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.repositories.CardRepository;
import com.qac.sparkle_gardens.repositories.offline.CardRepositoryOffline;
import com.qac.sparkle_gardens.test_data.CardInitialData;
import com.qac.sparkle_gardens.test_data.InitialData;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.sparkle_gardens.sample_data.CardRepositoryTestFake;

import static org.mockito.Mockito.*;

import java.util.logging.Logger;

public class CardServiceTest {
	@Mock
	private Logger log;
	@Mock
	private CardInitialData initialData;
	//private InitialData initialData;
	@Mock
	private CardRepositoryOffline cardRepository;
	//private CardRepositoryTestFake cardRepository;// = new CardRepositoryOffline();
	@InjectMocks
	private CardService cardServ;

	private Card card;
	private Customer customer;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		card = new Card("Test", "4412345647894531", "10/10");
		cardServ = new CardService();
		//long accountID, String firstName, String lastName, String email, CreditStatus creditStatus,
		//String password, String phone`
		customer = new Customer(5, "Bob", "Bobby", "hello@gmail.com", CreditStatus.VALID, "hunter123", "2122122122");
//		cusServ = new CustomerService();
//		curUser = new CurrentUserController();
	}

	@After
	public void tearDown() throws Exception {
		cardServ = null;
		customer = null;
		card = null;
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
		int one = cardServ.getCardsByCustomer(customer.getAccountID()).size();
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.getCardsByCustomer(customer.getAccountID()).size() > one);
	}
	
	@Test
	public void testRegisterCardControl(){
		int one = cardServ.getCardsByCustomer(customer.getAccountID()).size();
		assertFalse(cardServ.getCardsByCustomer(customer.getAccountID()).size() > one);
	}

	@Test
	public void testReturnIfExisting() {
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.returnIfExisting(card) != null);
	}
//
//	@Test
//	public void testReturnIfExisting() {
//		cardServ.registerCard(card, customer);
//		assertTrue(cardServ.returnIfExisting(card) != null);
//	}
	
	@Test
	public void testCheckIfCustomerRegisteredCardAlready() {
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.checkIfCustomerOwnsCard(card, customer));
		
	}


	@Test
	public void testValidateCardDetails() {
	}

	@Test
	public void testCheckInDate() {
	}

	@Test
	public void testCheckNotBlacklisted() {
	}

	@Test
	public void testGetCardsByCustomerLong() {
	}

	@Test
	public void testGetCardsByCustomerCustomer() {
	}

	@Test
	public void testDeleteCardOfCustomerCardCustomer() {
	}

	@Test
	public void testDeleteCardOfCustomerLongLong() {
	}

	@Test
	public void testCheckIfAnyoneOwnsCardCard() {
	}

	@Test
	public void testCheckIfAnyoneOwnsCardLong() {
	}

	@Test
	public void testCheckIfCustomerOwnsCard() {
	}

	@Test
	public void testRefundCard() {
	}

}
