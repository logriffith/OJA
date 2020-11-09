package com.banking.app.dao.dbutil;

public class CustomerQueries {
	
	public static final String GET_ALL_ACCOUNTS_BY_CUSTOMERID = "select all_accounts.account_id, account_type, balance, approved "
			+ "from bank.all_accounts inner join bank.customer_accounts on all_accounts.account_id = customer_accounts.account_id "
			+ "where customer_id = ?";
	
	public static final String GET_ACCOUNT_BY_ACCOUNTID_AND_CUSTOMERID="select account_type, balance, approved "
			+ "from bank.all_accounts inner join bank.customer_accounts on all_accounts.account_id = customer_accounts.account_id"
			+ " where customer_id = ? and all_accounts.account_id = ?";
	
	public static final String GET_ACCOUNT_BY_ACCOUNTID = "select account_type, balance, approved from bank.all_accounts where account_id = ?";
	
	public static final String GET_CUSTOMER_INFO = "select customer_id, first_name, last_name from bank.customers where username = ? and customer_password = ?";

	public static final String UPDATE_BALANCE_BY_ACCOUNTID = "update bank.all_accounts set balance = ? where account_id = ?";
	
	public static final String GET_ALL_TRANSACTIONS_FOR_ACCOUNTID = "select account_transactions.account_id,transaction_type, amount, transaction_date "
			+ "from bank.all_transactions inner join bank.account_transactions on all_transactions.transaction_id = account_transactions.transaction_id "
			+ "where account_transactions.account_id = ?";
}

