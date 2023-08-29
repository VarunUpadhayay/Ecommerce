package com.eccomerce.service;

import java.util.List;

import com.eccomerce.entities.Category;

public interface CategoryService {
		public void addCategory(Category category);
		public List<Category> getCategories();
		public Category findById(int categoryId);
		public void deleteById(int categoryId);
		public Category update(Category category);
}
