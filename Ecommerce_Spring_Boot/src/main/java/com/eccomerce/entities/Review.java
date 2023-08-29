package com.eccomerce.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Review implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private int reviewId;
	
	@ManyToOne
	@JoinColumn(name = "productId_fk")
	@JsonBackReference(value="product-reviews")
	@NotNull(message = "Product is required")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "customerId_fk")
	@JsonBackReference(value="customer-reviews")
	@NotNull(message = "Customer is required")
	private Customer customer;
	
	@Column(nullable = false)
	@NotBlank(message = "Comment is required")
	@Size(max = 255, message = "Comment must be less than or equal to 255 characters")
	private String comment;
	
	public int getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Review() {
		
	}
	
	public Review(int reviewId, Product product, Customer customer, String comment) {
		super();
		this.reviewId = reviewId;
		this.product = product;
		this.customer = customer;
		this.comment = comment;
	}
	
	public Review(Product product, Customer customer, String comment) {
		super();
		this.product = product;
		this.customer = customer;
		this.comment = comment;
	}
}
