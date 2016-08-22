package com.qac.sparkles_gardens.controllers;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.qac.sparkle_gardens.controllers.BasketController;
import com.sparkle_gardens.sample_data.ProductSamples;

public class BasketControllerTest 
{
	private BasketController basketCon;
	
	@Before
	void initialise()
	{
		basketCon = mock(BasketController.class);
	}
	
	@Test
	void testClear()
	{
		String result = basketCon.clearBasket();
		
		assertFalse(result == "basket_already_empty");
	}
	
	@Test
	void testFullBasket()
	{
		basketCon.addItem(ProductSamples.fishNChips().getProductID());
		
		String result = basketCon.clearBasket();
		
		assertFalse(result == "basket_emptied");
	}
}
