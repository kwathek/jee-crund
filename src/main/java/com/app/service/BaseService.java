package com.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.dto.BaseDTO;
import com.app.entity.BaseEntity;
import com.app.mapper.BaseMapper;
import com.app.repository.BaseRepository;

/**
 * base service implemented by all components in service layer
 * this consists methods require from CRUD operations
 *
 *
 * @param <D> object that extends BaseDTO
 */
public interface BaseService <D extends BaseDTO, E extends BaseEntity> {



	/**
	 * get repository of the service component
	 * @return
	 */
	BaseRepository<E, Long> getRepository();
	
	/**
	 * Get mapper of the service component
	 * @return
	 */
	BaseMapper<D, E> getMapper();
	
	/**
	 * save or update the data
	 * map the DTO to entity before save or update
	 * @param d
	 * @return saved DTO
	 */
	@Transactional
	default D saveOrUpdate(D d) {
		E e = getRepository().save(getMapper().mapDtoToEntity(d));
		return getMapper().mapEntityToDto(e);
	}
	
	/**
	 * get all entities in the data store.
	 * maps the entities to DTOs before returning
	 * 
	 * @return {@link List} of DTOs
	 * @see BaseMapper
	 */
	@Transactional(readOnly = true)
	default List<D> findAll() {
		return getMapper().mapEntityListToDtoList(getRepository().findAll());
	}
	
	/**
	 * get the DTO from data store by the give <tt>id</tt>
	 * 
	 * @param id
	 * @return dto of given id
	 */
	@Transactional(readOnly = true)
	default D findById(Long id) {
		return getMapper().mapEntityToDto(getRepository().findOne(id));
	}
	
	/**
	 * deletes an entity by give <tt>id</tt>
	 * 
	 * @param id of the entity
	 */
	@Transactional
	default void delete(Long id) {
		getRepository().delete(id);
	}
}
