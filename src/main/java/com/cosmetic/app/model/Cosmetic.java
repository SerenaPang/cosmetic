package com.cosmetic.app.model;

import java.math.BigDecimal;

public class Cosmetic {
	private long id;
	private String name;
	private String description;
	private String brand;
	private BigDecimal price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cosmetic [id=" + id + ", name=" + name + ", description=" + description + ", brand=" + brand
				+ ", price=" + price + "]";
	}
}
