package davidAcuna.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import davidAcuna.data.CustomAccountRepository;
import davidAcuna.domain.Account;

@Service
public class AuthenticatorImpl implements Authenticator{
    
//    private AccountRepository accountRepository;
    private CustomAccountRepository customAccountRepository;

    @Autowired
    public AuthenticatorImpl(final CustomAccountRepository customAccountRepository) {
        this.customAccountRepository = customAccountRepository;
    }

    
    public boolean authenticate(final String username, final String password){
        try {
            final Account account = customAccountRepository.getAccount(username);
            return account.getPassword().equals(password);
        } catch (NullPointerException e) {
            return false;
        }
    }
}
