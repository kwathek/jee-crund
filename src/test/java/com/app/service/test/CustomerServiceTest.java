package com.app.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.app.test.util.DataObjectFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.app.dto.Customer;
import com.app.entity.CustomerEntity;
import com.app.mapper.CustomerMapper;
import com.app.repository.CustomerRepository;
import com.app.service.CustomerService;
import com.app.service.impl.CustomerServiceImpl;

/**
 * Tests {@link CustomerServiceImpl}
 * @author Seetharama Krishna
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	
	private CustomerService customerService;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private CustomerMapper customerMapper;
	
	@Before
	public void setUp() {
		customerService = new CustomerServiceImpl();
		ReflectionTestUtils.setField(customerService, "customerRepository", customerRepository);
		ReflectionTestUtils.setField(customerService, "customerMapper", customerMapper);
	}
	
	/**
	 * Tests {@link CustomerServiceImpl#getCustomerByUserName(String)}
	 */
	@Test
	public void testGetCustomerByUserName() {
		DataObjectFactory factory = new DataObjectFactory();
		CustomerEntity customerEntity = factory.createSavedCustomerEntity();
		Customer customer = factory.createSavedCustomer();
		String userName = "test@test.com";
		when(customerMapper.mapEntityToDto(customerEntity)).thenReturn(customer);
		when(customerRepository.findByEmail(userName)).thenReturn(customerEntity);
		assertEquals(customer, customerService.getCustomerByUserName(userName));
	}

}
