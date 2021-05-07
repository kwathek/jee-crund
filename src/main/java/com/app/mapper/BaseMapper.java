package com.app.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.app.dto.BaseDTO;
import com.app.entity.BaseEntity;

/**
 * <p>
 * 		Base mapper consists the methods for mapping the Entity to DTO and vice versa.
 * 		Provide default methods for Mapping lists.
 * </p>
 * 
 * @author Seetharama Krishna
 *
 * @param <D>
 * @param <E>
 */
public interface BaseMapper<D extends BaseDTO, E extends BaseEntity> {
	
	/**
	 * Map Entity to DTO
	 * 
	 * @param entity
	 * @return
	 */
	D mapEntityToDto(E entity);
	
	/**
	 * Map DTO to Entity
	 * 
	 * @param dto
	 * @return
	 */
	E mapDtoToEntity(D dto);
	
	
	/**
	 * Map Entity list to DTO list
	 * @param entities {@link List} of entities for mapping
	 * @return {@link List} of DTOs after mapping
	 */
	default List<D> mapEntityListToDtoList(List<E> entities) {
		if (entities == null) {
			return Collections.emptyList();
		}
		List<D> dtos = new ArrayList<>(entities.size());
		entities.forEach(e -> dtos.add(mapEntityToDto(e)));
		return dtos;
	}
	
	/**
	 * Map DTO list to entity list
	 * @param dtos {@link List} of DTOs for Mapping
	 * @return {@link List} of entities after mapping
	 */
	default List<E> mapDtoListToEntityList(List<D> dtos) {
		if (dtos == null) {
			return Collections.emptyList();
		}
		List<E> entities = new ArrayList<>(dtos.size());
		dtos.forEach(d -> entities.add(mapDtoToEntity(d)));
		return entities;
	}
	
	/**
	 * Maps base properties such as <tt>id</tt> and <tt>version</tt>
	 * This should be called in map methods of every mapper those inherited from basemapper
	 * @param dto
	 * @param entity
	 */
	default void baseMappingDtoToEntity(BaseDTO dto, BaseEntity entity) {
		entity.setId(dto.getId());
		entity.setVersion(dto.getVersion());
	}
	
	/**
	 * Maps base properties such as <tt>id</tt> and <tt>version</tt>
	 * This should be called in map methods of every mapper those inherited from basemapper
	 * @param dto
	 * @param entity
	 */
	default void baseMappingEntityToDto(BaseDTO dto, BaseEntity entity) {
		dto.setId(entity.getId());
		dto.setVersion(entity.getVersion());
	}

}
