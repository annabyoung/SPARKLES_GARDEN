package com.qac.sparkle_gardens.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qac.sparkle_gardens.repositories.ProductRepository;
import com.qac.sparkle_gardens.util.ProductInitalData;
import com.qac.sparkle_gardens.entities.Product;

public class ProductRepositoryOffline implements ProductRepository{
	@Inject
	private ProductInitalData initialData;
	
	
	public void persistProduct(Product p){
		initialData.addProduct(p);
	}
	
	public void persistProducts(List<Product> p) {
		
	}
	//find a product by ID
	public Product findByProductID(long productID){
		for (Product p : initialData.getProducts()){ //search through all products in product list
			if (productID == p.getProductID()){ //check if the product's ID in product list matches the ID requested
				return p;
			}
		}
		return null;
	}
	//find a product by name
	public Product findByProductName(String productName) {
		for (Product p : initialData.getProducts()){ //search through all products in product list
			if (productName.equals(p.getProductName())){ //check if the product in product list matches the name of product requested
				return p;
			}
		}
		return null;
	}
	//Search for products by price
	public ArrayList<Product> findByProductPrice(double price){
		ArrayList<Product> productsByPrice = new ArrayList<>();
		for (Product p : initialData.getProducts()){ //search through all products in product list
			if (price == p.getPrice()){ //check if the product in list matches the price requested
				productsByPrice.add(p); //add all products that are the same price as the price requested
			}
		}
		return productsByPrice;
	}
	
	/**
	 * Find all products that have a tag that is the same as the tag requested
	 * return an arraylist of products with that same tag
	 */ 
	 public ArrayList<Product> findByProductTag(String tag){
		ArrayList<Product> productsByPrice = new ArrayList<>();
		for (Product p : initialData.getProducts()){ //search through all products in product list
			if (p.findProductTags(tag)){ //check if the product in list matches the tag requested
				productsByPrice.add(p); //add all products that are the same tag as the tag requested
			}
		}
		return productsByPrice;
	}
	
	//retrieve all products
	public ArrayList<Product> getProducts() {
		return (ArrayList<Product>) initialData.getProducts();
	}
		
	public void createProduct(Product p) {
		
	}
	//update the product
	public void updateProduct(Product p) {
		ArrayList<Product> ps =
			(ArrayList<Product>) initialData.getProducts();
		for(int i=0; i<ps.size(); i++) {
			if(ps.get(i).equals(p))
			ps.set(i, p);
		}
		initialData.setProducts(ps);
	}

	public void deleteProduct(Product p) {
		ArrayList<Product> ps =
			(ArrayList<Product>) initialData.getProducts();
		for(int i=0; i<ps.size(); i++) {
			if(ps.get(i).equals(p))
				ps.remove(i);
		}
		initialData.setProducts(ps);
	}
	
}
