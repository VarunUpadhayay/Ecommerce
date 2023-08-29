package com.eccomerce.service;

import java.util.List;

import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Product;
import com.eccomerce.entities.Review;

public interface ReviewService {

	void addReview(Review review);

	List<Review> getAllReviews();

	Review findById(int reviewId);

	List<Review> findByCustomer(Customer customer);
	List<Review> findByProduct(Product product);
	public void update(Review review);
	

}
