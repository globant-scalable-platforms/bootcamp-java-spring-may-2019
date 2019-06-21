package davidAcuna.data;

import davidAcuna.domain.Account;

public interface AccountRepository {

    Account getAccount(String username);
}
