package com.banking.app.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.app.dao.impl.CustomerDAOImpl;
import com.banking.app.exception.BusinessException;
import com.banking.app.main.util.BankingMenus;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;
import com.banking.app.service.impl.CustomerServiceImpl;


public class BankingMain {
	
	public static Logger log = Logger.getLogger(BankingMain.class);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Customer customer = null;
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		int maxTransactionId = 0;
		int maxAccountId = 0;
		int option = 0;
		log.info("----------Welcome to the Griffith Community Bank App----------");
		log.debug("In main menu");
		do {
			//Main Menu
			BankingMenus.mainMenu();
			try{
				option = Integer.parseInt(scanner.nextLine());
				if (option<=4 && option>=1) {
					switch(option) {
					case 1:
						try {
							log.debug("In new customer");
							log.info("We will first need to get information from you.");
							log.info("\nPlease create a username and password for your account. Please limit your username and password to 20 and 32 characters, respectively.");
							log.info("Please enter your username.");
							String username = scanner.nextLine();
							log.info("Please enter your password");
							String password = scanner.nextLine();
							log.info("Please confirm your password.");
							String confirmPassword = scanner.nextLine();
							if(password.equals(confirmPassword)) {
								log.info("\nWhat is your first and last name? Please make sure that they are each at most 20 characters in length.");
								log.info("Please enter your first name:");
								String firstName = scanner.nextLine();
								log.info("Please enter your last name:");
								String lastName = scanner.nextLine();
								log.info("\nShall I approve this customer's user account? [y/n]");
								String approved = scanner.nextLine();
								if(approved.matches("[yY]{1}")) {
									boolean approvedAccount = true;
									customerServiceImpl.newCustomer(username, password, firstName, lastName, approvedAccount);
								}else if(approved.matches("[nN]{1}")) {
									log.info("We will not approve your account at this time.");
								}else {
									log.info("Input could not be understood.");
								}
							}else {
								log.info("Your passwords do not match. ");
							}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						} catch(Exception e) {
							log.debug(e);
							log.info("I'm sorry something went wrong with your registration. Please try again later.");
						}
						break;
					case 2:
						log.debug("In customer log in");
						boolean acceptedLogin = false;
						try {
							log.info("Hello valued customer!");
							log.info("Please enter your username:");
							String username = scanner.nextLine();
							log.info("Please enter your password:");
							String password = scanner.nextLine();
							customer = customerServiceImpl.customerLogIn(username, password);
							acceptedLogin = true;
						} catch(BusinessException e) {
							log.info(e.getMessage());
						} catch(Exception e) {
							log.debug(e);
							log.info("I'm sorry your login was unsuccessful. Please try again later.");
						}
						if(acceptedLogin == true) {
							log.info("Hello "+customer.getFirstName()+" "+customer.getLastName());;
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
											try {
												log.debug("In new account");
												log.info("Customer: I would like to open a new account please.");
												log.info("Employee: Okay, will we authorize this new account? [y/n]");
												String approved = scanner.nextLine();
												boolean approvedAccount = false;
												if(approved.matches("[yY]{1}")) {
													approvedAccount = true;
													log.info("Employee: Okay, the new account is authorized.");
													log.info("Employee: How much would you like to put into the account?");
													log.info("Employee: Please note that the minimum starting balance for all new accounts is $500.");
													double startingBalance= Double.parseDouble(scanner.nextLine());
													if(startingBalance >= 500) {
														List<Integer> accountlist = customerServiceImpl.getAllAccountIds();
														if(accountlist.size() > 0) {
															maxAccountId = accountlist.get(accountlist.size()-1);
														}else {
															maxAccountId = 100;
														}
														log.info("Employee: Okay, what would you like to name the account (savings, checking, etc.)?");
														String accountType = scanner.nextLine();
														Account newAccount = new Account((maxAccountId + 1), accountType, startingBalance, approvedAccount);
														customerServiceImpl.newAccount(newAccount, customer.getCustomerId(), (maxAccountId + 1));
														log.info("Customer: Thank you.");
														log.info("Employee: You're welcome.");
													}else {
														log.info("Employee: I am sorry. You must put at least $500 into a new account.");
													}
												}else if(approved.matches("[nN]{1}")) {
													log.info("Employee: I am sorry. We will not authorize a new account for you at this time.");
												}else {
													log.info("Customer: I don't understand what you are trying to tell me.");
												}
											}catch (NumberFormatException e) {
												log.debug(e);
												log.info("I'm sorry, the account number must be a positive integer.");
											}catch(BusinessException e) {
												log.info(e.getMessage());
											}catch(Exception e) {
												log.debug(e);
												log.info("I'm sorry, there was a problem accessing your account.");
											}
											break;
										case 2:
											int customerAccountsMenu = 0;
											log.debug("In existing accounts");
											do {
												//Customer Accounts Menu
												BankingMenus.customerAccountsMenu();
												try {
													customerAccountsMenu = Integer.parseInt(scanner.nextLine());
													if (customerAccountsMenu<=7 && customerAccountsMenu>=1) {
														switch(customerAccountsMenu) {
														case 1:
															try {
																log.debug("in View All Accounts");
																List<Account> allCustomerAccounts = customerServiceImpl.getAllAccounts(customer.getCustomerId());
																if(allCustomerAccounts.size() != 0) {
																	log.info("Okay the following acounts are in your name:\n");
																	log.info("Account Number      Account Type");
																	for (Account a : allCustomerAccounts) {
																		log.info(a.getAccountId()+"            "+a.getAccountType());//change output format later
																	}
																}
															}catch(BusinessException e){
																log.info(e.getMessage());
															}catch(Exception e){
																log.debug(e);
																log.info("I'm sorry, there was an problem accessing your accounts.");
															}
															break;
														case 2:
															try {
																log.debug("in View Account Balance");
																log.info("What is the account number?");
																int accountId = Integer.parseInt(scanner.nextLine());
																Account account = customerServiceImpl.getAccount(accountId, customer.getCustomerId());
																log.info("Okay, "+customer.getFirstName()+" let me get that account for you.");
																log.debug(account);
																log.info("The balance for account "+ accountId+ " is $"+account.getBalance());
															}catch (NumberFormatException e) {
																log.debug(e);
																log.info("I'm sorry, the account number must be a positive integer.");
															}catch(BusinessException e) {
																log.info(e.getMessage());
															}catch(Exception e) {
																log.debug(e);
																log.info("I'm sorry, there was a problem accessing your account.");
															}
															break;
														case 3:
															try {
																log.debug("in View Account Transactions");
																log.info("What is the account number?");
																int accountId = Integer.parseInt(scanner.nextLine());
																List<Transaction> transactionlist = customerServiceImpl.getAllTransactionsForAccount(accountId, customer.getCustomerId());
																SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a z");
																if(transactionlist.size() != 0) {
																	log.info("Okay, here are the transactions for that account:\n");
																	log.info("Account Number     Type of Transaction       Amount         Date and Time");
																	for (Transaction t:transactionlist) {																		
																		log.info(t.getAccountId()+"         "+t.getTransactionType()+"       "+t.getTransactionAmount()+"       "+sdf.format(t.getDate()));//format this later
																	}
																}
															}catch (NumberFormatException e) {
																log.debug(e);
																log.info("I'm sorry, the account number must be a positive integer.");
															}catch(BusinessException e) {
																log.info(e.getMessage());
															}catch(Exception e) {
																log.debug(e);
																log.info("I'm sorry, there was a problem accessing your account.");
															}
															break;
														case 4:
															try {
																log.debug("in Make a Withdrawal");
																log.info("What is the account number?");
																int accountId = Integer.parseInt(scanner.nextLine());
																log.info("How much money would you like to withdraw?");
																double amount = Double.parseDouble(scanner.nextLine());
																customerServiceImpl.withdrawFromAccount(accountId, customer.getCustomerId(), amount);
																List<Integer> transactionIdlist = customerServiceImpl.getAllTransactionIds();
																if(transactionIdlist.size() > 0) {
																	maxTransactionId = transactionIdlist.get(transactionIdlist.size()-1);
																}
																Date date = new Date();
																Transaction transaction = new Transaction((maxTransactionId + 1), accountId, "withdrawal", amount, date);
																customerServiceImpl.makeNewTransaction(transaction, (maxTransactionId + 1), accountId);
															}catch (NumberFormatException e) {
																log.debug(e);
																log.info("I'm sorry, the account number must be a positive integer and the amount to be withdrawn must be a positive number.");
															}catch (BusinessException e){
																log.info(e.getMessage());
															}catch (Exception e) {
																log.debug(e);
																log.info("I'm sorry, there was a problem processing your withdrawal.");
															}
															break;
														case 5:
															try {
																log.debug("in Make a Deposit");
																log.info("What is the account number?");
																int accountId = Integer.parseInt(scanner.nextLine());
																log.info("How much money would you like to deposit?");
																double amount = Double.parseDouble(scanner.nextLine());
																customerServiceImpl.depositInAccount(accountId, customer.getCustomerId(), amount);
																List<Integer> transactionIdlist = customerServiceImpl.getAllTransactionIds();
																if(transactionIdlist.size() > 0) {
																	maxTransactionId = transactionIdlist.get(transactionIdlist.size()-1);
																}
																Date date = new Date();
																Transaction transaction = new Transaction((maxTransactionId + 1), accountId, "deposit", amount, date);
																customerServiceImpl.makeNewTransaction(transaction, (maxTransactionId + 1), accountId);
															}catch (NumberFormatException e) {
																log.debug(e);
																log.info("I'm sorry, the account number must be a positive integer and the amount to be deposited must be a positive number.");
															}catch (BusinessException e) {
																log.info(e.getMessage());
															}catch (Exception e) {
																log.debug(e);
																log.info("I'm sorry, there was a problem processing your deposit.");
															}
															break;
														case 6:
															try {
																log.debug("in Transfer Funds");
																log.info("From which account?");
																int accountId = Integer.parseInt(scanner.nextLine());
																log.info("To which account?");
																int transferToAccountId = Integer.parseInt(scanner.nextLine());
																log.info("Is this your account also? [y/n]");
																String accountOwner = scanner.nextLine();
																log.info("How much much would you like to transfer?");
																double amount = Double.parseDouble(scanner.nextLine());
																if(accountOwner.matches("[yY]{1}")) {
																	//both accounts belong to the same customer
																	log.info("Are you sure that you want to make this transfer? [y/n]");
																	String response = scanner.nextLine();
																	if(response.matches("[yY]{1}")) {
																		customerServiceImpl.makeTransfer(accountId, customer.getCustomerId(), transferToAccountId, amount);
																		List<Integer> transactionIdlist = customerServiceImpl.getAllTransactionIds();
																		if(transactionIdlist.size() > 0) {
																			maxTransactionId = transactionIdlist.get(transactionIdlist.size()-1);
																		}
																		Date date = new Date();
																		Transaction transactionFrom = new Transaction((maxTransactionId + 1), accountId, "transferred out", amount, date);
																		customerServiceImpl.makeNewTransaction(transactionFrom, (maxTransactionId + 1), accountId);
																		Transaction transactionTo = new Transaction((maxTransactionId + 2), transferToAccountId, "transferred in", amount, date);
																		customerServiceImpl.makeNewTransaction(transactionTo, (maxTransactionId + 2), transferToAccountId);
																	}else if(response.matches("[nN]{1}")){
																		log.info("Okay, the transfer has been canceled.");
																	}else {
																		log.info("I'm sorry, but we cannot process the transfer unless you approve it.");
																	}
																}else if(accountOwner.matches("[nN]{1}")) {
																	//accounts belong to different customers
																	log.info("The customer owning the other account must first accept the transfer.");
																	log.info("Hello, "+customer.getFirstName()+" "+customer.getLastName()+ " would like to transfer $"+amount+" into your account.");
																	log.info("Would you like to accept the transfer? [y/n]");
																	String response = scanner.nextLine();
																	if(response.matches("[yY]{1}")) {
																		customerServiceImpl.makeTransfer(accountId, customer.getCustomerId(), transferToAccountId, amount);
																		List<Integer> transactionIdlist = customerServiceImpl.getAllTransactionIds();
																		if(transactionIdlist.size() > 0) {
																			maxTransactionId = transactionIdlist.get(transactionIdlist.size()-1);
																		}
																		Date date = new Date();
																		Transaction transactionFrom = new Transaction((maxTransactionId + 1), accountId, "transferred out", amount, date);
																		customerServiceImpl.makeNewTransaction(transactionFrom, (maxTransactionId + 1), accountId);
																		Transaction transactionTo = new Transaction((maxTransactionId + 2), transferToAccountId, "transferred in", amount, date);
																		customerServiceImpl.makeNewTransaction(transactionTo, (maxTransactionId + 2), transferToAccountId);
																	}else if(response.matches("[nN]{1}")) {
																		log.info("Okay, the funds will not be transferred to your account.");
																	}else {
																		log.info("I'm sorry, but we cannot process the transfer unless it is approved.");
																	}
																}else {
																	log.info("I'm sorry, I don't understand your answer.");
																}
															}catch (NumberFormatException e) {
																log.debug(e);
																log.info("I'm sorry, the account numbers must be positive integers, and the amount to be transferred must be a positive number.");
															}catch (BusinessException e) {
																log.info(e.getMessage());
															}catch (Exception e) {
																log.debug(e);
																log.info("I'm sorry, there was a problem processing your transfer.");
															}
															break;
														case 7:
															log.info("Returning to Customer Menu...");
															break;
														default:
															log.info("Please choose one of the seven options");
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
											}while(customerAccountsMenu != 7);
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
