package com.eccomerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eccomerce.entities.Customer;
import com.eccomerce.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("new")
	public ResponseEntity<Customer> registerNewCustomer(@Valid @RequestBody Customer customer)
	{
		customerService.register(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Customer>> getCustomersList(){
		List<Customer> customerList=customerService.getAllCustomers();
		if(customerList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(customerList);
	}
	@RequestMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId)
	{
		Customer customer=customerService.getCustomerById(customerId);
		if(customer==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(customer);
		
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomerById(@Valid @RequestBody Customer customer,@PathVariable int customerId)
	{
		Customer customer1=customerService.getCustomerById(customerId);
		customer.setCustomerId(customerId);
		customerService.update(customer1);
		return ResponseEntity.ok(customer);
	}
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable int customerId)
	{
		Customer customer=customerService.getCustomerById(customerId);
		customerService.deleteById(customer);
		return ResponseEntity.ok(customer);
	}
}
