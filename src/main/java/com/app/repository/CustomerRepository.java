package com.app.repository;

import org.springframework.stereotype.Repository;

import com.app.entity.CustomerEntity;

/**
 * repository for customer
 * 
 * @author Seetharama Krishna
 *
 */
@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Long> {

	/**
	 * Get the customer detail by Email which is basically the user name for authentication
	 * @param userName
	 * @return
	 */
	CustomerEntity findByEmail(String userName);

}
