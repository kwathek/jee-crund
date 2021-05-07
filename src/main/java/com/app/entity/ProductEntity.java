package com.app.entity;

import javax.persistence.*;

/**
 * User Entity
 * @author Seetharama Krishna
 *
 */
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1995576042438122185L;
	
	@Column(name = "NOM", length = 100)
	private String nom;
	
	@Column(name = "DESCRIPTION", length = 255)
	private String description;

	@Column(name = "QUANTITY", length = 100)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private CategoryEntity category;

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
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
		ProductEntity u = (ProductEntity) o;
		return u.getNom() != null ;
	}

}
