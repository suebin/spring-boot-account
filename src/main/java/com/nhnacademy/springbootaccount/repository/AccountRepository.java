package com.nhnacademy.springbootaccount.repository;

import com.nhnacademy.springbootaccount.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findAll();

    Optional<Account> findById(String number);
}
