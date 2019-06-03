package springbootcamp.unittest.kata.business;

import javax.security.auth.login.AccountException;

import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;
import springbootcamp.unittest.kata.domain.TransferResponse;

public interface AccountService {
    Account retrieveAccount(String username, AccountType accountType);
    TransferResponse transferMoney(Account currentAccount, Account savingAccount, final int amount) throws AccountException, springbootcamp.unittest.kata.exception.AccountException;
}
