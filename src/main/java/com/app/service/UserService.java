package com.app.service;

import com.app.dto.User;
import com.app.entity.UserEntity;

/**
 * User service
 * 
 * @author Seetharama Krishna
 *
 */
public interface UserService extends BaseService<User, UserEntity> {
	
	/**
	 * Find user by user name
	 * 
	 * @param userName
	 * @return
	 */
	User findByUserName(String userName);

}
