package com.eccomerce.service;

import java.util.List;

import com.eccomerce.entities.Customer;

public interface CustomerService {

	void register(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);
	
	void update(Customer customer);
	Customer deleteById(Customer customer);

}
