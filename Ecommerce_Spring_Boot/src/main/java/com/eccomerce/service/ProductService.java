package com.eccomerce.service;

import java.util.List;

import com.eccomerce.entities.Product;

public interface ProductService {
		public void addProduct(Product product);

		public List<Product> fetchProductList();

		public Product getProduct(int id);

		public void updateProductById(Product product);

		public void deleteById(Product product);
		
		
}
