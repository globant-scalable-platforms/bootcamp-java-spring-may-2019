package accounts.business;

import javax.security.auth.login.AccountException;

import accounts.domain.Account;
import accounts.domain.AccountType;
import accounts.domain.TransferResponse;

public interface AccountService {
    Account retrieveAccount(String username, AccountType accountType);
    TransferResponse transferMoney(Account currentAccount, Account savingAccount, final int amount) throws AccountException;
}
