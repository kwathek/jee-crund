package com.app.service;

import java.util.List;

import com.app.dto.Order;
import com.app.entity.OrderEntity;

/**
 * Order Service
 * 
 * @author Seetharama Krishna
 *
 */
public interface OrderService extends BaseService<Order, OrderEntity> {
	
	/**
	 * Get the orders by Customer ID
	 * 
	 * @param customerId
	 * @return
	 */
	List<Order> getAllCustomerOrders(Long customerId);

}
