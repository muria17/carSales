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

    @Autowired
    private PasswordUtilService passwordUtilService;


    public ResponseEntity<String> validUserAndPassword(UserAccount userAccount) {
        UserAccount newUserAccount = repository.findUserAccountByLogin(userAccount);

        if (newUserAccount != null) {

            boolean isPasswordMatch = passwordUtilService.matches(userAccount.getUserAccountPassword(), newUserAccount.getUserAccountPassword());

            return isPasswordMatch ? ResponseEntity.ok("Login realizado com sucesso") : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado.");
        }
    }

    public ResponseEntity<String> createNewUser(UserAccount userAccount) {
        UserAccount newUseraccount = new UserAccount();
        newUseraccount.setLogin(userAccount.getLogin());
        newUseraccount.setCustomerId(userAccount.getCustomerId());

        String passwordEncoded = passwordUtilService.encodePassword(userAccount.getUserAccountPassword());

        newUseraccount.setUserAccountPassword(passwordEncoded);

        repository.save(newUseraccount);

        return ResponseEntity.ok("Usuario cadastrado com sucesso");

    }
}
