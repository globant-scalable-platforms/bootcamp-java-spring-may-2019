# Solution
To do this kata I created an interface named "DataSource" with the method:
```java
public interface DataSource {
	Account retrieveAccountInformation(String username);
}
```
and create a java class named "DataSourceImpl" that implement the interface:
```java
@Service
public class DataSourceImpl implements DataSource{

	private List<Account> accounts;
	
	public DataSourceImpl() {
		accounts = new ArrayList<>();
		accounts.add(new Account("Santiago","secret1"));
		accounts.add(new Account("Felipe","secret2"));
		accounts.add(new Account("Fernando","secret3"));
		accounts.add(new Account("Francia","secret4"));
		accounts.add(new Account("Camila","secret5"));
		accounts.add(new Account("Laura","secret6"));
		accounts.add(new Account("Marco","secret7"));
		accounts.add(new Account("Fernanda","secret8"));
		accounts.add(new Account("Leyda","secret9"));
		accounts.add(new Account("Daniel","secret10"));
		accounts.add(new Account("Valentina","secret11"));
	}

	@Override
	public Account retrieveAccountInformation(String username) {
		Account account = accounts.stream()
				.filter(ac -> ac.getUsername().equals(username))
				.findFirst()
				.orElse(null);
		
		return account == null ? null : account;
	}
	
}
```
And then inject "DataSourceImpl" through the interface "DataSource" (dependency injection) in the class "CustomAccountRepository":
```java
@Repository
public class CustomAccountRepository implements AccountRepository {
	
	@Autowired
	private DataSource datasource;

    public Account getAccount(String username) {
    	return datasource.retrieveAccountInformation(username);
    }
}
```