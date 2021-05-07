package com.app.repository;

import com.app.entity.CategoryEntity;
import com.app.entity.ProductEntity;
import org.springframework.stereotype.Repository;

/**
 * repository for user
 * 
 * @author Seetharama Krishna
 *
 */
@Repository
public interface CategoryRepository extends BaseRepository<CategoryEntity, Long> {

	/**
	 * Find the user by user name
	 * 
	 * @param nom
	 * @return
	 */
	CategoryEntity findByNom(String nom);

}
