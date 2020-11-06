package com.banking.app.model;

import java.util.Date;

public class Account {
	
	private int accountId;
	private int customerId;
	private String accountType;
	private double balance;
	private Date date;
	private boolean approvedAccount;
	
	public Account() {
		
	}

	public Account(int accountId, int customerId, String accountType, double balance, Date date,
			boolean approvedAccount) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountType = accountType;
		this.balance = balance;
		this.date = date;
		this.approvedAccount = approvedAccount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isApprovedAccount() {
		return approvedAccount;
	}

	public void setApprovedAccount(boolean approvedAccount) {
		this.approvedAccount = approvedAccount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerId=" + customerId + ", accountType=" + accountType
				+ ", balance=" + balance + ", date=" + date + ", approvedAccount=" + approvedAccount + "]";
	}

	
}
