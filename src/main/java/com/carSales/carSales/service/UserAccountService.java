package com.carSales.carSales.service;

import com.carSales.carSales.domain.UserAccount;
import com.carSales.carSales.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository repository;

    public ResponseEntity<UserAccount> validPassword(UserAccount userAccount) {
        UserAccount newUserAccount = repository.findUserAccountByLogin(userAccount);

        if (newUserAccount == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } else if (userAccount.getLogin().equals(newUserAccount.getLogin()) && userAccount.getUserAccountPassword().equals(newUserAccount.getUserAccountPassword())) {
            return ResponseEntity.ok(newUserAccount);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
