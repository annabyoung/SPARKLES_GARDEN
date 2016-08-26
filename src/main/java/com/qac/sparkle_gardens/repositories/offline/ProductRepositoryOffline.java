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
	@Inject private ProductInitialData initialData = new ProductInitialData();
	private List<Product> productList = new ArrayList<>();

	public void persistProduct(Product p){
//		initialData.addProduct(p);
	}
	
	public void persistProducts(List<Product> p) {
		
	}
	//find a product by ID
	public Product findByProductID(long productID){
		productList.addAll(initialData.getAllProducts());
		for (Product p : productList){ //search through all products in product list
			if (productID == p.getProductID()){ //check if the product's ID in product list matches the ID requested
				return p;
			}
		}
		return null;
	}

	//find a product by name
	public Product findByProductName(String productName) {
		//for (Product p : initialData.getAllProducts()){ //search through all products in product list
		productList.addAll(initialData.getAllProducts());
		for (Product p : productList){ //search through all products in product list
			if (productName.equals(p.getProductName())){ //check if the product in product list matches the name of product requested
				return p;
			}
		}
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