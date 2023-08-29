package com.eccomerce.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eccomerce.entities.Product;
import com.eccomerce.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	ProductService productService;
	@PostMapping("new")
	public ResponseEntity<Product> addNewProduct(@Valid @RequestBody Product product){
		productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	
	
	
	@GetMapping("")
	public ResponseEntity<List<Product>> getProductList()
	{
		List<Product> products=productService.fetchProductList();
		if(products.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(products);
	}
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable int productId)
	{
		Product product=productService.getProduct(productId);
		if(product==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productId,@Valid @RequestBody Product product)
	{
		Product product1=productService.getProduct(productId);
		if(product1==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
			product.setProductId(productId);
			productService.updateProductById(product);
		return ResponseEntity.ok(product);
	}
	@DeleteMapping("/{productId}")
	public ResponseEntity<Product> deleteProductById(@PathVariable int productId)
	{
		Product product=productService.getProduct(productId);
		if(product==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		productService.deleteById(product);
		return ResponseEntity.ok(product);
	}
}
