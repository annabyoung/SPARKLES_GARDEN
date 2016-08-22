/**
 * 
 */
package com.qac.sparkle_gardens.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.qac.sparkle_gardens.entities.Product;

/**
 * @author Annabelle Young
 *
 */
public class SearchItemsControllerTest {
	
	@Mock
	private Product product;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
