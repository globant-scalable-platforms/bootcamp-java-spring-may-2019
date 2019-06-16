package springbootcamp.unittest.kata.data;

import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;

import java.util.List;

public class AccountRepositoryImpl implements AccountRepository{
    private List<Account> accounts;

    public AccountRepositoryImpl(List<Account> accounts){
        this.accounts = accounts;
    }

    @Override
    public Account findAccountByUsernameAndType(String username, AccountType accountType) {
        for (Account cur : accounts)
            if (cur.getUsername().equals(username) && cur.getAccountType().equals(accountType))
                return cur;
        return null;
    }


    @Override
    public Account updateAccount(Account account) {
        return new Account(account.getUsername(), account.getBalance(), account.getAccountType());
    }
}
