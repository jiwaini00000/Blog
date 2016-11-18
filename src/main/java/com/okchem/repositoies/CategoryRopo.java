package com.okchem.repositoies;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okchem.models.Category;

public interface CategoryRopo extends JpaRepository<Category, Long> {
	List<Category> findAllByOrderByCidAsc();
}
