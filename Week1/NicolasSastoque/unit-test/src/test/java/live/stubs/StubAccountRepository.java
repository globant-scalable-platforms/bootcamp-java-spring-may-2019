package live.stubs;

import live.data.AccountRepository;
import live.domain.Account;

public class StubAccountRepository implements AccountRepository {
    @Override
    public Account getAccount(String username) {
        return "Mike".equals(username)?new Account(username,"secret"):null;
    }
}
