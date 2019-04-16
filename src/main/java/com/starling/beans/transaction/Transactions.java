package com.starling.beans.transaction;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Transactions {

	private List<Transaction> transactions;

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Transactions [transactions=" + transactions + "]";
	}

}
