package com.app.service.impl;

import com.app.dto.Product;
import com.app.entity.ProductEntity;
import com.app.mapper.BaseMapper;
import com.app.mapper.ProductMapper;
import com.app.repository.BaseRepository;
import com.app.repository.ProductRepository;
import com.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
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

}
