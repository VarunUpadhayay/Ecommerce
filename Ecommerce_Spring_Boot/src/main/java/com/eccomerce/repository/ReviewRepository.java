package com.eccomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Product;
import com.eccomerce.entities.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	List<Review> findByCustomer(Customer customer);

	List<Review> findByProduct(Product product);
}
