package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

import com.example.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

    // custom query for finding an account given username and password (used for login)
    
    Optional<Account> findByUsernameAndPassword(String username, String password);

    // custom query for finding and account given username (used for checking unique username)
    
    Optional<Account> findByUsername(String username);
}
