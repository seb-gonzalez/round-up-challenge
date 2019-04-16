package com.starling.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starling.beans.transaction.Transaction;
import com.starling.beans.transaction.Transactions;

@Service
public class TransactionService {
	
	
	@Autowired
	private Transactions transactions;

	private List<Double> getExpenses() {
			
		List<Double> outboundMoney = new ArrayList<Double>();
		
		for(Transaction transaction : this.transactions.getTransactions()) {
			if(transaction.getDirection().equals("OUTBOUND")) {
				outboundMoney.add( Math.abs(transaction.getAmount())); 
			}
		}
		
		
		return outboundMoney;
		
	}
	
	private List<Double> processRoundUpList(List<Double> expensesList) {
		
		List<Double> roundupList = new ArrayList<Double>();
			
		if(expensesList.size() > 0) {
			for(Double expense : expensesList) {
				roundupList.add(  Math.ceil(expense) - expense );
			}
		}
		
		return roundupList;
	}
	
	public Double getAmountSaved() {
		
		Double result;
		
		result =  processRoundUpList( getExpenses() ).stream().mapToDouble(Double::doubleValue).sum();
		return roundAvoid(result, 2);
		
	}
	
	private double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
	
	
	public Transactions getTransactions() {
		return transactions;
	}
	
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}	
	
	
	

}
