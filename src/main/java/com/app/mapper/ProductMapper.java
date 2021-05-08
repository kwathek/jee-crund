package com.app.mapper;

import com.app.dto.Product;
import com.app.entity.ProductEntity;
import com.app.repository.CategoryRepository;
import com.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper for order
 *
 */
@Component
public class ProductMapper implements BaseMapper<Product, ProductEntity> {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product mapEntityToDto(ProductEntity entity) {
		if (entity == null) {
			return null;
		}
		Product product = new Product();
		baseMappingEntityToDto(product, entity);
		product.setNom(entity.getNom());
		product.setDescription(entity.getDescription());
		product.setQuantity(entity.getQuantity());
		product.setCategoryId(entity.getCategory().getId());
		product.setCategory(entity.getCategory().getNom());
		return product;
	}

	@Override
	public ProductEntity mapDtoToEntity(Product dto) {
		ProductEntity entity = new ProductEntity();
		baseMappingDtoToEntity(dto, entity);
		System.out.println("dto : "+dto.getNom() + dto.getCategory() + dto.getCategoryId());
		entity.setDescription(dto.getDescription());
		entity.setNom(dto.getNom());
		entity.setQuantity(dto.getQuantity());
		entity.setCategory(categoryRepository.findOne(dto.getCategoryId()));
		return entity;
	}

}
