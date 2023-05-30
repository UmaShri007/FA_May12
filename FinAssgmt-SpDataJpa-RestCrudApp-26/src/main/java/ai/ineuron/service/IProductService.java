package ai.ineuron.service;

import java.util.List;
import java.util.Optional;

import ai.ineuron.bo.Product;

public interface IProductService {
	
	public String saveProduct(Product product);
	public List<Product> getAllProducts();
	public String updateProduct(Product product,Integer id);
	public String deleteProduct(Integer productId);
	
}
