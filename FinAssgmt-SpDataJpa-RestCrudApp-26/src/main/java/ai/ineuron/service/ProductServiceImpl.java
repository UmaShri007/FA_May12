package ai.ineuron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ineuron.bo.Product;
import ai.ineuron.dao.IProductRepository;
import ai.ineuron.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepo;

	@Override
	public String saveProduct(Product product) {
			Integer pId = productRepo.save(product).getId();
			System.out.println("conttrol in service");
			System.out.println(product);
			return  "Product saved to db successfully with  " + pId;
				
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = (List<Product>) productRepo.findAll();
		System.out.println("conttrol in service");
		return productList;
	}

	@Override
	public String updateProduct(Product product, Integer id) {

		Product existingProduct = productRepo.findById(id).get();
		
		if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
			existingProduct.setName(product.getName());
		}

		if (Objects.nonNull(product.getBrand()) && !"".equalsIgnoreCase(product.getBrand())) {
			existingProduct.setBrand(product.getBrand());
		}
		if(product.getCost()!=null)
		existingProduct.setCost(product.getCost());
		
		productRepo.save(existingProduct);

		return "Product updated for the id " + existingProduct.getId();
	}

	@Override
	public String deleteProduct(Integer productId) {
		Optional<Product> optional = productRepo.findById(productId);
		if (optional.isPresent()) {
			productRepo.delete(optional.get());
			return "Product with the id :: " + productId + " deleted...";
		} else {
			throw new ProductNotFoundException("Prodcut not found for the id " + productId);
		}
	}

}
