package com.example.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    // service method for user registration
    public Account persistAccount(Account acc){
        if (getAccountByUsername(acc.getUsername())){

            return null; // return the duplicate error code
        }
        if (acc.getPassword().length() < 4 || acc.getUsername().isBlank()){

            return null; // return the general error code
        }
        return accountRepository.save(acc);
    }

    // service method for obtaining account from a given username
    // returns a boolean to determine if username already exists
    public Boolean getAccountByUsername(String username){

        Optional<Account> optionalAccount = accountRepository.findAccountByUsername(username);

        if (optionalAccount.isPresent()){

            return true;
        }else{
            return false;
        }
    }

    // service method for obtaining account from a given id
    public Account getAccountById(int id){
        Optional<Account> optionalAccount = accountRepository.findById(id);

        if (optionalAccount.isPresent()){

            return optionalAccount.get();
        }else{
            return null;
        }

    }

    public Account getAccountByUsernameAndPassword(Account acc){

        Optional<Account> optionalAccount =  accountRepository.findAccountByUsernameAndPassword(acc.getUsername(), acc.getPassword());

        if (optionalAccount.isPresent()){

            return optionalAccount.get();
        }else{

            return null;
        }
    }

    


}
