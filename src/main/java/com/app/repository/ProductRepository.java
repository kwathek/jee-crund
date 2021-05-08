package com.app.repository;

import com.app.entity.ProductEntity;
import com.app.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * repository for user
 *
 *
 */
@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, Long> {

	/**
	 * Find the user by user name
	 * 
	 * @param nom
	 * @return
	 */
	ProductEntity findByNom(String nom);

}
