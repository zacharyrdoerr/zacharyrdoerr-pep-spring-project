package com.example.service;

import org.springframework.stereotype.Service;

import com.example.repository.AccountRepository;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    


}
