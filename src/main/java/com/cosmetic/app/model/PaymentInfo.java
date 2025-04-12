package com.cosmetic.app.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;

public class PaymentInfo {
	@Nonnull
	@Size(min=2, max=30)
	private String cardNumber;
	
	@Nonnull
	@Size(min=3, max=4)
	private String cvc;
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	
	@Override
	public String toString() {
		return "PaymentInfo [cardNumber=" + cardNumber + ", CVC=" + cvc + "]";
	}	
}
