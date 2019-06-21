package springbootcamp.unittest.live.data;

import springbootcamp.unittest.live.domain.Account;

public interface AccountRepository {

    Account getAccount(String username);
}
