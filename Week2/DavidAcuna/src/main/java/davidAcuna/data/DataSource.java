package davidAcuna.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import davidAcuna.domain.Account;

@Component
public class DataSource {
	
	private static List<Account> accounts = new ArrayList<>();
	
	public DataSource(){		
		Account account_1 = new Account("David", "123456");
		Account account_2 = new Account("Alberto", "654321");
		Account account_3 = new Account("Daniel", "789012");
		Account account_4 = new Account("Andres", "210987");
		
		accounts.add(account_1);
		accounts.add(account_2);
		accounts.add(account_3);
		accounts.add(account_4);
	}

	public Account retrieveUserInformation(String username) {
		Account account = accounts.stream()
				.filter(a -> a.getUsername().equals(username))
				.findAny()
				.orElse(null);
		
		return account != null ? new Account(username, account.getPassword()) : null;
		
	}
	
}
