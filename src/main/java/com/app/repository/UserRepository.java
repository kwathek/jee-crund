package com.app.repository;

import org.springframework.stereotype.Repository;

import com.app.entity.UserEntity;

/**
 * repository for user
 *
 *
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {

	/**
	 * Find the user by user name
	 * 
	 * @param userName
	 * @return
	 */
	UserEntity findByUserName(String userName);

}
