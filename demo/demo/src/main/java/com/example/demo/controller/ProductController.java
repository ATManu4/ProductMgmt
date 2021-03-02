package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repo.ProductRepo;
import com.example.demo.controller.Product;

@RestController
@RequestMapping(value="/app")
public class ProductController {
	
	@Autowired
	ProductRepo productrepo;
	
	@GetMapping("/")
	public String index() {
		return "Greeting from Aditya Thakur";
	}
	
	@GetMapping("/view")
	public List<Product> getAllProduct(){
		return (List<Product>) productrepo.findAll();
	}
	
	@GetMapping("/view/{id}")
	public Product getProductById(@PathVariable(value="id") int productId) {
		return productrepo.findOne(productId);
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable(value = "id") int productId, @Valid @RequestBody Product productDetails) {
		/*Product product = productrepo.findOne(productId);
		Product.setName(productDetails.getName());
        Product.setPrice(productDetails.getPrice());

        Product updatedProd = productrepo.save(product);
        return updatedProd;
        */
		return productrepo.save(productDetails);
	}
	
	@PostMapping("/product")
	public Product createProduct(@Valid @RequestBody Product product){
		return productrepo.save(product);		
	}
	
	@DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer productId) {
        Product product = productrepo.findOne(productId);
        productrepo.delete(product);
        return ResponseEntity.ok().build();
    }
	
}
