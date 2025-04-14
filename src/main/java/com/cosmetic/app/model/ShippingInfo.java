package com.cosmetic.app.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;

public class ShippingInfo {
	@Nonnull
	@Size(min=1, max=20)
	private String name;
	@Nonnull
	@Size(min=5, max=30)
	private String address;
	@Nonnull
	@Size(min=4, max=5)
	private String zipcode;
	@Nonnull
	@Size(min=3, max=20)
	private String country;
	@Nonnull
	@Size(min=3, max=20)
	private String city;
	@Nonnull
	@Size(min=10, max=11)
	private String phone;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ShippingInfo [name=" + name + ", address=" + address + ", zipcode=" + zipcode + ", country=" + country
				+ ", city=" + city + ", phone=" + phone + "]";
	}
}
