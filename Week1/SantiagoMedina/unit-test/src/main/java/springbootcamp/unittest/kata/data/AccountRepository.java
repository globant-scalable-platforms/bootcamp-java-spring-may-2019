package springbootcamp.unittest.kata.data;

import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;

public interface AccountRepository {
    Account findAccountByUsernameAndType(String username, AccountType accountType);
    Account updateAccount(Account account);
}
