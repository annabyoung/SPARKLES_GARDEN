package com.qac.sparkle_gardens.entities;

import org.junit.Before;

import static org.mockito.Mockito.*;

public class OrderTest
{
	Order order;
	
	@Before
	void initialise()
	{
		order = mock(Order.class);
	}
}
