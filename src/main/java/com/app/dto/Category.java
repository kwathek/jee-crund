package com.app.dto;

/**
 * User information
 *
 *
 */
public class Category extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3386940874217135939L;

	private String nom;
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
	
	/**
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		Category u = (Category) o;
		return u.getNom() != null ;
	}

}
