package com.app.dto;

import java.io.Serializable;

/**
 * <p>
 * 		Base object for all DTOs, contains the common fields across the application
 * </p>
 * @author Seetharama Krishna
 *
 */
public class BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2874185747345003887L;
	
	/**
	 * ID field from the database
	 */
	private Long id;
	/**
	 * Version from the database.
	 */
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
	
	

}
