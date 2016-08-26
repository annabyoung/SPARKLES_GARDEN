package com.qac.sparkle_gardens.rest;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;
import com.qac.sparkle_gardens.entities.Wishlist;
import com.qac.sparkle_gardens.repositories.CustomerRepository;
import com.qac.sparkle_gardens.services.OrderService;
import com.qac.sparkle_gardens.services.WishlistService;

/**
 * 
 * @author Tyler Deans
 * 
 * This controller adds items to the wishlist and gets the product information
 * 
 */

@Path (value = "/")
@RequestScoped
public class WishlistRESTController {
    
    @Inject 
    private WishlistService wishlistService;
    @Inject
    private CustomerRepository customerRepository;  
    @Inject 
    private OrderService orderService;
    
    @POST
    @Consumes("text/plain")
    @Path("new_wishlist")
    public void createWishlist(long accountId) {
        wishlistService.createWishlist(customerRepository.findByID(accountId));
    }
    /**
     * Creates a wishlist when one product is added to the list
     * when created
     * @param accountId
     * @param product
     */
    public void createWishlist(Customer customer, Product product) {
        wishlistService.createWishlist(customerRepository.findByID(customer.getAccountID()), product);
    }
    
    
    /**
     * Creates a wishlist where a list of products are added
     * @param customer
     * @param products
     */
    public void createWishlist(Customer customer, List<Product> products) {
        wishlistService.createWishlist(customer, products);
    }
    
    /**
     * Adds a product in the wishlist to the basket
     * @param product
     */
    public boolean addProductToBasket(Product product, Order order) {
    	int quantity = orderService.getQuanity(product);
    	return orderService.addProductToBasket(order, product, quantity);
    }
    
    /**
     * Overloading addProductToWishlist method because 
     * a customer object can be passed or the account ID.
     * 
     * Accounting for both just in case.
     * @param product
     * @param accountId
     */
    public void addProductToWishlist(Product product, long accountId) {
        wishlistService.addProduct(product, accountId);
    }
    
    public void addProductToWishlist(Product product, Customer customer) {
        wishlistService.addProduct(product, customer.getAccountID());
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("wishlist")
    public Wishlist getWishlist(Customer customer) {
        return wishlistService.getWishlist(customer);
    }
    
    /**
     * Removes a product from the wishlist
     * @param product
     * @param wishlistName
     */
    public void removeProductFromWishlist(Product product, long accountId) {
        wishlistService.removeProduct(product, accountId);
    }
    
    public void removeProductFromWishlist(Product product, Customer customer) {
        wishlistService.removeProduct(product, customer.getAccountID());
    }
    
    /**
     *  @param customer
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("wishlist/products")
    public List<Product> getProducts(Customer customer) {
        return wishlistService.getProducts(customer.getAccountID());
    }
    /**
     * Creates a wishlist for a given customer
     * @param accountId
     * @param wishlistName
     */
    //@Deprecated
    //public void createWishlist(long accountId, String wishlistName) {
        //wishlistService.createWishlist(customerRepository.findByID(accountId), wishlistName);
    //}
    
    /**
     * Adds a product to the wishlist
     * @param product
     * @param wishlistName
     */
    //@Deprecated
    //public void addProductToWishlist(Product product, String wishlistName) {
        //wishlistService.addProduct(product, wishlistName);
    //}
    
    
    
    /**
     * Gets all the products in the wishlist
     * @return
     */
    //@Deprecated
    //public List<Product> getProducts(String wishlistName) {
        //return wishlistService.getProducts(wishlistName);
    //}
    
}
