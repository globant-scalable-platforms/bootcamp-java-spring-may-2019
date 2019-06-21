package springbootcamp.unittest.live.business;

import springbootcamp.unittest.live.data.AccountRepository;
import springbootcamp.unittest.live.domain.Account;

public class AuthenticatorImpl implements Authenticator{
    private AccountRepository accountRepository;

    public AuthenticatorImpl(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean authenticate(final String username, final String password){
        final Account account = accountRepository.getAccount(username);
        return account.getPassword().equals(password);
    }
}
