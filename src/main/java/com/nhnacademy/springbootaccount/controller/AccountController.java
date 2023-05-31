package com.nhnacademy.springbootaccount.controller;

import com.nhnacademy.springbootaccount.service.AccountService;
import com.nhnacademy.springbootaccount.entity.Account;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{number}")
    public Account getAccount(@PathVariable String number) {
        return accountService.getAccount(number);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping("/{number}")
    public String deleteAccount(@PathVariable String number) {
        accountService.deleteAccount(number);
        return "{\"result\":\"OK\"}";
    }
}
