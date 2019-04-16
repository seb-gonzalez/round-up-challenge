package com.starling.beans;

import org.springframework.stereotype.Component;


public class Account {
	
	private String accountUid;
	private String defaultCategory;
	private String currency;
	private String createdAt;
	
	
	public String getAccountUid() {
		return accountUid;
	}
	public void setAccountUid(String accountUid) {
		this.accountUid = accountUid;
	}
	public String getDefaultCategory() {
		return defaultCategory;
	}
	public void setDefaultCategory(String defaultCategory) {
		this.defaultCategory = defaultCategory;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	@Override
	public String toString() {
		return "AccountResponse [accountUid=" + accountUid + ", defaultCategory=" + defaultCategory + ", currency="
				+ currency + ", createdAt=" + createdAt + "]";
	}
	

}
