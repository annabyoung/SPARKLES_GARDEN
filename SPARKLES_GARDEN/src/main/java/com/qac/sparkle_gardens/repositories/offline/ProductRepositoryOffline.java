package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.sparkle_gardens.repositories.ProductRepository;
import com.qac.sparkle_gardens.test_data.ProductInitialData;
import com.qac.sparkle_gardens.entities.Product;

@Stateless
@Default
public class ProductRepositoryOffline implements ProductRepository
{
<<<<<<< HEAD
	@Inject private ProductInitialData initialData;
	

=======
	@Inject private ProductInitialData initialData = new ProductInitialData();
	

	
>>>>>>> 95130093bd8f8cc7b7d8dcb75b08d1e1e3436eed
	public void persistProduct(Product p){
//		initialData.addProduct(p);
	}
	
	public void persistProducts(List<Product> p) {
		
	}
	
	//find a product by ID
	public Product findByProductID(long productID){
//		for (Product p : initialData.getAllProducts()){ //search through all products in product list
//			if (productID == p.getProductID()){ //check if the product's ID in product list matches the ID requested
//				return p;
//			}
//		}
		return null;
	}
	
	//find a product by name
	public Product findByProductName(String productName) {
//		for (Product p : initialData.getAllProducts()){ //search through all products in product list
//			if (productName.equals(p.getProductName())){ //check if the product in product list matches the name of product requested
//				return p;
//			}
//		}
		return null;
	}
	
	//Search for products by price
	public List<Product> findByProductPrice(double price){
		List<Product> productsByPrice = new ArrayList<Product>();
//		for (Product p : initialData.getAllProducts()){ //search through all products in product list
//			if (price == p.getPrice()){ //check if the product in list matches the price requested
//				productsByPrice.add(p); //add all products that are the same price as the price requested
//			}
//		}
		return productsByPrice;
	}
	
	/**
	 * Find all products that have a tag that is the same as the tag requested
	 * return an arraylist of products with that same tag
	 */ 
	 public List<Product> findByProductTag(String tag){
		List<Product> productsByPrice = new ArrayList<Product>();
//		for (Product p : initialData.getAllProducts()){ //search through all products in product list
//			if (p.findProductTags(tag)){ //check if the product in list matches the tag requested
//				productsByPrice.add(p); //add all products that are the same tag as the tag requested
//			}
//		}
		return productsByPrice;
	}
	
	//retrieve all products
	public List<Product> getProducts() {
		//List<Product> prodlist = initialData.getAllProducts();
		//return prodlist;
		return initialData.getAllProducts();
	}
		
	public void createProduct(Product p) {
		
	}
	
	//update the product
	public void updateProduct(Product p) {
		List<Product> ps = initialData.getAllProducts();
		for(int i=0; i<ps.size(); i++) {
			if(ps.get(i).equals(p))
			ps.set(i, p);
		}
		initialData.setProducts(ps);
	}

	public void deleteProduct(Product p) {
		List<Product> ps = initialData.getAllProducts();
		for(int i=0; i<ps.size(); i++) {
			if(ps.get(i).equals(p))
				ps.remove(i);
		}
		initialData.setProducts(ps);
	}	
}