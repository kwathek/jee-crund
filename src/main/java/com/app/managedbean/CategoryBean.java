package com.app.managedbean;

import com.app.dto.Category;
import com.app.dto.Customer;
import com.app.dto.Product;
import com.app.service.CategoryService;
import com.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Order backed bean
 * This object is with custome scope <tt>view</tt> to match with the {@link ViewScoped} in JSF
 * 
 * @author Seetharama Krishna
 *
 */
@Controller
@Scope("view")
public class CategoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7629488293840729328L;
	

	private Category selectedCategory;
	private List<Category> existingCategories;
	private Category category;
	private List<Category> categories;
	
	
	@Autowired
	private transient CategoryService categoryService;
	
	/**
	 * Initialise the properties with default values.
	 */
	@PostConstruct
	public void init() {
		Customer customer = getCustomerFromSession();
		System.out.println("========================> get customer : "+customer);
		if (customer == null) {
			System.out.println("========================> get products empty");
			existingCategories = new ArrayList<>();
		} else {
			System.out.println("========================> get products");
			existingCategories = categoryService.findAll();
			System.out.println(existingCategories);
		}
		category  = new Category();
		categories = new ArrayList<>(categoryService.findAll());
	}
	

	/**
	 * Get the logged in customer details from the session
	 * @return
	 */
	private Customer getCustomerFromSession() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		System.out.println("========================> get FacesContext.getCurrentInstance() : "+FacesContext.getCurrentInstance());
		System.out.println("========================> get context : "+context);
		if (context != null) {
			HttpSession session = (HttpSession) context.getSession(false);
			System.out.println("========================> get session : "+session);
			System.out.println("========================> get session.getAttribute(Customer.class.getSimpleName()) : "+session.getAttribute(Customer.class.getSimpleName()));
			return (Customer) session.getAttribute(Customer.class.getSimpleName());
		}
		return null;
	}
	
	/**
	 * Save or update the order information
	 * Reload the table after deleting the record
	 */
	public void saveOrUpdateCategory() {
		Customer customer = getCustomerFromSession();
		//order.setCustomerId(customer.getId());
		categoryService.saveOrUpdate(category);
		existingCategories = categoryService.findAll();
		category = new Category(); //Reset the order fields after saving
	}
	
	
	/**
	 * Edit order information.
	 * Populate the form with selected order to edit and then save
	 * @param category
	 */
	public void editCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * Delete order information
	 * Reload the table after deleting the record
	 * @param id ID to delete the record
	 */
	public void deleteCategory(Long id) {
		categoryService.delete(id);
		Customer customer = getCustomerFromSession();
		existingCategories = categoryService.findAll();
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Category getSelectedCategory() {
		return selectedCategory;
	}
	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
	public List<Category> getExistingCategories() {
		return existingCategories;
	}
	public void setExistingCategories(List<Category> existingCategories) {
		this.existingCategories = existingCategories;
	}
	public List<Category> getCategories() {
		return categories;
	}

}
