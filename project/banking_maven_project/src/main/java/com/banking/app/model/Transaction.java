package com.banking.app.model;

import java.util.Date;

public class Transaction {
	
	private int transactionId;
	private int accountId;
	private String transactionType;
	private double transactionAmount;
	private Date date;
	
	public Transaction() {
		
	}
	
	public Transaction(int transactionId, int accountId, String transactionType, double transactionAmount, Date date) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.date = date;
	}
	
	public Transaction(int accountId, String transactionType, double transactionAmount, Date date) {
		super();
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.date = date;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", transactionType="
				+ transactionType + ", transactionAmount=" + transactionAmount + ", date=" + date + "]";
	}
	
}
