package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.exception.*;

@Service
@Transactional
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    // service method for user registration
    public Account persistAccount(Account acc){
        if (getAccountByUsername(acc.getUsername())){

            // set status to 409 (Conflict)
            throw new DuplicateUserException();
            
        }
        if (acc.getPassword().length() < 4 || acc.getUsername().isBlank()){

            // set status to 400 (Client Error)
            throw new ClientErrorException();
        }

        return accountRepository.save(acc);
    }

    // service method for obtaining account from a given username
    // returns a boolean to determine if username already exists
    public Boolean getAccountByUsername(String username){

        return accountRepository.findByUsername(username).isPresent();
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

        Optional<Account> optionalAccount =  accountRepository.findByUsernameAndPassword(acc.getUsername(), acc.getPassword());

        if (optionalAccount.isPresent()){

            return optionalAccount.get();
        }else{

            // set status to 401 (Unauthorized)
            throw new UnauthorizedUserException();
        }
    }

    


}
