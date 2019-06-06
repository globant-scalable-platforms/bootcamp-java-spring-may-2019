package springbootcamp.unittest.kata.exception;

import springbootcamp.unittest.kata.domain.Account;

public class AccountException extends Exception {
    private static final long serialVersionUID = 1L;

    public AccountException(String message){
        super(message);
    }
}
