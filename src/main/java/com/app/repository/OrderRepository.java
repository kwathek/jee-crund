package com.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.entity.OrderEntity;

/**
 * repository for order
 * 
 * @author Seetharama Krishna
 *
 */
@Repository
public interface OrderRepository extends BaseRepository<OrderEntity, Long> {

	/**
	 * Find all the orders by customer ID
	 * 
	 * @param customerId
	 * @return
	 */
	List<OrderEntity> findByCustomerId(Long customerId);

}
