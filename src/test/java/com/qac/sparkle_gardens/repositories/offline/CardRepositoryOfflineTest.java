package com.qac.sparkle_gardens.repositories.offline;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.test_data.InitialData;

public class CardRepositoryOfflineTest {
	
	@Mock
	private InitialData initialData;
	@Mock
	private Logger log;
	@InjectMocks
	private CardRepositoryOffline cardRepository;
	
	private Card card;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		card = new Card("Stupid","12331233132312331233", "10/12");
	}

	@After
	public void tearDown() throws Exception {
		card = null;
	}

	@Test
	public void testAddCard() {
		cardRepository.addCard(card);
		assertTrue(cardRepository.findByCardNumber(card.getCardNumber()) != null);
	}

	@Test
	public void testListCards() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersistCards() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCards() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCardNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCardNumberAndExpiration() {
		fail("Not yet implemented");
	}

}
