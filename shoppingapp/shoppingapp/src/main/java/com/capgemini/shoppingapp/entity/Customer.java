package com.capgemini.shoppingapp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	private int CustomerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	private String customerPassword;
	private Address customerAddress;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String customerFirstName, String customerLastName, String customerEmail,
			String customerPassword, Address customerAddress) {
		super();
		CustomerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerSecondName() {
		return customerLastName;
	}

	public void setCustomerSecondName(String customerSecondName) {
		this.customerLastName = customerSecondName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", customerFirstName=" + customerFirstName
				+ ", customerSecondName=" + customerLastName + ", customerEmail=" + customerEmail
				+ ", customerPassword=" + customerPassword + ", customerAddress=" + customerAddress + "]";
	}
}
