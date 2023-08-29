package com.eccomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eccomerce.entities.Address;
import com.eccomerce.entities.Customer;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
		List<Address> findByCustomer(Customer customer);
}
