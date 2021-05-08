package com.app.service.impl;

import com.app.dto.Category;
import com.app.dto.Product;
import com.app.entity.CategoryEntity;
import com.app.mapper.BaseMapper;
import com.app.mapper.CategoryMapper;
import com.app.repository.BaseRepository;
import com.app.repository.CategoryRepository;
import com.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public BaseRepository<CategoryEntity, Long> getRepository() {
		return categoryRepository;
	}

	@Override
	public BaseMapper<Category, CategoryEntity> getMapper() {
		return categoryMapper;
	}

	@Override
	public Product findByNom(String nom) {
		return null;
	}

}
