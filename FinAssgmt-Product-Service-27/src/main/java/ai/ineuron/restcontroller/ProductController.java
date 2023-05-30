package ai.ineuron.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.ineuron.dao.IProductRepository;
import ai.ineuron.model.Product_FA27;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private IProductRepository productRepo;
	
	@GetMapping("/get/{id}")
	public String findById(@PathVariable(name="id")Long id){
		
		Optional<Product_FA27>optional = productRepo.findById(id);
		if(optional.isPresent()) {
			String prodName = optional.get().getName();
			return "Product with the id :: " + id +" =====>" +prodName;
		}else
			return "Product with the id :: " +id+" doesnt exist.";
		
}
}
