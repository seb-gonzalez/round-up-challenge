package com.starling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starling.beans.Amount;
import com.starling.beans.AmountDetails;
import com.starling.beans.SavingsGoals;
import com.starling.beans.Target;
import com.starling.beans.transaction.TransactionResponse;
import com.starling.service.RestService;
import com.starling.service.TransactionService;

@RestController
public class RoundUpController {

	private final static String SAVINGS_GOAL = "Porsche";
	private final static String CURRENCY = "GBP";
	private final static int TARGET = 5000;
	
	@Autowired
	RestService restHandler;
	@Autowired
	TransactionService transactionService;
	
	
	

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/roundup")
	public String executeRoundUp() {
		
		//Amount to put down into our savings goals
		double savings;
		String accountUUID;
		String savingsGoalsUUID;		
		String jsonResponse;

		TransactionResponse transactions = restHandler.getTransactions();

		transactionService.setTransactions(transactions.get_embedded());

		//0 Get amount to be saved
		savings = transactionService.getAmountSaved();
		System.out.println("0 Amount to be saved towards a goal: " + savings);
		
		//1 Get account information
		accountUUID = restHandler.getAccountInfo();
		System.out.println("1 Account information UUID: " + accountUUID);
		//2 Create Savings Goal
		savingsGoalsUUID = restHandler.setSavingsGoals(new SavingsGoals(SAVINGS_GOAL, CURRENCY, new Target(CURRENCY, TARGET), "String"), accountUUID);
		System.out.println("2 Savings goals created: " + SAVINGS_GOAL + " Target: "+ TARGET + "- UUID : " + savingsGoalsUUID);
		//3 ADD MONEY INTO SAVINGS GOAL
		jsonResponse = restHandler.setSavingAmount(new Amount(new AmountDetails(CURRENCY, savings )), accountUUID, savingsGoalsUUID);
		System.out.println("3 Savings added into savings goal account.");
				
		
		System.out.println(jsonResponse);
		
		return jsonResponse;

	}

}
