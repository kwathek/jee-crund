package com.app.dto;

import java.math.BigDecimal;

/**
 * Order Information
 * 
 * @author Seetharama Krishna
 *
 */
public class Order extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 991106556119726501L;
	
	private String name;
	private String description;
	private BigDecimal value;
	private Long customerId;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	

}
