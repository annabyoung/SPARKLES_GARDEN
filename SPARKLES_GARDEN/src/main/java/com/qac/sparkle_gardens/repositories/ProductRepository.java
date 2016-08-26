package com.qac.sparkle_gardens.repositories;

import java.util.List;
import com.qac.sparkle_gardens.entities.Product;
/**
 * 
 * @author Annabelle Young
 * 
 * Interface for Product Repository. 
 * All the functions for finding a product by its attributes
 * The ability to create, update and delete a product.
 * 
 *
 */
public interface ProductRepository {
	public void persistProduct (Product p);
	public void persistProducts(List<Product> p);
	
	//All of the functions for finding a product by its attribute
	public Product findByProductName(String productName);
	public Product findByProductID(long productID);
	//public Product findByProductTag(String tag);
	public List<Product> findByProductPrice(double price);
	//retrieve all products in product list
	public List<Product> getProducts();
	
	//Create, remove, update and delete products
	public void createProduct (Product p);	
	public void updateProduct (Product p);
	public void deleteProduct (Product p);
}
