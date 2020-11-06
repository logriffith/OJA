package com.banking.app.dao;

import com.banking.app.model.Account;
import com.banking.app.model.Customer;

public interface CustomerDAO {
	
	public boolean isUsernameCorrect(String username);
	public boolean isPasswordCorrect(String password);
	public int getCustomerId(String username, String password);
	public double viewAccountBalancebyId(int accountId);
	public int withdrawByAccountId(int accountId);
	public int depositByAccountId(int accountId);
	public int makeTransfer(int fromAccountId, int toAccountId);
	public int newAccount(Account account);
	public int newCustomer(Customer customer);
	
}
