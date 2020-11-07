package com.banking.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.app.exception.BusinessException;
import com.banking.app.main.util.BankingMenus;
import com.banking.app.model.Account;
import com.banking.app.service.impl.CustomerServiceImpl;


public class BankingMain {
	
	public static Logger log = Logger.getLogger(BankingMain.class);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String username = null;
		String password = null;
		log.info("----------Welcome to Lew's Banking App----------");
		int option = 0;
		//Main Menu
		log.debug("In main menu");
		do {
			BankingMenus.mainMenu();
			try{
				option = Integer.parseInt(scanner.nextLine());
				if (option<=4 && option>=1) {
					switch(option) {
					case 1:
						log.debug("In new customer");
						System.out.println("This option is under construction");//remove this later
						break;
					case 2:
						log.debug("In customer log in");
						boolean acceptedLogin = false;
						try {
						log.info("Hello valued customer!");
						log.info("Please enter your username:");
						String inputtedUsername = scanner.nextLine();
						log.info("Please enter your password:");
						String inputtedPassword = scanner.nextLine();
						//code here for service layer
							CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
							customerServiceImpl.customerLogIn(inputtedUsername, inputtedPassword);
							acceptedLogin = true;
							username = customerServiceImpl.getUsername(customerServiceImpl.getCustomerId(inputtedUsername, inputtedPassword));
							password = customerServiceImpl.getPassword(customerServiceImpl.getCustomerId(inputtedUsername, inputtedPassword));
							log.debug(username);
							log.debug(password);
						} catch(BusinessException e) {
							log.info(e.getMessage());
						} catch(Exception e) {
							log.info("I'm sorry your login was unsuccessful. Please try again later.");
						}
						if(acceptedLogin == true) {
							int customer_Menu = 0;
							log.debug("In customer menu");
							do {
								//Customer Menu
								BankingMenus.customerMenu();
								try {
									customer_Menu = Integer.parseInt(scanner.nextLine());
									if (customer_Menu<=3 && customer_Menu>=1) {
										log.debug("In customer menu.");
										switch(customer_Menu) {
										case 1:
											log.debug("In new account");
											System.out.println("This option is under construction.");//remove this later
											break;
										case 2:
											int customerAccountsMenu = 0;
											log.debug("In existing accounts");
											do {
												//Customer Accounts Menu
												BankingMenus.customerAccountsMenu();
												try {
													customerAccountsMenu = Integer.parseInt(scanner.nextLine());
													if (customerAccountsMenu<=6 && customerAccountsMenu>=1) {
														switch(customerAccountsMenu) {
														case 1:
															log.debug("in View Account Balance");
															log.info("What is the account number?");
															int accountId = Integer.parseInt(scanner.nextLine());
															log.info("Okay, let me get that account for you.");
															CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
//															Account account = customerServiceImpl.getAccount(accountId, username, password);
//															log.debug(account);
//															log.info("The balance for account "+ accountId+ " is "+account.getBalance());
															break;
														case 2:
															log.debug("in View Account Transactions");
															System.out.println("This option is under construction.");//remove this later
															break;
														case 3:
															log.debug("in Make a Withdrawal");
															System.out.println("This option is under construction.");//remove this later
															break;
														case 4:
															log.debug("in Make a Deposit");
															System.out.println("This option is under construction.");//remove this later
															break;
														case 5:
															log.debug("in Transfer Funds");
															System.out.println("This option is under construction.");//remove this later
															break;
														case 6:
															log.info("Returning to Customer Menu...");
															break;
														default:
															log.info("Please choose one of the six options");
															break;
														}
													} else {
														log.info("Out of range. Please choose one of the six options.");
													}
												}catch (NumberFormatException e) {
													log.debug(e);
													log.info("Your choice is invalid. Please choose one of the three options.");
												} catch (Exception e) {
													log.debug(e);
													log.info("Your choice is not an acceptable input.");
												}
											}while(customerAccountsMenu != 6);
											break;
										case 3:
											log.debug("You are logged out.");
											break;
										default:
											log.info("Please choose one of the three options");
											break;
										}
									} else {
										log.info("Out of range. Please choose one of the three options.");
									}
								}catch (NumberFormatException e) {
									log.debug(e);
									log.info("Your choice is invalid. Please choose one of the three options.");
								} catch (Exception e) {
									log.debug(e);
									log.info("Your choice is not an acceptable input.");
								}
							}while(customer_Menu != 3);
						}
							break;
					case 3:
						log.debug("In employee log in");;
						System.out.println("This option is under construction");//remove this later
						break;
					case 4:
						log.info("Thank you for banking with us. Have a great day!");
						break;
					default:
						log.info("Please choose one of the four options.");
						break;
					}
				}else {
					log.info("Out of range. Please choose one of the four options.");
				}
				
			} catch (NumberFormatException e) {
				log.debug(e);
				log.info("Your choice is invalid. Please choose one of the four options.");
			} catch (Exception e) {
				log.debug(e);
				log.info("Your choice is not an acceptable input.");
			}
		}while(option != 4);
		scanner.close();
	}

}
