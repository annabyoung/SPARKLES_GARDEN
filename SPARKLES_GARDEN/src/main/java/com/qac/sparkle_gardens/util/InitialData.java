package com.qac.sparkle_gardens.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import com.qac.sparkle_gardens.entities.Address;
import com.qac.sparkle_gardens.entities.Card;
import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.OrderLine;
import com.qac.sparkle_gardens.entities.Payment;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;

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
	private ArrayList<Wishlist> wishlists = new ArrayList<Wishlist>();
	private ArrayList<Card> Cards = new ArrayList<Card>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Order> orders;
	private ArrayList<Payment> Payments = new ArrayList<Payment>();
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public InitialData() 
	{
		addresses.add(new Address(25, 1, "Anchorage 1", "Anchorage Quay", "Salford Quays", "England", "M50 3YJ"));
		Cards.add(new Card(1, "Connect", "4412345647894531", "12/12"));
		Cards.add(new Card(2, "Head", "4212345647894531", "11/12"));
		Cards.add(new Card(3, "Hammer", "4552345647894531", "12/13"));
		
		customers.add(new Customer("John", "Smith", "email@email.com", CreditStatus.ONHOLD, "password01", "1234567890"));
		customers.add(new Customer("Jane", "doe", "email01@email.com", CreditStatus.VALIDATING, "password01", "0987654321"));
		customers.add(new Customer("Joe", "Schmoe", "email999@email.com", CreditStatus.VALID, "password01", "1357908642"));
		customers.add(new Customer("Luke", "Skywalker", "theForce@deathstar.com", CreditStatus.VALID, "password01", "2468097531"));
		
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
		
		// Add payments
		Payments.add(new Payment(1, 1, 1, PaymentStatus.PENDING));
		Payments.add(new Payment(2, 2, 2, PaymentStatus.PENDING));
		Payments.add(new Payment(3, 3, 3, PaymentStatus.PENDING));
		
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
	public ArrayList<Address> getAddresses() {
		return (ArrayList<Address>) addresses;
	}

	@MethodAuthor(author = "Tyler Deans")
	public void addAddress(Address address) {
		addresses.add(address);
	}

	@MethodAuthor(author = "Tyler Deans")
	public void setAddresses(List<Address> addresses) {
		this.addresses = (ArrayList<Address>) addresses;
	}
	
	@MethodAuthor(author = "Tyler Deans")
	public ArrayList<Wishlist> getWishlists() {
		return wishlists;
	}
	
	@MethodAuthor(author = "Tyler Deans")
	public void addWishlist(Wishlist wishlist) {
		wishlists.add(wishlist);
	}
	
	@MethodAuthor(author = "Tyler Deans")
	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = (ArrayList<Wishlist>) wishlists;
	}

	public void addCard(Card p) {
		this.Cards.add(p);
	}

	public ArrayList<Card> getCards() {
		return Cards;
	}

	public void setCards(ArrayList<Card> Cards) {
		this.Cards = Cards;
	}

	@MethodAuthor(author = "Sean Connelly")
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	@MethodAuthor(author = "Sean Connelly")
	public void setCustomer(ArrayList<Customer> customers) {
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
	public ArrayList<Order> getOrders()
	{
		return orders;
	}
	
	/**
	 * Concurrently set all orders in a list by another
	 * @param orders
	 */
	@MethodAuthor(author="Damien Lloyd")
	public void setOrders(ArrayList<Order> orders)
	{
		this.orders = orders;
	}
	
	public void addPayment(Payment p)
	{
		this.Payments.add(p);
	}
	
	public ArrayList<Payment> getPayments()
	{
		return Payments;
	}
	
	public void setPayments(ArrayList<Payment> Payments)
	{
		this.Payments = Payments;
	}
	
	@MethodAuthor(author="Annabelle Young")
	public List<Product> getProducts(){
		return products;
	}
	
	@MethodAuthor(author="Annabelle Young")
	public void addProduct(Product product){
		products.add(product);
	}

	@MethodAuthor(author="Annabelle Young")
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}