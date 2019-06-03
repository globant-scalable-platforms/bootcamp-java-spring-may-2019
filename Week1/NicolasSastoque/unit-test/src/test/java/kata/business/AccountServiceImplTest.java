package kata.business;

import kata.data.AccountRepository;
import kata.domain.Account;
import kata.domain.AccountType;
import kata.domain.TransferResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.security.auth.login.AccountException;

import static org.mockito.Matchers.booleanThat;
import static org.mockito.Mockito.*;

public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    private AccountServiceImpl accountService;

    private Account currentAccount;
    private Account savingAccount;
    private int amount;
    private TransferResponse transferResponse;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        accountService = new AccountServiceImpl(accountRepository);

        currentAccount = new Account("current",0, AccountType.CURRENT);
        savingAccount = new Account("saving",0, AccountType.SAVING);

        when(accountRepository.findAccountByUsernameAndType("current", AccountType.CURRENT)).thenReturn(currentAccount);
        when(accountRepository.findAccountByUsernameAndType("saving", AccountType.SAVING)).thenReturn(savingAccount);
        when(accountRepository.updateAccount(currentAccount)).thenReturn(currentAccount);
        when(accountRepository.updateAccount(savingAccount)).thenReturn(savingAccount);
    }

    @Test
    public void shouldPass() throws AccountException {

        currentAccount.setBalance(3000);
        savingAccount.setBalance(1500);

        try{
            accountService.transferMoney(currentAccount, savingAccount, 2500);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(500, currentAccount.getBalance());
        Assert.assertEquals(4000, savingAccount.getBalance());
    }

    @Test
    public void shouldFail() throws AccountException {

        currentAccount.setBalance(100);
        savingAccount.setBalance(200);

        try{
            accountService.transferMoney(currentAccount, savingAccount, 400);
        }
        catch (Exception e){
            Assert.assertEquals("insufficient funds", e.getMessage());
        }
    }
}
