package com.nhnacademy.springbootaccount.service;

import com.nhnacademy.springbootaccount.entity.Account;
import com.nhnacademy.springbootaccount.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account createAccount(Account account) {
        boolean present = accountRepository.findById(account.getNumber()).isPresent();
        if (present) throw new IllegalStateException("already exist " + account.getNumber());

        return accountRepository.save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccount(String number) {
        return accountRepository.findById(number).orElseThrow();
    }

    @Override
    @Transactional
    public void deleteAccount(String number) {
        accountRepository.deleteById(number);
    }
}
