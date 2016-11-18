package com.okchem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.okchem.models.Category;
import com.okchem.services.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {
	@Autowired
	private CategoryService categoryService;
	@Test
	public void addCategoryTest(){
		Category category = new Category();
		//category.setCateName("");
		category.setParentId(0);
		category.setIsParent(1);
		category.setModule("materiel");
		categoryService.addCategory(category);
	}
}
