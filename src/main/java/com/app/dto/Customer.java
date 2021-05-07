package com.app.dto;

/**
 * Customer information
 * 
 * @author Seetharama Krishna
 *
 */
public class Customer extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5398077190552126110L;
	
	private String name;
	private String email;
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
		Customer c = (Customer) o;
		
		return c.getEmail() != null && this.getEmail() != null 
				&& c.getEmail().equalsIgnoreCase(this.getEmail());
	}
	@Override
	public int hashCode() {
		int hashCode = 31;
		hashCode = hashCode + this.getEmail().hashCode() * 17;
		return hashCode;
	}
	@Override
	public String toString() {
		return String.format("Customer: name: %s email: %s address: %s", this.name, this.email, this.address);
	}
	
	
	
	

}
