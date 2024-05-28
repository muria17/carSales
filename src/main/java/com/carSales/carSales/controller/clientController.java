package com.carSales.carSales.controller;

import com.carSales.carSales.domain.Client;
import com.carSales.carSales.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class clientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public Client create(@RequestBody Client register) {
        return repository.save(register);
    }
}