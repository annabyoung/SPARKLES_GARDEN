package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.entities.Order;
//import com.qac.sparkle_gardens.entities.Payment;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.util.CreditStatus;
import com.qac.sparkle_gardens.util.MethodAuthor;

/**
 * A single initial data object. For simplicity.
 * 
 * @author James Thompson
 *
 */
@Singleton
public class InitialData 
{
	private List<Address> addresses = new ArrayList<Address>();
	private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	private List<Card> cards = new ArrayList<Card>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Order> orders;

	//private ArrayList<Payment> Payments = new ArrayList<Payment>();
	private List<Product> products = new ArrayList<Product>();

	private List<CustomerHasCard> cusHasCards = new ArrayList<CustomerHasCard>();
	private List<CustomerHasAddress> cusHasAddress = new ArrayList<CustomerHasAddress>();
	
	//public InitialData() { }
	
	public InitialData() {
	//Object Creation.
		//long addressId, int buildingNum, String streetName, String city, String county, String country, String postCode
		Address dummyAddress = new Address("Anchorage 1", "Floor 5", "Anchorage Quay", "Salford Quay", "Greater Manchester", "United Kingdom", "M50 3YJ", "Shipping");
		Customer customer = new Customer(1, "John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890");
		Customer customer2 = new Customer(2, "Jane", "doe", "email01@email.com", CreditStatus.VALIDATING, "password01", "0987654321");
		Customer customer3 = new Customer(3, "Joe", "Schmoe", "email999@email.com", CreditStatus.VALID, "password01", "1357908642");
		Customer customer4 = new Customer(4, "Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
		Card card = new Card(1, "Connect", "4412345647894531", "12/17");
		Card card2 = new Card(2, "Head", "4212345647894531", "11/12");
		Card card3 = new Card(3, "Hammer", "4552345647894531", "12/13");
		
		customers.add(0, customer);
		customers.add(1, customer2);
		customers.add(2, customer3);
		customers.add(3, customer4);
		cards.add(0, card);
		cards.add(1, card2);
		cards.add(2, card3);
		cusHasCards.add(new CustomerHasCard(customers.get(2), cards.get(0)));
		cusHasCards.add(new CustomerHasCard(customers.get(2), cards.get(1)));
		cusHasCards.add(new CustomerHasCard(customers.get(2), cards.get(2)));
		addresses.add(dummyAddress);
		
//		cusHasAddress.add(new CustomerHasAddress(joeSchmoe,dummyAddress));
//		cusHasAddress.add(new CustomerHasAddress(lukeSkyWalker,dummyAddress));
//		cusHasAddress.add(new CustomerHasAddress(janeDoe,dummyAddress));
//		cusHasAddress.add(new CustomerHasAddress(johnSmith,dummyAddress));
		
		// Create order with orderID & customer
		
//		orders.add(new Order(1, customers.get(0)));
//		orders.add(new Order(2, customers.get(1)));
//		orders.add(new Order(3, customers.get(2)));
//		orders.add(new Order(4, customers.get(3)));
//		orders.add(new Order(5, customers.get(4)));
		
		// Add order line to order by product, quantity & price
//		orders.get(0).addOrderLine(new OrderLine(new Product("Pretty trainers", 3, 30), 3));
//		orders.get(0).addOrderLine(new OrderLine(new Product("Funky gnome", 5, 12), 2));
//		
//		orders.get(1).addOrderLine(new OrderLine(new Product("Awesome boots", 3, 100), 1));
//		
//		orders.get(2).addOrderLine(new OrderLine(new Product("Amazing watch", 1, 50), 2));
//		
//		orders.get(3).addOrderLine(new OrderLine(new Product("Superduper gaming rig!", 2, 600), 10));
//		orders.get(3).addOrderLine(new OrderLine(new Product("Great socks!", 10, 40), 2));
//		orders.get(3).addOrderLine(new OrderLine(new Product("Allen's Mac", 1, 231), 12));
//		
//		orders.get(4).addOrderLine(new OrderLine(new Product("Impressive glasses", 2, 200), 1)); 
//		orders.get(5).addOrderLine(new OrderLine(new Product("Gandhi's Nukes", -1, 9001), 1));
		
		/*
		// Add payments
		Payments.add(new Payment(1, 1, 1, PaymentStatus.PENDING));
		Payments.add(new Payment(2, 2, 2, PaymentStatus.PENDING));
		Payments.add(new Payment(3, 3, 3, PaymentStatus.PENDING));
		*/
		
//		Product p = new Product("The Great American Challenge", 50, 79.99);
//		p.addProductTags("Dildo");
//		products.add(p);
//		p = new Product("Fleshlight Original", 100, 99.99);
//		p.addProductTags("Masturbator");
//		products.add(p);
//		p = new Product("The Screaming O", 500, 19.99);
//		p.addProductTags("Vibrating");
//		products.add(p);
//		wishlists.add(new Wishlist((long) 24, products));
	}

	public List<Address> getAddresses() {
//		if (addresses.isEmpty())
//			setupInitialData();
		return addresses;
	}

	public List<Wishlist> getWishlists() {
//		if (wishlists.isEmpty())
//			setupInitialData();
		return wishlists;
	}

	public List<Card> getCards() {
//		if (cards.isEmpty())
//			setupInitialData();
		return cards;
	}

	public List<Customer> getCustomers() {
//		if (customers.isEmpty())
//			setupInitialData();
		return customers;
	}

	public List<Order> getOrders() {
//		if (orders.isEmpty())
//			setupInitialData();
		return orders;
	}

	public List<Product> getProducts() {
//		if (products.isEmpty())
//			setupInitialData();
		return products;
	}

	public List<CustomerHasCard> getCusHasCards() {
//		if (cusHasCards.isEmpty())
//			setupInitialData();
		return cusHasCards;
	}

	public List<CustomerHasAddress> getCusHasAddress() {
		/*if (cusHasAddress.isEmpty())
			setupInitialData();*/
		return cusHasAddress;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setCusHasCards(List<CustomerHasCard> cusHasCards) {
		this.cusHasCards = cusHasCards;
	}

	public void setCusHasAddress(List<CustomerHasAddress> cusHasAddress) {
		this.cusHasAddress = cusHasAddress;
	}
}