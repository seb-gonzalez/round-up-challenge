package com.starling.beans;

import org.springframework.beans.factory.annotation.Autowired;


public class SavingsGoals {

	private String name;
	private String currency;
	private String base64EncodedPhoto;
	@Autowired
	private Target target;

	public SavingsGoals(String name, String currency, Target target, String base64EncodedPhoto) {
		super();
		this.name = name;
		this.currency = currency;
		this.base64EncodedPhoto = base64EncodedPhoto;
		this.target = target;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBase64EncodedPhoto() {
		return base64EncodedPhoto;
	}

	public void setBase64EncodedPhoto(String base64EncodedPhoto) {
		this.base64EncodedPhoto = base64EncodedPhoto;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "SavingsGoals [name=" + name + ", currency=" + currency + ", base64EncodedPhoto=" + base64EncodedPhoto
				+ ", target=" + target + "]";
	}

	
}
