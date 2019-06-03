package bootcamp.java.spring.may;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import accounts.business.AccountServiceImpl;
import accounts.business.AuthenticatorImpl;
import accounts.data.AccountRepository;
import accounts.domain.Account;
import accounts.domain.AccountType;
import accounts.domain.TransferResponse;

import static org.mockito.Mockito.*;

import javax.security.auth.login.AccountException;

public class InsufficientFundsImpTest{

    @Mock
    private AccountRepository accountRepository;
    
    private AccountServiceImpl transferring;

    private String username;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        transferring = new AccountServiceImpl(accountRepository);
        username = "David";
        Account saving = new Account(username, 200, AccountType.SAVING);
        Account current = new Account(username, 100, AccountType.CURRENT);
        
        when(accountRepository.findAccountByUsernameAndAccountType(username, AccountType.CURRENT))
        	.thenReturn(current);
        when(accountRepository.findAccountByUsernameAndAccountType(username, AccountType.SAVING))
        	.thenReturn(saving);
    }

    @Test(expected = AccountException.class)
    public void shouldPass() throws AccountException {
    	when(transferring.transferMoney(accountRepository
			.findAccountByUsernameAndAccountType("David", AccountType.CURRENT), accountRepository.findAccountByUsernameAndAccountType("David", AccountType.SAVING), 2500))
    		.thenThrow(AccountException.class);
    }

}
