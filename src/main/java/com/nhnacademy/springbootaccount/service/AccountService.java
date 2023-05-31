package com.nhnacademy.springbootaccount.service;

import com.nhnacademy.springbootaccount.entity.Account;
import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account createAccount(Account account);

    Account getAccount(String number);

    void deleteAccount(String number);
}
