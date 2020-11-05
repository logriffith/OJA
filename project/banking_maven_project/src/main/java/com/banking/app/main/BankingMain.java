package com.banking.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankingMain {
	
	public static Logger log = Logger.getLogger(BankingMain.class);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		log.info("----------Welcome to Lew's Banking App----------");
		int option = 0;
		do {
			log.info("\n");
			log.info("Please choose from the following menu:");
			log.info("======================================");
			log.info("(1) New Customer?");
			log.info("(2) Customer Log-in");
			log.info("(3) Employee Log-in");
			log.info("(4) Exit");
			log.info("======================================");
			log.info("Please be sure to enter an appropriate number between 1 and 4.\n");
			try{
				option = Integer.parseInt(scanner.nextLine());
				if (option>4 || option<1) {
					log.info("Out of range");
				}
				
			} catch (NumberFormatException e) {
				log.debug(e);
				log.info("Your choice is invalid.");
			}
			switch(option) {
			case 1:
				log.debug("In new customer");;
				System.out.println("This option is under construction");
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
				int customer_Menu = 0;
				do {
					log.info("\n");
					log.info("Please choose from the following menu:");
					log.info("======================================");
					log.info("(1) Would you like to open a new account?");
					log.info("(2) Open an existing account?");
					log.info("(3) Exit");
					log.info("======================================");
					log.info("Please be sure to enter an appropriate number between 1 and 3.\n");
					try{
						customer_Menu = Integer.parseInt(scanner.nextLine());
						if (option>3 || option<1) {
							log.info("Out of range");
						}
						
					} catch (NumberFormatException e) {
						log.debug(e);
						log.info("Your choice is invalid.");
					}
				}while(customer_Menu != 3);
				break;
			case 3:
				log.debug("In case 3");;
				System.out.println("This option is under construction");
				break;
			case 4:
				log.info("Thank you for banking with us. Have a great day!");
				break;
			default:
				log.info("Please choose one of the four options.");
				break;
			}
			
		}while(option != 4);
		scanner.close();
	}

}
