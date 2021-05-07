package com.app.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import com.app.dto.Customer;
import com.app.dto.User;
import com.app.service.CustomerService;
import com.app.service.UserService;

/**
 * Customer backed bean
 * 
 * @author Seetharama Krishna
 *
 */
@Controller
@RequestScope
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9015686401377185804L;
	
	private Customer customer;
	private String rawPassword;
	
	@Autowired
	private transient CustomerService customerService;
	
	@Autowired
	private transient UserService userService;
	
	/**
	 * Initialise the properties with default values
	 */
	@PostConstruct
	public void init() {
		customer = new Customer();
	}
	
	/**
	 * Register new customer
	 * Create a user login to the registered customer
	 * Uses {@link BCryptPasswordEncoder} to encode the password
	 * 
	 */
	public void registerCustomer() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		customerService.saveOrUpdate(customer);
		
		User user = new User();
		user.setUserName(customer.getEmail());
		user.setPassword(encoder.encode(rawPassword));
		userService.saveOrUpdate(user);
		
		//Add messages to display
		FacesMessage message = new FacesMessage("Registration Success", "Registration Success. Please Sign in to post orders");
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		customer = new Customer(); //Reset the customer fields after registration
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}


}
