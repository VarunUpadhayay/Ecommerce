package com.eccomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eccomerce.entities.Customer;
import com.eccomerce.entities.Review;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	 

}
