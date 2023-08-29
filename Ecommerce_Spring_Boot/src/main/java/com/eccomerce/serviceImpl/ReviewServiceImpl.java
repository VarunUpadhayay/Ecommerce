package com.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Product;
import com.eccomerce.entities.Review;
import com.eccomerce.exception.NotFound;
import com.eccomerce.repository.CustomerRepository;
import com.eccomerce.repository.ReviewRepository;
import com.eccomerce.service.ReviewService;
@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired 
	ReviewRepository reviewRepository;
	
	@Override
	public void addReview(Review review) {
		// TODO Auto-generated method stub
			try {
		 reviewRepository.save(review);
			}
			catch(Exception ex)
			{
				throw new IllegalArgumentException(ex.getMessage());
			}
	}

	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}

	@Override
	public Review findById(int reviewId) {
		// TODO Auto-generated method stub
		Review review=reviewRepository.findById(reviewId).orElse(null);
		if(review==null)
		{
			throw new NotFound("No review exists with given Id "+ reviewId);
		}
		return review;
	}

	@Override
	public List<Review> findByCustomer(Customer customer) {
		return reviewRepository.findByCustomer(customer);
	}

	@Override
	public List<Review> findByProduct(Product product) {
		// TODO Auto-generated method stub
		return reviewRepository.findByProduct(product);
	}

	@Override
	public void update(Review review) {
		// TODO Auto-generated method stub
		try {
			 reviewRepository.save(review);
				}
				catch(Exception ex)
				{
					throw new IllegalArgumentException(ex.getMessage());
				}
	}

}
