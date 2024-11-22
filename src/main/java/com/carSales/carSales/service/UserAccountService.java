package com.carSales.carSales.service;

import com.carSales.carSales.domain.UserAccount;
import com.carSales.carSales.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository repository;

    @Autowired
    private PasswordUtilService passwordUtilService;


    public ResponseEntity<Map<String, String>> validUserAndPassword(UserAccount userAccount) {
        UserAccount newUserAccount = repository.findUserAccountByLogin(userAccount);

        Map<String, String> response = new HashMap<>();

        if (newUserAccount != null) {
            boolean isPasswordMatch = passwordUtilService.matches(
                    userAccount.getUserAccountPassword(),
                    newUserAccount.getUserAccountPassword()
            );
            if (isPasswordMatch) {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    public ResponseEntity<UserAccount> createNewUser(UserAccount userAccount) {
        UserAccount newUseraccount = new UserAccount();
        newUseraccount.setLogin(userAccount.getLogin());
        newUseraccount.setCustomerId(userAccount.getCustomerId());

        String passwordEncoded = passwordUtilService.encodePassword(userAccount.getUserAccountPassword());
        newUseraccount.setUserAccountPassword(passwordEncoded);

        repository.save(newUseraccount);
        return ResponseEntity.ok(newUseraccount);
    }
}
