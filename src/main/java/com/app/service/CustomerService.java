package com.app.service;

import com.app.dto.Customer;
import com.app.entity.CustomerEntity;

/**
 * Customer service
 *
 */
public interface CustomerService extends BaseService<Customer, CustomerEntity> {
	
	/**
	 * Get the customer by user name
	 * 
	 * @param userName
	 * @return
	 */
	Customer getCustomerByUserName(String userName);

}
