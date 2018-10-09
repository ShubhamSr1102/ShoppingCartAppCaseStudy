package com.capgemini.customer.entities;

public class Address {

	private String houseNumber;
	private String street;
	private String city;
	private String state;
	private int zip;
	private String country;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String houseNumber, String street, String city, String state, int zip, String country) {
		super();
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", country=" + country + "]";
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
