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
	private Customer customer2;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		card = new Card("Test", "4412315647894531", "10/20");
		cardServ = new CardService();
		//long accountID, String firstName, String lastName, String email, CreditStatus creditStatus,
		//String password, String phone`
		customer = new Customer(5, "Bob", "Bobby", "hello@gmail.com", CreditStatus.VALID, "hunter123", "2122122122");
		customer2 = new Customer(6, "Banned", "Bobby", "Lacks@email", CreditStatus.BLACKLISTED, "hunter123", "212212212");
//		cusServ = new CustomerService();
//		curUser = new CurrentUserController();
	}

	@After
	public void tearDown() throws Exception {
		cardServ = null;
		customer = null;
		customer2 = null;
		card = null;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCardCheckNoParam(){
		Card failure = new Card("", "", "");
		cardServ.cardChecker(failure);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCardCheckCardExpired(){
		Card failure = new Card("Bob", "1234123412341234", "01/01");
		cardServ.cardChecker(failure);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCardCheckCardNumberFailure(){
		Card failure = new Card("Bob", "123412341a341234", "01/30");
		cardServ.cardChecker(failure);
	}
	
	@Test
	public void testSetupCard() {
		Card card2 = cardServ.setupCard("Test", "4412315647894531", "10/10");
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

	@Test
	public void testReturnIfExistingFalse() {
		//cardServ.registerCard(card, customer);
		assertFalse(cardServ.returnIfExisting(card) != null);
	}
	
	@Test
	public void testCheckIfCustomerRegisteredCardAlready() {
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.checkIfCustomerOwnsCard(card, customer));
	}


	@Test
	public void testValidateCardDetailsValid() {
		assertTrue(cardServ.validateCardDetails(card.getCardOwnerName(), card.getCardNumber(), card.getExpirationDate()));
	}

	@Test
	public void testValidateCardDetailsInvalidMissing(){
		assertFalse(cardServ.validateCardDetails("Bob", "", "10/12"));
		assertFalse(cardServ.validateCardDetails("", "1231231231231234444", "10/12"));
		assertFalse(cardServ.validateCardDetails("Bob", "1234123412341234", ""));
	}
	
	@Test
	public void testValidateCardDetailsInvalidInputs(){
		assertFalse(cardServ.validateCardDetails("Bob", "123123", "10/12"));
		assertFalse(cardServ.validateCardDetails("Bob", "1234123412341234", "10"));
	}
	
	@Test
	public void testCheckInDateTrue() {
		assertTrue(cardServ.checkInDate("10/20"));
	}
	
	@Test
	public void testCheckInDateOutOfDateFalse() {
		assertFalse(cardServ.checkInDate("10/02"));
	}

	@Test
	public void testCheckNotBlacklistedFine() {
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.checkNotBlacklisted(card.getCardNumber(), card.getExpirationDate()));
	}
	
	@Test
	public void testCheckNotBlacklistedActuallyBlacklisted(){
		cardServ.registerCard(card, customer2);
		assertFalse(cardServ.checkNotBlacklisted(card.getCardNumber(), card.getExpirationDate()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetCardsByCustomerLongSameCustomerNoID(){
		cardServ.getCardsByCustomer(0);
	}
	
	@Test
	public void testGetCardsByCustomerLongSameCustomer(){
		cardServ.registerCard(card,customer);
		boolean test = false;
		for (Card c: cardServ.getCardsByCustomer(customer.getAccountID())){
			if (card.getCardNumber() == c.getCardNumber()){
				test = true;
			}
		}
		assertTrue(test);
	}

	@Test
	public void testGetCardsByCustomerLongDifferentCustomer(){
		cardServ.registerCard(card,customer2);
		boolean test = false;
		for (Card c: cardServ.getCardsByCustomer(customer.getAccountID())){
			if (card.getCardNumber() == c.getCardNumber()){
				test = true;
			}
		}
		assertFalse(test);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteCardOfCustomerLongLongNoCardID() {
		cardServ.deleteCardOfCustomer(0, customer.getAccountID());
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteCardOfCustomerLongLongNoAccountID() {
		cardServ.deleteCardOfCustomer(card.getCardID(), 0);
	}	
	
	@Test
	public void testDeleteCardOfCustomerLongLongNoDelete() {
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.checkIfAnyoneOwnsCard(card.getCardID()));
	}	
	
	@Test
	public void testDeleteCardOfCustomerLongLongAfterDelete() {
		cardServ.registerCard(card, customer);
		cardServ.deleteCardOfCustomer(card.getCardID(), customer.getAccountID());
		assertFalse(cardServ.checkIfCustomerOwnsCard(card, customer));
	}


	@Test
	public void testCheckIfAnyoneOwnsCardLong() {
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.checkIfAnyoneOwnsCard(card.getCardID()));
	}
	

	@Test
	public void testCheckIfAnyoneOwnsCardLongBeforeRegistrationShouldFalse() {
		assertFalse(cardServ.checkIfAnyoneOwnsCard(card.getCardID()));
	}

	@Test
	public void testCheckIfCustomerOwnsCard() {
		cardServ.registerCard(card, customer);
		assertTrue(cardServ.checkIfCustomerOwnsCard(card, customer));	
	}
	
	@Test
	public void testCheckIfCustomerOwnsCardDoesnt(){
		assertFalse(cardServ.checkIfCustomerOwnsCard(card, customer));
	}

}
