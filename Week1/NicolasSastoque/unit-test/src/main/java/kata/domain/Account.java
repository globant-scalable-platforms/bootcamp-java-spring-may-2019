package kata.domain;

public class Account {
    private final String username;
    private int balance;
    private final AccountType accountType;
    
    public Account(final String username, final int balance, final AccountType accountType) {
        this.username = username;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(final int balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    
}
