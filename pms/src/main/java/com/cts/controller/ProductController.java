package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Product;
import com.cts.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);	
	}
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	@GetMapping("/product/{productId}")
	public Product getAllProductById(@PathVariable int productId){
		Optional<Product> prod=productRepository.findById(productId);
		if(prod.isEmpty()) {
			System.out.println("Id is not exists in the db");
		}
		return prod.get();
	}
	@DeleteMapping("/product/{productId}")
	public String deleteProductById(@PathVariable int productId){
		Optional<Product> prod=productRepository.findById(productId);
		if(prod.isEmpty()) {
			return ("Id is not exists in the db");
		}
		productRepository.deleteById(productId);
		return "deleted";
	}
	@PutMapping("/product")
	public Product deleteProductById(@RequestBody Product product){
		Optional<Product> prod=productRepository.findById(product.getId());
		if(prod.isPresent()) {
			return productRepository.save(product);
		}
		
		return null;
	}
}
