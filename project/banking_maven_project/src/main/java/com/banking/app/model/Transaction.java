package com.banking.app.model;

import java.util.Date;

public class Transaction {
	
	private int customerId;
	private int accountId;
	private String transactionType;
	private double transactionAmount;
	private double currentBalance;
	private Date date;
	
	public Transaction() {
		
	}

	public Transaction(int customerId, int accountId, String transactionType, double transactionAmount,
			double currentBalance, Date date) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.currentBalance = currentBalance;
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [customerId=" + customerId + ", accountId=" + accountId + ", transactionType="
				+ transactionType + ", transactionAmount=" + transactionAmount + ", currentBalance=" + currentBalance
				+ ", date=" + date + "]";
	}

	
	
}
