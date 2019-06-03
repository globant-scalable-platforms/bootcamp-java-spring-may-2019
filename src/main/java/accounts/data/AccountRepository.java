package accounts.data;

import accounts.domain.Account;
import accounts.domain.AccountType;

public interface AccountRepository {
    Account findAccountByUsernameAndAccountType(String username, AccountType accountType);
    Account updateAccount(Account account);
    Account getAccount(String username);
}
