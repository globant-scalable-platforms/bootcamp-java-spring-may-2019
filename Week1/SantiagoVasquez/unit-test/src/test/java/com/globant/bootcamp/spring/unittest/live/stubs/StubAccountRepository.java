package com.globant.bootcamp.spring.unittest.live.stubs;

import springbootcamp.unittest.live.data.AccountRepository;
import springbootcamp.unittest.live.domain.Account;

public class StubAccountRepository implements AccountRepository {
    @Override
    public Account getAccount(String username) {
        return "Mike".equals(username)?new Account(username,"secret"):null;
    }
}
