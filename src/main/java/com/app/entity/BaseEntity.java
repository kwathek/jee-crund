package com.app.entity;

import com.app.dto.Category;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * base entity for all the entities.
 * contains common fields such as <tt>id</tt> and <tt>version</tt>
 *
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2359135819039456394L;
	
	
	/**
	 * ID field for all the entities
	 * This uses TABLE id generation strategy to make compatible the MySQL and Oracle databases.
	 * 
	 * <i>Note: Using TABLE strategy may lead to concurrency problems. 
	 * Based on the database vendor, IDENTITY or SEQUENCE generator should be used.</i>
	 * 
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	/**
	 * Version field to track the version of the database row. 
	 * This is necessary for hibernate to avoid stale data errors.
	 */
	@Version
	@Column(name = "VERSION")
	private Long version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object other) {
		return (other != null && getClass() == other.getClass() && id != null)
				? id.equals(((BaseEntity) other).id)
				: (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null)
				? (getClass().hashCode() + id.hashCode())
				: super.hashCode();
	}

}
