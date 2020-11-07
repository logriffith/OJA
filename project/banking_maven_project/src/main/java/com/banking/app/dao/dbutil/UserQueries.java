package com.banking.app.dao.dbutil;

public class UserQueries {
	
	public static final String GET_USERNAME_BY_CUSTOMER_ID = "select username from bank.customers where customer_id = ?";
	
	public static final String GET_PASSWORD_BY_CUSTOMER_ID = "select customer_password from bank.customers where customer_id = ?";
}
