package com.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccomerce.entities.Category;
import com.eccomerce.exception.NotFound;
import com.eccomerce.repository.CategoryRepository;
import com.eccomerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		try {
		categoryRepository.save(category);
		}
		catch(Exception ex)
		{
			throw new IllegalArgumentException(ex.getMessage());

		}
	}
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	@Override
	public Category findById(int categoryId) {
		// TODO Auto-generated method stub
		Category category=categoryRepository.findById(categoryId).orElse(null);
		if(category==null)
		{
			throw new NotFound("No categoty exists with given Id "+ categoryId);
		}
		return category;
	}
	@Override
	public void deleteById(int categoryId) {
		Category category=categoryRepository.findById(categoryId).get();
		categoryRepository.delete(category);
		
	}
	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		try {
			categoryRepository.save(category);
			}
			catch(Exception ex)
			{
				throw new IllegalArgumentException(ex.getMessage());

			}
			return category;
	}
	

}
