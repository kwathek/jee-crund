package com.app.service.impl;

import com.app.dto.Order;
import com.app.dto.Product;
import com.app.entity.OrderEntity;
import com.app.entity.ProductEntity;
import com.app.mapper.BaseMapper;
import com.app.mapper.OrderMapper;
import com.app.mapper.ProductMapper;
import com.app.repository.BaseRepository;
import com.app.repository.OrderRepository;
import com.app.repository.ProductRepository;
import com.app.service.OrderService;
import com.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @author Seetharama Krishna
 *
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public BaseRepository<ProductEntity, Long> getRepository() {
		return productRepository;
	}

	@Override
	public BaseMapper<Product, ProductEntity> getMapper() {
		return productMapper;
	}

	@Override
	public Product findByNom(String nom) {
		return null;
	}

	/**
	 * @see OrderService#getAllCustomerOrders(Long)
	 */
	/*@Transactional
	@Override
	public List<Order> getAllCustomerOrders(Long customerId) {
		return orderMapper.mapEntityListToDtoList(orderRepository.findByCustomerId(customerId));
	}*/

}
