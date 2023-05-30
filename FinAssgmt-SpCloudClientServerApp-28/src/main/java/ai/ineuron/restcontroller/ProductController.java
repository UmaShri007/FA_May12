package ai.ineuron.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	//This annotation to get value from thee properties file
	@Value("${mssg:Config Server not working,plz check...}")
	public String mssg;
	
	public ResponseEntity<String>showMsg(){
		return new ResponseEntity<String>(mssg,HttpStatus.OK);
	}
	
//	@GetMapping("/get/{id}")
//	public String findById(@PathVariable(name="id")Long id){
//		
//		Optional<Product_FA27>optional = productRepo.findById(id);
//		if(optional.isPresent()) {
//			String prodName = optional.get().getName();
//			return "Product with the id :: " + id +" =====>" +prodName;
//		}else
//			return "Product with the id :: " +id+" doesnt exist.";
//		
//}
}
