package com.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.eccomerce.entities.Product;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository< Product, Integer>{

}
