package com.qac.sparkle_gardens.controllers;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.sparkle_gardens.entities.Customer;
import com.qac.sparkle_gardens.entities.Order;
import com.qac.sparkle_gardens.entities.Product;
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
@Named (value = "wishlist")

@RequestScoped
public class WishlistController {
    
    @Inject 
    private WishlistService wishlistService;
    @Inject
    private CustomerRepository customerRepository;
    @Inject 
    private OrderService orderService;
    
    /**
     * 
     * @param accountId
     * @param product
     */
    public void createWishlist(Customer customer, Product product) {
        wishlistService.createWishlist(customerRepository.findByID(customer.getAccountID()), product);
    }
    
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
     * 
     * @param product
     * @param accountId
     */
    public void addProductToWishlist(Product product, long accountId) {
        wishlistService.addProduct(product, accountId);
    }
    
    /**
     * Removes a product from the wishlist
     * @param product
     * @param wishlistName
     */
    public void removeProductFromWishlist(Product product, long accountId) {
        wishlistService.removeProduct(product, accountId);
    }
    
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