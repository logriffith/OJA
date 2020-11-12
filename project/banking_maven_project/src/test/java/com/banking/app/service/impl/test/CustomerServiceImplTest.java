package com.banking.app.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.service.CustomerService;
import com.banking.app.service.impl.CustomerServiceImpl;

class CustomerServiceImplTest {
	
	public static Logger log = Logger.getLogger(CustomerServiceImplTest.class);
	public static CustomerService customerService;
	
	@BeforeAll//always static
	public static void setUpCustomerService() {
		customerService = new CustomerServiceImpl();
	}
	
	@Test
	void testGetAccountId() {
		try {
			Account account = customerService.getAccount(102, 1);
			assertEquals(102, account.getAccountId());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}
	
	@Test
	void testGetAccountType() {
		try {
			Account account = customerService.getAccount(102, 1);
			assertEquals("checking", account.getAccountType());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}
	
	@Test
	void testGetAccountApprovalStatus() {
		try {
			Account account = customerService.getAccount(102, 1);
			assertTrue(account.isApprovedAccount());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}

	@Test
	void testGetAccountByIdAccountId() {
		try {
			Account account = customerService.getAccountById(101);
			assertEquals(101, account.getAccountId());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}

	@Test
	void testCustomerLogInFirstName() {
		try {
			Customer customer = customerService.customerLogIn("acereporter", "password");
			assertEquals("Lois", customer.getFirstName());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}
	
	@Test
	void testCustomerLogInLastName() {
		try {
			Customer customer = customerService.customerLogIn("acereporter", "password");
			assertEquals("Lane", customer.getLastName());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}
	
	@Test
	void testCustomerLogInCustomerId() {
		try {
			Customer customer = customerService.customerLogIn("acereporter", "password");
			assertEquals(2, customer.getCustomerId());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}

	@Test
	void testDepositInAccount() {
		try {
			customerService.depositInAccount(104, 2, 25);
			customerService.withdrawFromAccount(104, 2, 25);
			Account account = customerService.getAccount(104, 2);
			assertEquals(3525, account.getBalance());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}
	
	@Test
	void testMakeTransfer() {
		try {
			customerService.makeTransfer(106, 2, 104, 30);
			customerService.depositInAccount(106, 2, 30);
			customerService.withdrawFromAccount(104, 2, 30);
			Account transferFrom = customerService.getAccount(106, 2);
			Account transferTo = customerService.getAccount(104, 2);
			assertEquals(5000, transferFrom.getBalance());
			assertEquals(3525, transferTo.getBalance());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
	}
}
