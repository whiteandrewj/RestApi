package com.aca.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
public class Customer {
	
	@XmlElement
	private String customerId;
	
	@XmlElement
	private String companyName;
	
	@XmlElement
	private String city;
	
	@XmlElement
	private String country;
	
	public void setCustomerId(String customerID) {
		this.customerId = customerID;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	@Override
	public String toString() {
		StringBuffer value = new StringBuffer();
		value.append("Customer ID: ");
		value.append(customerId);
		value.append("\n");
		return value.toString();
	}
}