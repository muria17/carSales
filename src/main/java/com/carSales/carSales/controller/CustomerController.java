package com.carSales.carSales.controller;

import com.carSales.carSales.domain.Customer;
import com.carSales.carSales.domain.UserAccount;
import com.carSales.carSales.repository.CustomerRepository;
import com.carSales.carSales.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Transactional
    @PostMapping
    public Customer create(@RequestBody Customer register) {
        return repository.save(register);
    }

    @Transactional
    @PostMapping(value = "/createUserAccount")
    public UserAccount createUserAccount(@RequestBody UserAccount register) {
        return userAccountRepository.save(register);
    }
}
