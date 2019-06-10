package davidAcuna.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import davidAcuna.domain.Account;
import davidAcuna.domain.Student;

@Repository
public class CustomAccountRepository implements AccountRepository {
	
	@Autowired
	DataSource dataSource;

    public Account getAccount(String username) {
        return dataSource.retrieveUserInformation(username);
    }
    
    public List<Student> getStudents() {
        return dataSource.getStudents();
    }
}