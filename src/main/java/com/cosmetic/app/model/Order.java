package com.cosmetic.app.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
	private long id;
	private List<Cosmetic> cosmeticsInCart;
	private BigDecimal totalPrice;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Cosmetic> getCosmeticsInCart() {
		return cosmeticsInCart;
	}
	public void setCosmeticsInCart(List<Cosmetic> cosmeticsInCart) {
		this.cosmeticsInCart = cosmeticsInCart;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", cosmeticsInCart=" + cosmeticsInCart + ", totalPrice=" + totalPrice + "]";
	}
}