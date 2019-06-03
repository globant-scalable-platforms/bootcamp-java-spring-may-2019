package com.globant.bootcamp.spring.unittest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import springbootcamp.unittest.kata.business.AccountService;
import springbootcamp.unittest.kata.business.AccountServiceImpl;
import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;
import springbootcamp.unittest.kata.domain.TransferResponse;
import springbootcamp.unittest.kata.data.AccountRepository;

import javax.security.auth.login.AccountException;

import static org.mockito.Mockito.*;

public class UnitTestApplicationTests {

	@Mock
	private AccountRepository accountRepository;
	private AccountService accountService;
	private Account current;
	private Account saving;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		accountService = new AccountServiceImpl(accountRepository);

		current = new Account("Current", 0, AccountType.CURRENT);
		saving = new Account("Saving", 0, AccountType.SAVING);

		when(accountRepository.findAccountByUsernameAndType("Current", AccountType.CURRENT)).thenReturn(current);
		when(accountRepository.findAccountByUsernameAndType("Saving", AccountType.SAVING)).thenReturn(saving);
		when(accountRepository.updateAccount(current)).thenReturn(current);
		when(accountRepository.updateAccount(saving)).thenReturn(saving);
	}

	@Test
	public void moneyBetweenAccountWithBank() throws AccountException {

		current.setBalance(3000);
		saving.setBalance(1500);

		TransferResponse response = accountService.transferMoney(current, saving, 2500);

		Assert.assertEquals(response.getCurrentAccount().getBalance(), 500);
		Assert.assertEquals(response.getSavingAccount().getBalance(), 4000);

	}

	@Test
	public void moneyBetweenAccountInsufficientFound(){

		current.setBalance(100);
		saving.setBalance(200);

		try {
			accountService.transferMoney(current, saving, 400);
		}catch (AccountException e){
			Assert.assertEquals(e.getMessage(), "insufficient funds");
		}


	}

}
