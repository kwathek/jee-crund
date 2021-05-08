package com.app.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <p>
 * 		Customer Entity
 * </p>
 *
 */
@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5638015508343162292L;
	
	@Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "EMAIL", length = 100)
	private String email;
	@Column(name = "ADDRESS", length = 250)
	private String address;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		CustomerEntity cus = (CustomerEntity) o;
		if (cus.getId() != this.getId() || cus.getName() != cus.getName()) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 5;
		int mulitplier = 31;
		hashCode = hashCode * mulitplier + getId().hashCode();
		hashCode = hashCode * mulitplier + getName().hashCode();
		return hashCode;
	}
	
	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Id: %d; name: %s; email: %s", getId(), getName(), getEmail());
	}

}
