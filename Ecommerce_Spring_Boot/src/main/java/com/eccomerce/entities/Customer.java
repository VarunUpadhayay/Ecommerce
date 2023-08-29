package com.eccomerce.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private int customerId;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Contact number should be a valid 10-digit Indian mobile number")
	private String contactNumber;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be a valid email address")
	private String email;

	@Size(min = 8, max = 32, message = "Password should be between 8 and 32 characters")
	private String password;

	@NotBlank(message = "Username is mandatory")
	private String userName;

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.ALL })
	@JsonIgnoreProperties("customer")
	@JsonManagedReference(value = "customer-address")
	private List<Address> address;

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.ALL })
	@JsonIgnoreProperties("customer")
	@JsonManagedReference(value = "customer-order")
	private List<Cart> orders;

	private String role;

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.ALL })
	@JsonManagedReference(value = "customer-reviews")
	private List<Review> reviews;
	public Customer(){
		
	}
	
	public Customer(int customerId, String name, String contactNumber, String email, String password, String userName,
			List<Address> address, List<Cart> orders, String role, List<Review> reviews) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.address = address;
		this.orders = orders;
		this.role = role;
		this.reviews = reviews;
	}
	
	
	
	
	public Customer(String name, String contactNumber, String email, String password, String userName,
			List<Address> address, List<Cart> orders, String role, List<Review> reviews) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.address = address;
		this.orders = orders;
		this.role = role;
		this.reviews = reviews;
	}




	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Cart> getOrders() {
		return orders;
	}
	public void setOrders(List<Cart> orders) {
		this.orders = orders;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
}
