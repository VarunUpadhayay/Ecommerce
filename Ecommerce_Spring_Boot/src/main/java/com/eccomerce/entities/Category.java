package com.eccomerce.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private int categoryId;


	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String name;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(int categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {

	}
}
