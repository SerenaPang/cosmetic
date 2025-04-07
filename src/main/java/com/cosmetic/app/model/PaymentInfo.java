package com.cosmetic.app.model;

public class PaymentInfo {
	private String cardNumber;
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
