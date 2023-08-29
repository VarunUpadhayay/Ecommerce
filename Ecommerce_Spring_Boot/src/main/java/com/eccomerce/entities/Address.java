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
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
	private int addressId;
	
	@NotBlank(message = "House number cannot be blank")
	private String hNo;
	
	@NotBlank(message = "City cannot be blank")
	private String city;
	
	@NotBlank(message = "Country cannot be blank")
	private String country;
	
	
	private int pinCode;
	
	@NotBlank(message = "State cannot be blank")
	private String state;
	
	@NotBlank(message = "Street cannot be blank")
	private String street;
	
	@NotNull(message = "Customer cannot be null")
	@ManyToOne
	@JoinColumn(name="customerId_fk")
	@JsonBackReference(value="customer-address")
	private Customer customer;
	
	public Address() {
		
	}
	
	public Address(int addressId, String hNo, String city, String country, int pinCode, String state, String street,
			Customer customer) {
		super();
		this.addressId = addressId;
		this.hNo = hNo;
		this.city = city;
		this.country = country;
		this.pinCode = pinCode;
		this.state = state;
		this.street = street;
		this.customer = customer;
	}
	
	public Address(String hNo, String city, String country, int pinCode, String state, String street,
			Customer customer) {
		super();
		this.hNo = hNo;
		this.city = city;
		this.country = country;
		this.pinCode = pinCode;
		this.state = state;
		this.street = street;
		this.customer = customer;
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String gethNo() {
		return hNo;
	}
	public void sethNo(String hNo) {
		this.hNo = hNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
