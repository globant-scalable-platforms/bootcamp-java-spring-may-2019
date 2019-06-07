package davidAcuna.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import davidAcuna.domain.Account;

@Repository
public class CustomAccountRepository implements AccountRepository {
	
	@Autowired
	DataSource dataSource;

    public Account getAccount(String username) {
        return dataSource.retrieveUserInformation(username);
    }
}