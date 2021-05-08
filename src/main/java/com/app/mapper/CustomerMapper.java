package com.app.mapper;

import org.springframework.stereotype.Component;

import com.app.dto.Customer;
import com.app.entity.CustomerEntity;

/**
 * mapper for customer
 *
 *
 */
@Component
public class CustomerMapper implements BaseMapper<Customer, CustomerEntity> {

	/**
	 * @see BaseMapper#mapEntityToDto(com.app.entity.BaseEntity)
	 */
	@Override
	public Customer mapEntityToDto(CustomerEntity entity) {
		if (entity == null) {
			return null;
		}
		Customer customer = new Customer();
		baseMappingEntityToDto(customer, entity);
		customer.setAddress(entity.getAddress());
		customer.setName(entity.getName());
		customer.setEmail(entity.getEmail());
		return customer;
	}

	/**
	 * @see BaseMapper#mapDtoToEntity(com.app.dto.BaseDTO)
	 */
	@Override
	public CustomerEntity mapDtoToEntity(Customer dto) {
		CustomerEntity customerEntity = new CustomerEntity();
		baseMappingDtoToEntity(dto, customerEntity);
		customerEntity.setName(dto.getName());
		customerEntity.setAddress(dto.getAddress());
		customerEntity.setEmail(dto.getEmail());
		return customerEntity;
	}

}
