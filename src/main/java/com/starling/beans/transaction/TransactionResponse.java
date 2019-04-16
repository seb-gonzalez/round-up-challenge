package com.starling.beans.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse {

	private Transactions _embedded;

	public Transactions get_embedded() {
		return _embedded;
	}

	public void set_embedded(Transactions _embedded) {
		this._embedded = _embedded;
	}

	@Override
	public String toString() {
		return "TransactionResponse [_embedded=" + _embedded + "]";
	}

}
