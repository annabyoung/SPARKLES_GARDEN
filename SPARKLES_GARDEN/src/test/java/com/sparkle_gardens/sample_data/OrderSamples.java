package com.sparkle_gardens.sample_data;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;

import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Product;

@Ignore
public class OrderSamples 
{
	private OrderSamples()
	{
		
	}
	
	public static Order shoes()
	{
		Order o = new Order();
		
		o.addOrderLine(new OrderLine(new Product("Great shoes", 5, 61.99), 1));
		o.addOrderLine(new OrderLine(new Product("Nike trainers", 10, 82.00), 2));
		o.addOrderLine(new OrderLine(new Product("'lil boots!", 1, 79.99), 1));
		o.addOrderLine(new OrderLine(new Product("Vegas heelz", 3, 120), 2));
		
		return o;
	}
	
	public static Order kinky()
	{
		Order o = new Order();
		
		o.addOrderLine(new OrderLine(new Product("Maximus lube", 10, 10.99), 1));
		o.addOrderLine(new OrderLine(new Product("8\" dildo", 4, 49.99), 2));
		o.addOrderLine(new OrderLine(new Product("Vibe ring", 20, 5.99), 1));
		o.addOrderLine(new OrderLine(new Product("Exstatic squeeze", 2, 9.49), 1));
		o.addOrderLine(new OrderLine(new Product("Flesh torch", 30, 29.99), 2));
		
		return o;
	}
	
	public static Order food()
	{
		Order o = new Order();
		
		o.addOrderLine(new OrderLine(new Product("Mango", 20, 1.00), 3)); // We'll talk about the third one, later
		o.addOrderLine(new OrderLine(new Product("Watermelon", 10, 10), 1));
		o.addOrderLine(new OrderLine(new Product("Cucumber", 20, 0.49), 2));
		o.addOrderLine(new OrderLine(new Product("Fish 'n Chips", 10, 4.99), 2));
		
		return o;
	}
	
	public static Order techies()
	{
		Order o = new Order();
		
		o.addOrderLine(new OrderLine(new Product("Dumb ass iPhone", 10_000, 700), 1));
		o.addOrderLine(new OrderLine(new Product("Ubuntu phone", 5_000, 250.00), 3));
		o.addOrderLine(new OrderLine(new Product("Samsung Bloaty edge", 4, 500), 1));
		o.addOrderLine(new OrderLine(new Product("Dell abc123", 5, 800), 5));
		
		return o;
	}
	
	public static List<Order> orders()
	{
		return Arrays.asList(shoes(), kinky(), food(), techies());
	}
}
