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

import com.eccomerce.entities.Category;
import com.eccomerce.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@PostMapping("new")
	public ResponseEntity<Category> newCategory(@Valid @RequestBody Category category)
	{
		
//		if(result.hasErrors())
//		{
//			System.out.println("Errorbhghgfhgf");
//		return ResponseEntity.badRequest().build();
//			
//		}
		categoryService.addCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
	@GetMapping("")
	public ResponseEntity<List<Category>> getAllCategory()
	{
		List<Category> categoryList=categoryService.getCategories();
		if(categoryList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(categoryList);
	}
	@GetMapping("/{categoryId}")
	 public ResponseEntity<Category> findById(@PathVariable int categoryId)
	{
		Category category=categoryService.findById(categoryId);
		return ResponseEntity.ok(category);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<Category> updateById(@Valid @RequestBody Category category,@PathVariable int categoryId)
	{
		Category category1=categoryService.findById(categoryId);
		category.setCategoryId(categoryId);
		categoryService.update(category);
		return ResponseEntity.ok(category);
	}
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Category> deleteById(@PathVariable int categoryId)
	{
		Category category=categoryService.findById(categoryId);
		categoryService.deleteById(categoryId);
		return ResponseEntity.ok(category);
	}
}
