package com.app.test.util;

import java.util.ArrayList;
import java.util.List;

import com.app.dto.Product;
import com.app.entity.ProductEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.dto.Customer;
import com.app.dto.User;
import com.app.entity.CustomerEntity;
import com.app.entity.UserEntity;

/**
 * Factory to create objects for test data
 * This removes the object creation code from the test methods.
 * 
 * @author Seetharama Krishna
 *
 */
public class DataObjectFactory {
	
	/**
	 * Create data object for new user
	 * 
	 * @return
	 */
	public User createNewUser() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User newUser = new User();
		newUser.setUserName("testuser");
		newUser.setPassword(encoder.encode("pass1234"));
		return newUser;
	}
	/**
	 * Create user object as a saved user along with <tt>id</tt> and <tt>version</tt>
	 * 
	 * @return {@link User} object
	 */
	public User createSavedUser() {
		User newUser = createNewUser();
		User savedUser = new User();
		savedUser.setId(1L);
		savedUser.setVersion(0L);
		savedUser.setUserName(newUser.getUserName());
		savedUser.setPassword(newUser.getPassword());
		return savedUser;
	}
	
	/**
	 * Create {@link UserEntity} 
	 * 
	 * @return {@link UserEntity}
	 */
	public UserEntity createSavedUserEntity() {
		User newUser = createNewUser();
		UserEntity savedUserEntity = new UserEntity();
		savedUserEntity.setId(1L);
		savedUserEntity.setVersion(0L);
		savedUserEntity.setUserName(newUser.getUserName());
		savedUserEntity.setPassword(newUser.getPassword());
		return savedUserEntity;
	}
	
	/**
	 * Create {@link Customer} as saved customer
	 * @return {@link Customer}
	 */
	public Customer createSavedCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setVersion(0L);
		customer.setAddress("testAddress");
		customer.setEmail("test@test.com");
		customer.setName("Test");
		return customer;
	}
	
	/**
	 * Create {@link CustomerEntity} as saved customer
	 * @return {@link CustomerEntity}
	 */
	public CustomerEntity createSavedCustomerEntity() {
		CustomerEntity customer = new CustomerEntity();
		customer.setId(1L);
		customer.setVersion(0L);
		customer.setAddress("testAddress");
		customer.setEmail("test@test.com");
		customer.setName("Test");
		return customer;
	}
	
	/**
	 * Create {@link List} of {@link UserEntity}
	 * @return {@link List}
	 */
	public List<UserEntity> createUserEntityList() {
		List<UserEntity> users = new ArrayList<>();
		users.add(createSavedUserEntity());
		users.add(createSavedUserEntity());
		return users;
	}
	
	/**
	 * Create {@link List} of {@link User}
	 * @return {@link List}
	 */
	public List<User> createUserList() {
		List<User> users = new ArrayList<>();
		users.add(createSavedUser());
		users.add(createSavedUser());
		return users;
	}
	
	/**
	 * Create new user entity without id and version
	 * 
	 * @return
	 */
	public UserEntity createNewUserEntity() {
		User newUser = createNewUser();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(newUser.getUserName());
		userEntity.setPassword(newUser.getPassword());
		return userEntity;
	}
	
	/**
	 * Create {@link List} of {@link Product}
	 * 
	 * @return {@link List}
	 */
	public List<Product> createOrderList() {
		List<Product> orders = new ArrayList<>();
		orders.add(new Product());
		orders.add(new Product());
		return orders;
	}
	
	/**
	 * Create {@link List} of {@link ProductEntity}
	 * 
	 * @return {@link List}
	 */
	public List<ProductEntity> createOrderEntityList() {
		List<ProductEntity> orders = new ArrayList<>();
		orders.add(new ProductEntity());
		orders.add(new ProductEntity());
		return orders;
	}

}
