package com.carSales.carSales.service;

import com.carSales.carSales.domain.Client;
import com.carSales.carSales.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findClientById() {
        return repository.findAll();
    }
}
