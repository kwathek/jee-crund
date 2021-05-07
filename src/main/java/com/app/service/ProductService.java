package com.app.service;

import com.app.dto.Product;
import com.app.entity.ProductEntity;

/**
 * User service
 * 
 * @author Seetharama Krishna
 *
 */
public interface ProductService extends BaseService<Product, ProductEntity> {
	
	/**
	 * Find user by user name
	 * 
	 * @param nom
	 * @return
	 */
	Product findByNom(String nom);

}
