package com.okchem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okchem.models.Category;
import com.okchem.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private  CategoryService categoryService;
	@RequestMapping(value="/list")
	public List<Category> getCategoryList(){
		List<Category> cateList = categoryService.getList();
		return  cateList;
	}
	/**
	 * 新增分类
	 * @author 困
	 * 
	 */
	@RequestMapping(value="/save")
	public String saveCategory(@Validated Category category){
		//Category category = new Category();
		category.setCateName("javatest");
		category.setParentId(0);
		category.setIsParent(1);
		category.setModule("materiel");
		System.out.println(category.getCid());
		categoryService.addCategory(category);
		return "success";
	}
}
