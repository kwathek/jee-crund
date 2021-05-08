package com.app.dto;

/**
 * User information
 *
 *
 */
public class Product extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3386940874217135939L;

	private String nom;
	private String description;
	private String category;
	private int quantity;
	private Long categoryId;

	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() { return category;}
	public void setCategory(String category) { this.category = category; }
	public int getQuantity() {return  quantity;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	/**
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		Product u = (Product) o;
		return u.getNom() != null && this.getCategory() != null;
	}

}
