package live.data;

import live.domain.Account;

public interface AccountRepository {

    Account getAccount(String username);
}
