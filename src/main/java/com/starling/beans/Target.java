package com.starling.beans;

import org.springframework.stereotype.Component;


public class Target {

	private String currency;
	private int minorUnits;

	public Target(String currency, int minorUnits) {
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

	public int getMinorUnits() {
		return minorUnits;
	}

	public void setMinorUnits(int minorUnits) {
		this.minorUnits = minorUnits;
	}

	@Override
	public String toString() {
		return "Target [currency=" + currency + ", minorUnits=" + minorUnits + "]";
	}

}
