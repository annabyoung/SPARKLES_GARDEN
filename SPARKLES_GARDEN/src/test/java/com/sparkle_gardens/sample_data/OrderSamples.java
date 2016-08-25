package com.sparkle_gardens.sample_data;
/**
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.sparkle_gardens.sample_data.ProductSamples;

@Deprecated
@Ignore
public class OrderSamples 
{
	private OrderSamples()
	{
		
	}
	
	public static Order shoes()
	{
		Order o = new Order(1, new Customer());
		
		o.addOrderLine(new OrderLine(ProductSamples.greatShoes(), 1));
		o.addOrderLine(new OrderLine(ProductSamples.nikeTrainers(), 2));
		o.addOrderLine(new OrderLine(ProductSamples.lilBoots(), 1));
		o.addOrderLine(new OrderLine(ProductSamples.vegasHeelz(), 2));
		
		return o;
	}
	
	public static Order kinky()
	{
		Order o = new Order(2, new Customer());
		
		o.addOrderLine(new OrderLine(ProductSamples.maximusLube(), 1));
		o.addOrderLine(new OrderLine(ProductSamples.dildoInch8(), 2));
		o.addOrderLine(new OrderLine(ProductSamples.vibeRing(), 1));
		o.addOrderLine(new OrderLine(ProductSamples.exstaticSqueeze(), 1));
		o.addOrderLine(new OrderLine(ProductSamples.fleshTorch(), 2));
		
		return o;
	}
	
	public static Order food()
	{
		Order o = new Order(3, new Customer());
		
		o.addOrderLine(new OrderLine(ProductSamples.mango(), 3)); // We'll talk about the third one, later
		o.addOrderLine(new OrderLine(ProductSamples.watermelon(), 1));
		o.addOrderLine(new OrderLine(ProductSamples.cucumber(), 2));
		o.addOrderLine(new OrderLine(ProductSamples.fishNChips(), 2));
		
		return o;
	}
	
	public static List<Order> orders()
	{
		return Arrays.asList(shoes(), kinky(), food());
	}
}
**/