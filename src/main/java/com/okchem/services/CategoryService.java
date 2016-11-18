package com.okchem.services;

import java.util.List;

import com.okchem.models.Category;

public interface CategoryService {
	List<Category> getList();
	
	/**
	 * 新增
	 * */
	void addCategory(Category category);
}
