package com.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eccomerce.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
