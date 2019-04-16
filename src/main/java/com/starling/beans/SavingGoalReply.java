package com.starling.beans;

import java.util.List;

public class SavingGoalReply {

	private String savingsGoalUid;
	private boolean success;
	private List<String> errors;

	public SavingGoalReply(String savingsGoalUid, boolean success, List<String> errors) {
		super();
		this.savingsGoalUid = savingsGoalUid;
		this.success = success;
		this.errors = errors;
	}

	public String getSavingsGoalUid() {
		return savingsGoalUid;
	}

	public void setSavingsGoalUid(String savingsGoalUid) {
		this.savingsGoalUid = savingsGoalUid;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
