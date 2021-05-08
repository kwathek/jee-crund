package com.app.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import com.app.dto.Customer;
import com.app.dto.User;
import com.app.service.CustomerService;
import com.app.service.UserService;

/**
 * user backed bean used for login form
 *
 *
 */
@Controller
@RequestScope
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8177603054184527196L;
	
	private static final Logger LOGGER = LogManager.getLogger(UserBean.class);
	
	private User user;
	
	@Autowired
	private transient UserService userService;
	
	@Autowired
	private transient CustomerService customerService;
	
	@ManagedProperty("#{facesContext}")
	private FacesContext context;
	
	public UserBean(FacesContext context) {
		this.context = context;
		user = new User();
	}
	
	/**
	 * Authenticate the user using login credentials
	 */
	public String authenticate() {
		LOGGER.debug("UserBean#authenticate -> {}", user.getUserName());
		User loggedInUser = userService.findByUserName(user.getUserName());
		if (loggedInUser != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(user.getPassword(), loggedInUser.getPassword())) {
				addLoggedInCustomerToSession();
				return "/pages/private/dashboard_products.jsf";
			} else {
				invalidLogin();
			}
		} else {
			
		}
		return "login";
	}

	
	private void invalidLogin() {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		message.setDetail("Invalid login");
		context.addMessage(null, message);
	}

	private void addLoggedInCustomerToSession() {
		Customer customer  = customerService.getCustomerByUserName(user.getUserName());
		ExternalContext extContext = this.context.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		session.setAttribute(Customer.class.getSimpleName(), customer);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
