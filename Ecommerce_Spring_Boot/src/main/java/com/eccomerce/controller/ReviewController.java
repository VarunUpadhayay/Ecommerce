package com.eccomerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Product;
import com.eccomerce.entities.Review;
import com.eccomerce.service.CustomerService;
import com.eccomerce.service.ProductService;
import com.eccomerce.service.ReviewService;

@Controller
@RequestMapping("reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	@Autowired
	CustomerService customerService;
	@Autowired
	ProductService productService;
	@PostMapping("new")
	public ResponseEntity<Review> addNewReview(@Valid @RequestBody Review review)
	{
		reviewService.addReview(review);
		return ResponseEntity.status(HttpStatus.CREATED).body(review);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Review>> getReviewsList()
	{
		List<Review> reviewsList=reviewService.getAllReviews();
		if(reviewsList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(reviewsList);
	}
	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> findById(@PathVariable int reviewId)
	{
		Review review=reviewService.findById(reviewId);
//		if(review==null)
//		{
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
		return ResponseEntity.ok(review);
	}
	@GetMapping("/user/{customerId}")
	public ResponseEntity<List<Review>> findByCustomer(@PathVariable int customerId)
	{
		Customer customer=customerService.getCustomerById(customerId);
		if(customer==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		List<Review> reviewList=reviewService.findByCustomer(customer);
		if(reviewList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(reviewList);
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<List<Review>> findByProduct(@PathVariable int productId)
	{
		Product product=productService.getProduct(productId);
		if(product==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		List<Review> reviewList=reviewService.findByProduct(product);
		if(reviewList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(reviewList);
	}
	@PutMapping("/{reviewId}")
	public ResponseEntity<Review> updateById(@Valid @RequestBody Review review, @PathVariable int reviewId)
	{
		Review review1=reviewService.findById(reviewId);
		review.setReviewId(reviewId);
		reviewService.update(review);
		return ResponseEntity.ok(review);
	}
}
