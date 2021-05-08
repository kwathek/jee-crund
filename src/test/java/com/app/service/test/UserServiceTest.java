package com.app.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import com.app.test.util.DataObjectFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.app.dto.User;
import com.app.entity.UserEntity;
import com.app.mapper.UserMapper;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import com.app.service.impl.UserServiceImpl;

/**
 * Test {@link UserServiceImpl}
 * 
 * @author Seetharama Krishna
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private UserMapper userMapper;
	
	@Before
	public void setUp() {
		userService = new UserServiceImpl();
		ReflectionTestUtils.setField(userService, "userRepository", userRepository);
		ReflectionTestUtils.setField(userService, "userMapper", userMapper);
	}
	
	/**
	 * Tests {@link UserServiceImpl#findAll()}
	 */
	@Test
	public void testFindAll() {
		DataObjectFactory factory = new DataObjectFactory();
		when(userRepository.findAll()).thenReturn(factory.createUserEntityList());
		when(userMapper.mapEntityListToDtoList(factory.createUserEntityList())).thenReturn(factory.createUserList());
		List<User> testUsers = userService.findAll();
		assertNotNull(testUsers);
		assertEquals(factory.createUserEntityList().size(), testUsers.size());
	}
	
	/**
	 * Tests {@link UserServiceImpl#getRepository()}
	 */
	@Test
	public void testGetRepository() {
		assertEquals(userService.getRepository(), userRepository);
	}
	
	/**
	 * Tests {@link UserServiceImpl#saveOrUpdate(User)}
	 */
	@Test
	public void testSaveOrUpdate() {
		DataObjectFactory factory = new DataObjectFactory();
		User newUser = factory.createNewUser();
		User savedUser = factory.createSavedUser();
		UserEntity newUserEntity = factory.createNewUserEntity();
		UserEntity savedUserEntity = factory.createSavedUserEntity();
		when(userRepository.save(userMapper.mapDtoToEntity(newUser))).thenReturn(newUserEntity);
		when(userMapper.mapEntityToDto(savedUserEntity)).thenReturn(savedUser);
		assertEquals(savedUser, userService.saveOrUpdate(newUser));
	}

}
