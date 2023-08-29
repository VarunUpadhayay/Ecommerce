package com.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccomerce.entities.Customer;
import com.eccomerce.exception.NotFound;
import com.eccomerce.repository.CustomerRepository;
import com.eccomerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void register(Customer customer) {
		try {
			customerRepository.save(customer);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex.getMessage());

		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findById(customerId).orElse(null);
		if(customer==null)
		{
			throw new NotFound("No customer exists with given Id "+ customerId);
		}
		return customer;
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		try {
			customerRepository.save(customer);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex.getMessage());

		}
	}

	@Override
	public Customer deleteById(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);
		return customer;
	}

}
