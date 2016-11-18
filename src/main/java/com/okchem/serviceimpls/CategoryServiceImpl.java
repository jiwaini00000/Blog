package com.okchem.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.okchem.models.Category;
import com.okchem.repositoies.CategoryRopo;
import com.okchem.services.CategoryService;

@Component("CategoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired(required=true)
	private CategoryRopo categoryRopo;
	@Override
	public List<Category> getList() {
		return this.categoryRopo.findAllByOrderByCidAsc();
	}
	@Override
	public void addCategory(Category category){
		this.categoryRopo.save(category);
	}

}
