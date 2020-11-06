package com.banking.app.model;

public class Account {
	
	private int accountId;
	private String accountType;
	private double balance;
	private boolean approvedAccount;
	
	public Account() {
		
	}

	public Account(int accountId, String accountType, double balance, boolean approvedAccount) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
		this.approvedAccount = approvedAccount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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

	public boolean isApprovedAccount() {
		return approvedAccount;
	}

	public void setApprovedAccount(boolean approvedAccount) {
		this.approvedAccount = approvedAccount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance
				+ ", approvedAccount=" + approvedAccount + "]";
	}
	
}
