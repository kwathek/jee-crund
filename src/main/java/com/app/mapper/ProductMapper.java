package com.app.mapper;

import com.app.dto.Order;
import com.app.dto.Product;
import com.app.entity.OrderEntity;
import com.app.entity.ProductEntity;
import com.app.entity.embeddable.Amount;
import com.app.repository.CategoryRepository;
import com.app.repository.CustomerRepository;
import com.app.util.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper for order
 * 
 * @author Seetharama Krishna
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
		//order.setCustomerId(entity.getCustomer().getId());
		return product;
	}

	@Override
	public ProductEntity mapDtoToEntity(Product dto) {
		ProductEntity entity = new ProductEntity();
		baseMappingDtoToEntity(dto, entity);
		System.out.println("dto : "+dto.getNom() + dto.getCategory() + dto.getCategoryId());
		//entity.setCustomer(customerRepository.findOne(dto.getCustomerId()));
		entity.setDescription(dto.getDescription());
		entity.setNom(dto.getNom());
		entity.setQuantity(dto.getQuantity());
		entity.setCategory(categoryRepository.findOne(dto.getCategoryId()));
		//Amount amount = new Amount();
		//amount.setAmount(dto.getValue());
		//amount.setCurrencyCode(Currency.USD.name());
		//entity.setValue(amount);
		return entity;
	}

}
