package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.User;
import com.app.mapper.UserMapper;
import com.app.repository.UserRepository;
import com.app.service.UserService;

/**
 *
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserRepository getRepository() {
		return userRepository;
	}

	@Override
	public UserMapper getMapper() {
		return userMapper;
	}

	/**
	 * @see UserService#findByUserName(String)
	 */
	@Transactional
	@Override
	public User findByUserName(String userName) {
		return userMapper.mapEntityToDto(userRepository.findByUserName(userName));
	}

}
