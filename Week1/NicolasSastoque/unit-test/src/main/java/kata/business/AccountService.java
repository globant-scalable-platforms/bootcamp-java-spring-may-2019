package kata.business;

import kata.domain.Account;
import kata.domain.AccountType;
import kata.domain.TransferResponse;

import javax.security.auth.login.AccountException;

public interface AccountService {
    Account retrieveAccount(String username, AccountType accountType);
    TransferResponse transferMoney(Account currentAccount, Account savingAccount, final int amount) throws AccountException;
}
