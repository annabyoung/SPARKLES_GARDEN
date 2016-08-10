package deprecated;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.qac.sparkle_gardens.entities.Product;

/**
 * 
 * @author Annabelle Young
 *
 * Since there is no database yet, storing data at runtime for testing purposes.
 * Functions are included to get, add, and set products.
 *
 *deprecated in favour of InitialData (9/8/16)
 */
@Singleton
@Deprecated
public class ProductInitalData {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public ProductInitalData(){
		Product p = new Product("The Great American Challenge", 50, 79.99);
		p.addProductTags("Dildo");
		products.add(p);
		p = new Product("Fleshlight Original", 100, 99.99);
		p.addProductTags("Masturbator");
		products.add(p);
		p = new Product("The Screaming O", 500, 19.99);
		p.addProductTags("Vibrating");
		products.add(p);
	}
	
	public List<Product> getProducts(){
		return products;
	}
	
	public void addProduct(Product product){
		products.add(product);
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
	
}
