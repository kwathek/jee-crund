package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User Entity
 *
 */
@Entity
@Table(name = "USERS")
public class UserEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1995576042438122185L;
	
	@Column(name = "USER_NAME", length = 100)
	private String userName;
	
	@Column(name = "PASSWORD", length = 255)
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		UserEntity u = (UserEntity) o;
		return u.getUserName() != null && this.getUserName() != null 
				&& u.getUserName().equals(this.getUserName());
	}
	
	

}
