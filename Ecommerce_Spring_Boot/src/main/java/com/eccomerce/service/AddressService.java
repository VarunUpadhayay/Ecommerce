package com.eccomerce.service;

import java.util.List;

import com.eccomerce.entities.Address;
import com.eccomerce.entities.Customer;

public interface AddressService {

	void createNewAddress(Address address);

	List<Address> retrieveAddressList();

	List<Address> findByCustomer(Customer customer);

	Address findById(int addressId);

	void deleteById(Address address);

}
