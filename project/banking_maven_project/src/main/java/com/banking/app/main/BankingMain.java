package com.banking.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.app.main.util.BankingMenus;


public class BankingMain {
	
	public static Logger log = Logger.getLogger(BankingMain.class);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
						log.info("Hello valued customer!");
						log.info("Please enter your username:");
						String username = scanner.nextLine();
						log.info("Please enter your password:");
						String password = scanner.nextLine();
						//username and password go to service layer
						//code here for service layer
						//make it so user cannot enter next do while loop unless they log in right
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
										log.debug("In existing accounts");
										System.out.println("This option is under construction.");//remove this later
										break;
									case 3:
										log.debug("leaving customer menu");
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
