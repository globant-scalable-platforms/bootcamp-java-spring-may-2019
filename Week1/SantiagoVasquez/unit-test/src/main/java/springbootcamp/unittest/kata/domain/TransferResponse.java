package springbootcamp.unittest.kata.domain;

public class TransferResponse {
    
    private final Account currentAccount;
    private final Account savingAccount;

    public TransferResponse(final Account currentAccount, final Account savingAccount) {
        this.currentAccount = currentAccount;
        this.savingAccount = savingAccount;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public Account getSavingAccount() {
        return savingAccount;
    }
    
}
