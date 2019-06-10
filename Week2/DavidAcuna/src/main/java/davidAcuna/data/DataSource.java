package davidAcuna.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import davidAcuna.domain.Account;
import davidAcuna.domain.Student;

@Component
public class DataSource {
	
	private static List<Account> accounts = new ArrayList<>();
	private static List<Student> students = new ArrayList<>();
	
	public DataSource(){		
		accounts.add(new Account("David", "123456"));
		accounts.add(new Account("Alberto", "654321"));
		accounts.add(new Account("Daniel", "789012"));
		accounts.add(new Account("Andres", "210987"));
		
		students.add(new Student("David", 12345678, 23));
		students.add(new Student("David", 987654, 24));
		students.add(new Student("Andres", 97538064, 19));
		students.add(new Student("Carlos", 6763898, 30));
	}

	public Account retrieveUserInformation(String username) {
		Account account = accounts.stream()
				.filter(a -> a.getUsername().equals(username))
				.findAny()
				.orElse(null);
		
		return account != null ? new Account(username, account.getPassword()) : null;
		
	}
	
	public List<Student> getStudents() {		
		return students;		
	}
	
}
