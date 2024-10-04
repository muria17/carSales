package com.carSales.carSales.controller;

import com.carSales.carSales.domain.UserAccount;
import com.carSales.carSales.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("userAccount")
public class UserAccountController {

    @Autowired
    private UserAccountService service;

    @PostMapping(value = "/createNewUser")
    public ResponseEntity<String> createNewUser(@RequestBody UserAccount userAccount){
        return service.createNewUser(userAccount);
    }

    @PostMapping(value = "/validUserAndPassword")
    public ResponseEntity<String> validUserAndPassword(@RequestBody UserAccount userAccount){
        return service.validUserAndPassword(userAccount);
    }
}
