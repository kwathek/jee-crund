package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.Customer;
import com.app.mapper.CustomerMapper;
import com.app.repository.CustomerRepository;
import com.app.service.CustomerService;

/**
 * Implementation of {@link CustomerService}
 * 
 * @author Seetharama Krishna
 * 
 * @see CustomerService
 *
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public CustomerRepository getRepository() {
		return customerRepository;
	}

	@Override
	public CustomerMapper getMapper() {
		return customerMapper;
	}

	/**
	 * @see CustomerService#getCustomerByUserName(String)
	 */
	@Transactional
	@Override
	public Customer getCustomerByUserName(String userName) {
		return customerMapper.mapEntityToDto(customerRepository.findByEmail(userName));
	}

}
