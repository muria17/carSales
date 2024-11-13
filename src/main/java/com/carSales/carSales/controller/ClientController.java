package com.carSales.carSales.controller;

import com.carSales.carSales.domain.Client;
import com.carSales.carSales.repository.ClientRepository;
import com.carSales.carSales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Client> create(@RequestBody Client register) {
        Client saved = repository.save(register);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Client> findClients(){
        return service.findClientById();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()) {
            repository.delete(client.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}