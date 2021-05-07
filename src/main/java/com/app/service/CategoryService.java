package com.app.service;

import com.app.dto.Category;
import com.app.dto.Product;
import com.app.entity.CategoryEntity;
import com.app.entity.ProductEntity;

/**
 * User service
 * 
 * @author Seetharama Krishna
 *
 */
public interface CategoryService extends BaseService<Category, CategoryEntity> {
	
	/**
	 * Find user by user name
	 * 
	 * @param nom
	 * @return
	 */
	Product findByNom(String nom);

}
