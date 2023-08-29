package com.eccomerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private int productId;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@Column(nullable = false)
	private int categoryId;

	@NotBlank(message = "Brand is mandatory")
	private String brand;

	private String[] imgUrl;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private int quantity;

	@NotBlank(message = "Description is mandatory")
	@Size(min = 10, max = 500, message = "Description should be between 10 and 500 characters")
	private String description;

	@OneToMany(mappedBy = "product", cascade = { CascadeType.ALL })
	@JsonManagedReference(value = "product-reviews")
	private List<Review> reviews;

	@OneToMany(mappedBy = "product", cascade = { CascadeType.ALL })
	@JsonIgnoreProperties("product")
	@JsonManagedReference(value = "product-order")
	private List<Cart> orders = new ArrayList<>();

		
		public Product() {
			
		}
		
		
		public Product(int productId, String name, int categoryId, String brand, double price, int quantity,
				String description, String[] imgUrl, List<Review> reviews,List<Cart> orders) {
			super();
			this.productId = productId;
			this.name = name;
			this.categoryId = categoryId;
			this.brand = brand;
			this.price = price;
			this.quantity = quantity;
			this.description = description;
			this.imgUrl = imgUrl;
			this.reviews = reviews;
			this.orders=orders;
		}
		public Product(String name, int categoryId, String brand, double price, int quantity, String description,
				String[] imgUrl, List<Review> reviews,List<Cart> orders) {
			super();
			this.name = name;
			this.categoryId = categoryId;
			this.brand = brand;
			this.price = price;
			this.quantity = quantity;
			this.description = description;
			this.imgUrl = imgUrl;
			this.reviews = reviews;
			this.orders=orders;
		}
		
		
		public List<Cart> getOrders() {
			return orders;
		}
		public void setOrders(List<Cart> orders) {
			this.orders = orders;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String[] getImgUrl() {
			return imgUrl;
		}
		public void setImgUrl(String[] imgUrl) {
			this.imgUrl = imgUrl;
		}
		public List<Review> getReviews() {
			return reviews;
		}
		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}
		 
}
