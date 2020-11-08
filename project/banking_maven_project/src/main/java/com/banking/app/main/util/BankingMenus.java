package com.banking.app.main.util;

import org.apache.log4j.Logger;

import com.banking.app.main.BankingMain;

public class BankingMenus {
	
	public static Logger log = Logger.getLogger(BankingMenus.class);
	
	public static void mainMenu() {
		log.info("\n");
		log.info("Main Menu:");
		log.info("======================================");
		log.info("(1) New Customer?");
		log.info("(2) Customer Log-in");
		log.info("(3) Employee Log-in");
		log.info("(4) Exit");
		log.info("======================================");
		log.info("Please be sure to enter an appropriate number between 1 and 4.\n");
	}
	
	public static void customerMenu() {
		log.info("\n");
		log.info("Customer Menu:");
		log.info("======================================");
		log.info("(1) Would You Like to Open a New Account?");
		log.info("(2) Open an Existing Account?");
		log.info("(3) Log Out");
		log.info("======================================");
		log.info("Please be sure to enter an appropriate number between 1 and 3.\n");
	}
	
	public static void customerAccountsMenu() {
		log.info("\n");
		log.info("Customer Accounts Menu:");
		log.info("======================================");
		log.info("(1) View All Accounts");
		log.info("(2) View Account Balance");
		log.info("(3) View Account Transactions");
		log.info("(4) Make a Withdrawal");
		log.info("(5) Make a Deposit");
		log.info("(6) Transfer Funds");
		log.info("(7) Back to Customer Menu");
		log.info("======================================");
		log.info("Please be sure to enter an appropriate number between 1 and 7.\n");
	}
}
