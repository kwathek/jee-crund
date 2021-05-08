package com.app.mapper;

import com.app.dto.Category;
import com.app.dto.Product;
import com.app.entity.CategoryEntity;
import com.app.entity.ProductEntity;
import com.app.repository.CategoryRepository;
import com.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper for order
 *
 *
 */
@Component
public class CategoryMapper implements BaseMapper<Category, CategoryEntity> {
	
	@Autowired
	private CategoryRepository customerRepository;

	@Override
	public Category mapEntityToDto(CategoryEntity entity) {
		if (entity == null) {
			return null;
		}
		Category category = new Category();
		baseMappingEntityToDto(category, entity);
		category.setNom(entity.getNom());
		category.setDescription(entity.getDescription());
		return category;
	}

	@Override
	public CategoryEntity mapDtoToEntity(Category dto) {
		CategoryEntity entity = new CategoryEntity();
		baseMappingDtoToEntity(dto, entity);
		entity.setDescription(dto.getDescription());
		entity.setNom(dto.getNom());
		return entity;
	}

}
