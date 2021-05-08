package com.app.dto;

/**
 * User information
 *
 */
public class User extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3386940874217135939L;
	
	private String userName;
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
		User u = (User) o;
		return u.getUserName() != null && this.getUserName() != null 
				&& u.getUserName().equals(this.getUserName());
	}
	
	/**
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = 31;
		hashCode = hashCode + this.getUserName().hashCode() * 17;
		return hashCode;
	}
	

}
