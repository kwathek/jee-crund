package com.app.entity;

import com.app.dto.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User Entity
 * @author Seetharama Krishna
 *
 */
@Entity
@Table(name = "CATEGORIES")
public class CategoryEntity extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = -1995576042438122185L;
	
	@Column(name = "NOM", length = 100)
	private String nom;
	
	@Column(name = "DESCRIPTION", length = 255)
	private String description;
	
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


}
