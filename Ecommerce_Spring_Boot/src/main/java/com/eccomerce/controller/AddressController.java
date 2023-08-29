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

import com.eccomerce.entities.Address;
import com.eccomerce.entities.Customer;
import com.eccomerce.service.AddressService;
import com.eccomerce.service.CustomerService;

@RestController
@RequestMapping("address")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@Autowired
	CustomerService customerService;
	@PostMapping("new")
	public ResponseEntity<Address> addNewAddress(@Valid @RequestBody Address address)
	{
		addressService.createNewAddress(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(address);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Address>> getAddressList()
	{
		List<Address> addressList=addressService.retrieveAddressList();
		if(addressList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(addressList);
	}
	@GetMapping("/{addressId}")
	public ResponseEntity<Address> findById(@PathVariable int addressId)
	{
		Address address=addressService.findById(addressId);
		if(address==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(address);
	}
	
	@GetMapping("/user/{customerId}")
	public ResponseEntity<List<Address>> findByCustomer(@PathVariable int customerId)
	{
		Customer customer=customerService.getCustomerById(customerId);
		if(customer==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		List<Address> addressList=addressService.findByCustomer(customer);
		return ResponseEntity.ok(addressList);
	}
	@DeleteMapping("/user/{customerId}/{addressId}")
	public ResponseEntity<Address> deleteById(@PathVariable int customerId,@PathVariable int addressId)
	{
		Customer customer=customerService.getCustomerById(customerId);
		if(customer==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		Address address=addressService.findById(addressId);
		if(address==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		addressService.deleteById(address);
		return ResponseEntity.ok(address);
	}
	@PutMapping("/user/{customerId}/{addressId}")
	public ResponseEntity<Address> updateById(@PathVariable int customerId,@PathVariable int addressId,@Valid @RequestBody Address address)
	{
		Customer customer=customerService.getCustomerById(customerId);
		if(customer==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		Address address1=addressService.findById(addressId);
		if(address==null)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		address.setAddressId(addressId);
		addressService.createNewAddress(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(address);
	}
	
}
