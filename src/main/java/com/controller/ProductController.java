package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/products")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		System.out.println(productEntity.getProductName());
		System.out.println(productEntity.getProductPrice());
		System.out.println(productEntity.getProductCategory());
		System.out.println(productEntity.getProductQuantity());
		productRepository.save(productEntity);
		return productEntity;
	}
	
	@GetMapping("/products")
	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/productsByID/{productID}")
	public ProductEntity getProductByID(@PathVariable("productID") Integer productID) {
	    Optional<ProductEntity> product = productRepository.findById(productID);
	    return product.isEmpty() ? null : product.get();
	}

	
	@GetMapping("/productsByID2")
	public ProductEntity getProductByID2(@RequestParam("productID") Integer productID) {
	    Optional<ProductEntity> product = productRepository.findById(productID);
	    return product.isEmpty() ? null : product.get();
	}


	
}
