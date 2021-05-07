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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
public class ProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7629488293840729328L;
	
	private Product product;
	private List<Product> existingProducts;


	@Autowired
	private transient ProductService productService;

	
	/**
	 * Initialise the properties with default values.
	 */
	@PostConstruct
	public void init() {
		Customer customer = getCustomerFromSession();
		System.out.println("========================> get customer : "+customer);
		if (customer == null) {
			System.out.println("========================> get products empty");
			existingProducts = new ArrayList<>();

		} else {
			System.out.println("========================> get products");

			existingProducts = productService.findAll();
			System.out.println(existingProducts);
		}
		product  = new Product();
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
	public void saveOrUpdateProduct() {
		Customer customer = getCustomerFromSession();
		//order.setCustomerId(customer.getId());
		productService.saveOrUpdate(product);
		existingProducts = productService.findAll();
		product = new Product(); //Reset the order fields after saving
	}
	
	
	/**
	 * Edit order information.
	 * Populate the form with selected order to edit and then save
	 * @param product
	 */
	public void editProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * Delete order information
	 * Reload the table after deleting the record
	 * @param id ID to delete the record
	 */
	public void deleteProduct(Long id) {
		productService.delete(id);
		Customer customer = getCustomerFromSession();
		existingProducts = productService.findAll();
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Product> getExistingProducts() {
		return existingProducts;
	}
	public void setExistingProducts(List<Product> existingProducts) {
		this.existingProducts = existingProducts;
	}

}
