package com.qac.sparkle_gardens.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;
import com.sparkle_gardens.sample_data.OrderSamples;
import com.sparkle_gardens.sample_data.ProductSamples;

import junit.framework.TestCase;

/**
 * Order Service test
 * @author Damien Lloyd
 *
 */
public class OrderServiceTest
{
	OrderService service;
	Order order;
	Product product;
	
	/**
	 * Initialise the test by allocating memory to service.
	 * Order and product should not be initialised; there are pre-created
	 * objects for those.
	 */
	@Before
	public void initialise()
	{
		service = new OrderService();
		order = new Order();
		product = new Product();
	}
	
	/**
	 * Test whether the order is empty or not. 
	 * It should return false as there is an order with quantity.
	 */
	@Test
	public void orderEmpty()
	{
		order = OrderSamples.kinky();
		boolean result = service.isOrderEmpty(order.getOrderID());
		assertFalse(result);
	}
	
	/**
	 * Test if the order is valid or no.
	 * Should return false as the desired 
	 * quantity is greater than stock level.
	 */
	@Test
	public void checkOrderValid()
	{
		product = ProductSamples.cucumber();
		boolean result = service.isValid(45, 
				product.getPrice(), product.getStockLevel());
		assertFalse(result);
	}
	
	@Test
	public void ensurePricePositive()
	{
		order = OrderSamples.food();
		assertFalse(service.getTotalPrice(order.getOrderID()) <= 0);
	}
	
	/**
	 * Test whether the invoice object is null or not and is not equal
	 * to a blank string.
	 * Should return false as the invoice isn't null nor blank.
	 */
	@Test
	public void isInvoiceNull()
	{		
		order = OrderSamples.food();
		String invoice = service.generateInvoice(order.getOrderID());
		assertNotNull(invoice);
		assertNotEquals(invoice, "");
	}
	
	/**
	 * Test whether a product can be added to a basket or not.
	 * It should return true if the product was successfully added.
	 */
	@Test
	public void productBasketAdd()
	{
		product = ProductSamples.fishNChips();
		
		boolean added = service.addProductToBasket(product, 2);
		assertFalse(added);
	}
	
	/**
	 * Examine whether a null product is added to a basket. 
	 * It should return false as the product is null.
	 */
	@Test
	public void nullProductBasketAdd()
	{
		product = null;
		
		boolean added = service.addProductToBasket(product, 1);
		assertFalse(added);
	}
	
	/**
	 * This test examines whether a product is removed. 
	 * It should return false as the product was not added.
	 */
	@Test
	public void productBasketRemove()
	{
		product = ProductSamples.nikeTrainers();
		
		boolean remove = service.removeItemFromBasket(product);
		assertFalse(remove);
	}
	
	/**
	 * This test will assess whether the product was removed from the basket.
	 * It should return true as the product was added.
	 */
	@Test
	public void productBasketAddRemove()
	{
		product = ProductSamples.vegasHeelz();
		
		service.addProductToBasket(product, 1);
		
		boolean remove = service.removeItemFromBasket(product);
		
		assertTrue(remove);
	}
	
	/**
	 * Empty the basket with products therein.
	 * It should return true as the basket has products.
	 */
	@Test
	public void basketEmpty()
	{
		product = ProductSamples.maximusLube();
		
		service.addProductToBasket(product, 2);
		
		boolean clear = service.clearBasket();
		
		assertTrue(clear);
	}
	
	/**
	 * Empty the basket. 
	 * It should return false because the basket is already empty!
	 */
	@Test
	public void basketNotEmpty()
	{
		boolean clear = service.clearBasket();
		
		assertFalse(clear);
	}
	
	/**
	 * Create an order from the products in the basket.
	 * It should return true as products are in the basket.
	 * NOTE: The payLater parameter has no effect on the result.
	 */
	@Test
	public void orderCreated()
	{
		product = ProductSamples.exstaticSqueeze();
		service.addProductToBasket(product, 2);
		
		boolean result = service.createOrder(true);
		
		assertTrue(result);
	}
	
	/**
	 * Test whether the order can be dispatched or not. If it is placed
	 * or packing, then it can be cancelled (should return true); else false.
	 */
	@Test
	public void canCancelOrder()
	{
		order = OrderSamples.shoes();
		
		boolean result = service.canCancelOrder(order);
		
		assertFalse(result);
	}
	
	/**
	 * @author Annabelle Young
	 * Set variables to null so they can be re-implemented
	 */
	@After
	public void teardown()
	{
		service = null;
		order = null;
		product = null;
	}
	
}
