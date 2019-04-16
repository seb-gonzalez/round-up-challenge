package com.starling.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Accounts {

	@Autowired
	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> account) {
		this.accounts = account;
	}

	@Override
	public String toString() {
		return "Accounts [account=" + accounts + "]";
	}

}
