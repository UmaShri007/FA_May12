package ai.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.ineuron.bo.Product;
import ai.ineuron.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	//add product to db by mapping the product details from request to bean using @RequestBody
	@PostMapping("/save")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		System.out.println("conttrol in controller");
		try {
		String resultMssg = productService.saveProduct(product);
		System.out.println(product);
		System.out.println("conttrol in controller try");
		return new ResponseEntity<String>(resultMssg,HttpStatus.OK) ;
		}catch(Exception e) {
			return new ResponseEntity<String>("Problem in Product insertion", HttpStatus.INTERNAL_SERVER_ERROR);// 500
			
}
}
	//Get all the product infor from db and display
	@GetMapping("/getAll")
	public ResponseEntity<?> displayProductDetails() {
		System.out.println("conttrol in controller");
		try {
			List<Product> list = productService.getAllProducts();
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetching products", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Update the product details for the requested id
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody Product product,@PathVariable("id")Integer id) {
		try {
			String msg =productService.updateProduct(product,id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
}
	//Delete the product details for the requested id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id")Integer id){
		try {
			String msg = productService.deleteProduct(id);
			//return "Deleted Successfully!!"
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}