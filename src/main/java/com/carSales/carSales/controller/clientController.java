package com.carSales.carSales.controller;

import com.carSales.carSales.domain.Client;
import com.carSales.carSales.repository.ClientRepository;
import com.carSales.carSales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class clientController {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientService service;

    @PostMapping
    @Transactional
    public Client create(@RequestBody Client register) {
        return repository.save(register);
    }

    @GetMapping
    public List<Client> findClients(){
        return service.findClientById();
    }
}