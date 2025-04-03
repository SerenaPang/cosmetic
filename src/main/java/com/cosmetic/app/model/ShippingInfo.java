package com.cosmetic.app.model;

public class ShippingInfo {
	private String name;
	private String address;
	private String zipcode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "ShppingInfo [name=" + name + ", address=" + address + ", zipcode=" + zipcode + "]";
	}
}
