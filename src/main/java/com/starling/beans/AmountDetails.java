package com.starling.beans;

public class AmountDetails {

	private String currency;
	private double minorUnits;

	public AmountDetails(String currency, double minorUnits) {
		super();
		this.currency = currency;
		this.minorUnits = minorUnits;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getMinorUnits() {
		return minorUnits;
	}

	public void setMinorUnits(int minorUnits) {
		this.minorUnits = minorUnits;
	}

}