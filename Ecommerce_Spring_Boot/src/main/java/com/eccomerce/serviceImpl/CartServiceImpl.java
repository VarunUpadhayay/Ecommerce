package com.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccomerce.entities.Cart;
import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Product;
import com.eccomerce.exception.NotFound;
import com.eccomerce.repository.CartRepository;
import com.eccomerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired 
	CartRepository cartRepository;
	

	public List<Cart> getOrders() {
	
		return cartRepository.findAll();
	}


	@Override
	public void addToCart(Cart cart) {
		try {
		cartRepository.save(cart);
		}
		catch(Exception ex)
		{
			throw new IllegalArgumentException(ex.getMessage());
		}
		
	}


	@Override
	public Cart findById(int cartId) {
		
		Cart cart=cartRepository.findById(cartId).orElse(null);
		if(cart==null)
		{
			throw new NotFound("No order exists with given id "+cartId);
		}
		return cart;
	}

	public List<Cart> findByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cartRepository.findByCustomer(customer);
	}


	@Override
	public List<Cart> findByProduct(Product product) {
		// TODO Auto-generated method stub
		return cartRepository.findByProduct(product);
	}


	@Override
	public Cart update(Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.save(cart);
		return cart;
	}

}
