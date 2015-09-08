package de.andrena.assertions;

public class Address {

	private final String street;
	private final int houseNumber;
	private final String zipCode;
	private final String city;

	public Address(String street, int houseNumber, String zipCode, String city) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}
}
