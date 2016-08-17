package com.qac.sparkle_gardens.test_data;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.CustomerHasAddress;
import com.qac.sparkle_gardens.entities.CustomerHasCard;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
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
	private List<Card> Cards = new ArrayList<Card>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Order> orders;

	//private ArrayList<Payment> Payments = new ArrayList<Payment>();
	private List<Product> products = new ArrayList<Product>();

	private List<CustomerHasCard> cusHasCards = new ArrayList<CustomerHasCard>();
	private List<CustomerHasAddress> cusHasAddress = new ArrayList<CustomerHasAddress>();
	
	public InitialData() 
	{
		//Object Creation.
		//long addressId, int buildingNum, String streetName, String city, String county, String country, String postCode
		Address dummyAddress = new Address(1, "Anchorage", "Anchorage Quay", "Salford Quays", "England", "M50 3YJ");
		Customer johnSmith = new Customer("John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890");
		Customer janeDoe = new Customer("Jane", "doe", "email01@email.com", CreditStatus.VALIDATING, "password01", "0987654321");
		Customer joeSchmoe = new Customer("Joe", "Schmoe", "email999@email.com", CreditStatus.VALID, "password01", "1357908642");
		Customer lukeSkyWalker = new Customer("Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531");
		Card card1 = new Card(1, "Connect", "4412345647894531", "12/12");
		Card card2 = new Card(2, "Head", "4212345647894531", "11/12");
		Card card3 = new Card(3, "Hammer", "4552345647894531", "12/13");
		
		addresses.add(dummyAddress);
		Cards.add(card1);
		Cards.add(card2);
		Cards.add(card3);
		customers.add(johnSmith);
		customers.add(janeDoe);
		customers.add(lukeSkyWalker);
		customers.add(joeSchmoe);
		
		cusHasCards.add(new CustomerHasCard(johnSmith, card1));
		cusHasCards.add(new CustomerHasCard(joeSchmoe, card2));
		cusHasCards.add(new CustomerHasCard(lukeSkyWalker, card3));
		
		cusHasAddress.add(new CustomerHasAddress(joeSchmoe,dummyAddress));
		cusHasAddress.add(new CustomerHasAddress(lukeSkyWalker,dummyAddress));
		cusHasAddress.add(new CustomerHasAddress(janeDoe,dummyAddress));
		cusHasAddress.add(new CustomerHasAddress(johnSmith,dummyAddress));
		
		// Create order with orderID & customer
		orders.add(new Order(1, customers.get(0)));
		orders.add(new Order(2, customers.get(1)));
		orders.add(new Order(3, customers.get(2)));
		orders.add(new Order(4, customers.get(3)));
		orders.add(new Order(5, customers.get(4)));
		
		// Add order line to order by product, quantity & price
		orders.get(0).addOrderLine(new OrderLine(new Product("Pretty trainers", 3, 30), 3));
		orders.get(0).addOrderLine(new OrderLine(new Product("Funky gnome", 5, 12), 2));
		
		orders.get(1).addOrderLine(new OrderLine(new Product("Awesome boots", 3, 100), 1));
		
		orders.get(2).addOrderLine(new OrderLine(new Product("Amazing watch", 1, 50), 2));
		
		orders.get(3).addOrderLine(new OrderLine(new Product("Superduper gaming rig!", 2, 600), 10));
		orders.get(3).addOrderLine(new OrderLine(new Product("Great socks!", 10, 40), 2));
		orders.get(3).addOrderLine(new OrderLine(new Product("Allen's Mac", 1, 231), 12));
		
		orders.get(4).addOrderLine(new OrderLine(new Product("Impressive glasses", 2, 200), 1)); 
		orders.get(5).addOrderLine(new OrderLine(new Product("Gandhi's Nukes", -1, 9001), 1));
		
		/*
		// Add payments
		Payments.add(new Payment(1, 1, 1, PaymentStatus.PENDING));
		Payments.add(new Payment(2, 2, 2, PaymentStatus.PENDING));
		Payments.add(new Payment(3, 3, 3, PaymentStatus.PENDING));
		*/
		
		Product p = new Product("The Great American Challenge", 50, 79.99);
		p.addProductTags("Dildo");
		products.add(p);
		p = new Product("Fleshlight Original", 100, 99.99);
		p.addProductTags("Masturbator");
		products.add(p);
		p = new Product("The Screaming O", 500, 19.99);
		p.addProductTags("Vibrating");
		products.add(p);
		wishlists.add(new Wishlist((long) 24, products));
	}

	@MethodAuthor(author = "Tyler Deans")
	public List<Address> getAddresses() {
		return addresses;
	}

	@MethodAuthor(author = "Tyler Deans")
	public void addAddress(Address address) {
		addresses.add(address);
	}

	@MethodAuthor(author = "Tyler Deans")
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	@MethodAuthor(author = "Tyler Deans")
	public List<Wishlist> getWishlists() {
		return wishlists;
	}
	
	@MethodAuthor(author = "Tyler Deans")
	public void addWishlist(Wishlist wishlist) {
		wishlists.add(wishlist);
	}
	
	@MethodAuthor(author = "Tyler Deans")
	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}
	
	@MethodAuthor(author = "Tyler Deans")
	public List<CustomerHasAddress> getCustomerHasAddresses() {
		return cusHasAddress;
	}

	@MethodAuthor(author = "Tyler Deans")
	public void addCustomerHasAddress(CustomerHasAddress cust) {
		cusHasAddress.add(cust);
	}
	
	@MethodAuthor(author = "Tyler Deans")
	public void setCustomerHasAddresses(List<CustomerHasAddress> cust) {
		this.cusHasAddress = cust;
	}
	 
	public void addCard(Card p) {
		this.Cards.add(p);
	}

	public List<Card> getCards() {
		return Cards;
	}

	public void setCards(List<Card> Cards) {
		this.Cards = Cards;
	}

	@MethodAuthor(author = "Sean Connelly")
	public List<Customer> getCustomers() {
		return customers;
	}

	@MethodAuthor(author = "Sean Connelly")
	public void setCustomer(List<Customer> customers) {
		this.customers = customers;
	}

	@MethodAuthor(author = "Sean Connelly")
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	/**
	 * Add an order to list of orders
	 * @param o
	 */
	@MethodAuthor(author="Damien Lloyd")
	public void addOrder(Order o)
	{
		this.orders.add(o);
	}
	
	/**
	 * Get list of orders
	 * @return orders
	 */
	@MethodAuthor(author="Damien Lloyd")
	public List<Order> getOrders()
	{
		return orders;
	}
	
	/**
	 * Concurrently set all orders in a list by another
	 * @param orders
	 */
	@MethodAuthor(author="Damien Lloyd")
	public void setOrders(List<Order> orders)
	{
		this.orders = orders;
	}

	
//	public void addPayment(Payment p)
//	{
//		this.Payments.add(p);
//	}
//	
//	public List<Payment> getPayments()
//	{
//		return Payments;
//	}
//	
//	public void setPayments(List<Payment> Payments)
//	{
//		this.Payments = Payments;
//	}
	

	@MethodAuthor(author="Annabelle Young")
	public List<Product> getProducts(){
		
		return products;
	}
	
	@MethodAuthor(author="Annabelle Young")
	public void addProduct(Product product){
		this.products.add(product);
	}

	@MethodAuthor(author="Annabelle Young")
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}