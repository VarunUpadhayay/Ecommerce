package com.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccomerce.entities.Product;
import com.eccomerce.exception.NotFound;
import com.eccomerce.repository.ProductRepository;
import com.eccomerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub'
		try {
			productRepository.save(product);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex.getMessage());

		}
	}

	@Override
	public List<Product> fetchProductList() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Product product=productRepository.findById(id).orElse(null);
		if(product==null)
		{
			throw new NotFound("No product exists with given id "+id);
		}
		return product;
	}

	@Override
	public void updateProductById(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void deleteById(Product product) {
		// TODO Auto-generated method stub
		productRepository.delete(product);
	}

}
