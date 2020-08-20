package com.capg.Assignment_Jpa.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String addressLine1;
	private String city;
	private String state;
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Address() {
		super();
	}
	public Address(String addressLine1, String city, String state) {
		super();
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
	}
	
	

}
