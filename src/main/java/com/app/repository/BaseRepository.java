package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.BaseEntity;

/**
 * Base JPA Repository
 * 
 * @author Seetharama Krishna
 *
 * 
 * @param <E> Any Entity that extends from {@link BaseEntity}
 * @param <ID> ID of the entity of Type {@link Long}
 */
public interface BaseRepository<E extends BaseEntity, ID extends Number> extends JpaRepository<E, Long> {

}
