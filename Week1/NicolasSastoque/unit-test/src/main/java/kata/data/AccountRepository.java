package kata.data;

import kata.domain.Account;
import kata.domain.AccountType;

public interface AccountRepository {
    Account findAccountByUsernameAndType(String username, AccountType accountType);
    Account updateAccount(Account account);
}
