package com.app.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.app.dto.Customer;
import com.app.dto.Order;
import com.app.service.OrderService;

/**
 * Order backed bean
 * This object is with custome scope <tt>view</tt> to match with the {@link ViewScoped} in JSF
 * 
 * @author Seetharama Krishna
 *
 */
@Controller
@Scope("view")
public class OrderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7629488293840729328L;
	
	private Order order;
	private List<Order> existingOrders;
	
	
	@Autowired
	private transient OrderService orderService;
	
	/**
	 * Initialise the properties with default values.
	 */
	@PostConstruct
	public void init() {
		Customer customer = getCustomerFromSession();
		System.out.println("========================> get customer : "+customer);
		if (customer == null) {
			System.out.println("========================> get products empty");
			existingOrders = new ArrayList<>();
		} else {
			System.out.println("========================> get products");
			existingOrders = orderService.getAllCustomerOrders(customer.getId());			
		}

		order  = new Order();
	}
	

	/**
	 * Get the logged in customer details from the session
	 * @return
	 */
	private Customer getCustomerFromSession() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		if (context != null) {
			HttpSession session = (HttpSession) context.getSession(false);
			return (Customer) session.getAttribute(Customer.class.getSimpleName());
		}
		return null;
	}
	
	/**
	 * Save or update the order information
	 * Reload the table after deleting the record
	 */
	public void saveOrUpdateOrder() {
		Customer customer = getCustomerFromSession();
		order.setCustomerId(customer.getId());
		orderService.saveOrUpdate(order);
		existingOrders = orderService.getAllCustomerOrders(customer.getId());
		order = new Order(); //Reset the order fields after saving
	}
	
	
	/**
	 * Edit order information.
	 * Populate the form with selected order to edit and then save
	 * @param order
	 */
	public void editOrder(Order order) {
		this.order = order;
	}
	
	/**
	 * Delete order information
	 * Reload the table after deleting the record
	 * @param id ID to delete the record
	 */
	public void deleteOrder(Long id) {
		orderService.delete(id);
		Customer customer = getCustomerFromSession();
		existingOrders = orderService.getAllCustomerOrders(customer.getId());
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getExistingOrders() {
		return existingOrders;
	}
	public void setExistingOrders(List<Order> existingOrders) {
		this.existingOrders = existingOrders;
	}

}
