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
	
	public Product findByProductName(String productName) {
		return null;
	}

	public ArrayList<Product> getProducts() {
		return (ArrayList<Product>) initialData.getProducts();
	}
		
	//To be implemented later
	public void createProduct(Product p) {
		
	}

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
