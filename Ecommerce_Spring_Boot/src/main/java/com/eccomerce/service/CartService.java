package com.eccomerce.service;

import java.util.List;

import com.eccomerce.entities.Cart;
import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Product;

public interface CartService {

	List<Cart> getOrders();

	void addToCart(Cart cart);

	Cart findById(int cartId);

	List<Cart> findByCustomer(Customer customer);

	List<Cart> findByProduct(Product product);
	Cart update(Cart cart);

}
