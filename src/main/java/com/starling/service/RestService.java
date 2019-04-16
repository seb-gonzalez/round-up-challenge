package com.starling.service;

import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.starling.beans.Accounts;
import com.starling.beans.Amount;
import com.starling.beans.SavingGoalReply;
import com.starling.beans.SavingsGoals;
import com.starling.beans.transaction.TransactionResponse;

@Component
public class RestService {

	@Value("${starling.base.url}")
	private String baseUrl;
	@Value("${starling.authtoken}")
	private String authToken;
	@Value("${user.agent.web}")
	private String userAgent;

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private Gson jsonToJava;

	public RestService() {

		jsonToJava = new Gson();
		restTemplate = new RestTemplate();
		headers = new HttpHeaders();

	}

	@PostConstruct
	public void init() {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent", userAgent);
		headers.add("Authorization", "Bearer " + authToken);
	}

	/**
	 * getTransactions()
	 * 
	 * Get all transactions objects for a particular account
	 */
	public TransactionResponse getTransactions() {

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "/v1" + "/transactions", HttpMethod.GET,
				entity, String.class);

		return jsonToJava.fromJson(responseEntity.getBody().toString(), TransactionResponse.class);

	}

	/**
	 * getAccountInfo() Fetch the account UUID
	 */
	public String getAccountInfo() {

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> accountResponse = restTemplate.exchange(baseUrl + "/v2" + "/accounts", HttpMethod.GET,
				entity, String.class);

		Accounts accounts = jsonToJava.fromJson(accountResponse.getBody().toString(), Accounts.class);

		return accounts.getAccounts().get(0).getAccountUid();

	}

	/**
	 * setSavingsGoals(SavingsGoals, String) Function that returns the UUID that
	 * identify the Goal created
	 */
	public String setSavingsGoals(SavingsGoals dreamGoal, String accountUUID) {

		HttpEntity<SavingsGoals> requestBody = new HttpEntity<>(dreamGoal, headers);
		// Send request with POST method
		ResponseEntity<String> savingsResponse = restTemplate.exchange(
				baseUrl + "/v2" + "/account/" + accountUUID + "/savings-goals", HttpMethod.PUT, requestBody,
				String.class);

		SavingGoalReply savingReply = jsonToJava.fromJson(savingsResponse.getBody().toString(), SavingGoalReply.class);

		return savingReply.getSavingsGoalUid();
	}

	/**
	 * setSavingAmount(AmountDetails, String, String) Function that set the amount
	 * of money towards our dream goal :)
	 */
	public String setSavingAmount(Amount amount, String accountUUID, String savingsGoalsUUID) {

		HttpEntity<Amount> requestAmountBody = new HttpEntity<>(amount, headers);
		// Send request with POST method
		ResponseEntity<String> amountResponse = restTemplate
				.exchange(
						baseUrl + "/v2" + "/account/" + accountUUID + "/savings-goals/" + savingsGoalsUUID
								+ "/add-money/" + UUID.randomUUID().toString(),
						HttpMethod.PUT, requestAmountBody, String.class);

		// Return the response returned by Starling bank
		return amountResponse.getBody();

	}

}
