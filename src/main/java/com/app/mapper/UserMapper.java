package com.app.mapper;

import org.springframework.stereotype.Component;

import com.app.dto.User;
import com.app.entity.UserEntity;

/**
 * Mapper for User
 * 
 * @author Seetharama Krishna
 *
 */
@Component
public class UserMapper implements BaseMapper<User, UserEntity> {

	@Override
	public User mapEntityToDto(UserEntity entity) {
		if (entity == null) {
			return null;
		}
		User user = new User();
		baseMappingEntityToDto(user, entity);
		user.setUserName(entity.getUserName());
		user.setPassword(entity.getPassword());
		return user;
	}

	@Override
	public UserEntity mapDtoToEntity(User dto) {
		UserEntity entity = new UserEntity();
		baseMappingDtoToEntity(dto, entity);
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		return entity;
	}

}
