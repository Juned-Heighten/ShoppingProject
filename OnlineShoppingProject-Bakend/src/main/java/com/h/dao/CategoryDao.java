package com.h.dao;

import java.util.List;

import com.h.dto.Category;

public interface CategoryDao {
	
	public List<Category> list();
	
	public Category get(int id);
	public boolean add(Category c);

}
