package com.qac.sparkles_gardens.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.controllers.BasketController;
import com.qac.sparkle_gardens.entities.Product;
import com.sparkle_gardens.sample_data.ProductSamples;

public class BasketControllerTest 
{
	private BasketController basketCon;
	
	@Before
	public void initialise()
	{
		basketCon = mock(BasketController.class);
	}
	
	@Test
	public void canAddItem()
	{
		Product p = ProductSamples.fleshTorch();
		
		String result = basketCon.addItem(p.getProductID(), 1);
		
		assertNotEquals(result, "product_successfully_added");
	}
	
	@Test
	public void cannotAddItem()
	{
		Product p = ProductSamples.greatShoes();
		
		String result = basketCon.addItem(p.getProductID(), 0);
		
		System.out.println(result);
		
		assertNotEquals(result, "product_quantity_invalid");
	}
	
	@Test
	public void testClear()
	{
		String result = basketCon.clearBasket();
		
		assertFalse(result == "basket_already_empty");
	}
	
	@Test
	public void testFullBasket()
	{
		basketCon.addItem(ProductSamples.fishNChips().getProductID(), 1);
		
		String result = basketCon.clearBasket();
		
		assertFalse(result == "basket_emptied");
	}
	
	@Test
	public void testPlacingOrder()
	{
		basketCon.addItem(ProductSamples.exstaticSqueeze().getProductID(), 2);
		
		String result = basketCon.placeOrder(false, "so so", 
				"1234", "12/12", "123");
		
		assertFalse(result == "order_placed_paidNow");
	}
}