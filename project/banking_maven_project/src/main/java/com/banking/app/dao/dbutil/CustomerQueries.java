package com.banking.app.dao.dbutil;

public class CustomerQueries {
	
	public static final String GET_ALL_ACCOUNTS_BY_CUSTOMERID = "select all_accounts.account_id, account_type, balance, approved"
			+ "from bank.all_accounts inner join bank.customer_accounts on all_accounts.account_id = customer_accounts.account_id"
			+ "where customer_id = ?";
	
	public static final String GET_ACCOUNT_BY_ACCOUNTID_AND_CUSTOMERID="select all_accounts.account_id, account_type, balance, approved "
			+ "from bank.all_accounts inner join bank.customer_accounts on all_accounts.account_id = customer_accounts.account_id"
			+ " where customer_id = ? and all_accounts.account_id = ?";
	
	public static final String GET_CUSTOMERID = "select customer_id from bank.customers where username = ? and customer_password = ?";

	
}

