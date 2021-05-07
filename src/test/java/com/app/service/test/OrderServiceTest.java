package com.app.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.app.dto.Order;
import com.app.entity.OrderEntity;
import com.app.mapper.OrderMapper;
import com.app.repository.OrderRepository;
import com.app.service.OrderService;
import com.app.service.impl.OrderServiceImpl;
import com.app.test.util.DataObjectFactory;

/**
 * Tests {@link OrderServiceImpl}
 * 
 * @author Seetharama Krishna
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
	
	private OrderService orderService;
	
	@Mock
	private OrderMapper orderMapper;
	
	@Mock
	private OrderRepository orderRepository;
	
	@Before
	public void setUp() {
		orderService = new OrderServiceImpl();
		ReflectionTestUtils.setField(orderService, "orderMapper", orderMapper);
		ReflectionTestUtils.setField(orderService, "orderRepository", orderRepository);
	}
 	
	/**
	 * Tests {@link OrderServiceImpl#getAllCustomerOrders(Long)}
	 */
	@Test
	public void testGetAllCustomerOrders() {
		DataObjectFactory factory = new DataObjectFactory();
		List<Order> orders = factory.createOrderList();
		List<OrderEntity> orderEntites = factory.createOrderEntityList();
		Long customerId = 1L;
		when(orderRepository.findByCustomerId(customerId)).thenReturn(orderEntites);
		when(orderMapper.mapEntityListToDtoList(orderEntites)).thenReturn(orders);
		assertEquals(orders.size(), orderService.getAllCustomerOrders(customerId).size());
	}

}
