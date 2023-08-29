package com.eccomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eccomerce.entities.Cart;
import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findByCustomer(Customer customer);

	List<Cart> findByProduct(Product product);
}
