package com.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccomerce.entities.Address;
import com.eccomerce.entities.Customer;
import com.eccomerce.exception.NotFound;
import com.eccomerce.repository.AddressRepository;
import com.eccomerce.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public void createNewAddress(Address address) {
		// TODO Auto-generated method stub
		try {
		addressRepository.save(address);
		}
		catch(Exception ex)
		{
			throw new IllegalArgumentException(ex.getMessage());

		}
	}

	@Override
	public List<Address> retrieveAddressList() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

	@Override
	public List<Address> findByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return addressRepository.findByCustomer(customer);
	}

	@Override
	public Address findById(int addressId) {
		// TODO Auto-generated method stub
		Address address=addressRepository.findById(addressId).orElse(null);
		if(address==null)
		{
			throw new NotFound("No address exists with given id "+addressId);
		}
		return address;
	}

	@Override
	public void deleteById(Address address) {
		// TODO Auto-generated method stub
		addressRepository.delete(address);
	}

}
