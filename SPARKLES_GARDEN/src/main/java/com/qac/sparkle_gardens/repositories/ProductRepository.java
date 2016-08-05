package com.qac.sparkle_gardens.repositories;

import java.util.ArrayList;
import java.util.List;
import com.qac.sparkle_gardens.entities.Product;
/**
 * 
 * @author Annabelle Young
 * 
 * Interface for Product Repository. This defines ability to create, update and delete a product.
 *
 */
public interface ProductRepository {
	public void persistProduct (Product p);
	public void persistProducts(List<Product> p);
	
	public Product findByProductName(String productName);
	public Product findByProductID(long productID);
	public Product findByProductPrice(double price);
	public ArrayList<Product> getProducts();
	
	//Create, remove, update and delete products
	public void createProduct (Product p);	
	public void updateProduct (Product p);
	public void deleteProduct (Product p);
}
