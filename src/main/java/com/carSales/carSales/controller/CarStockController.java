package com.carSales.carSales.controller;

import com.carSales.carSales.domain.CarStock;
import com.carSales.carSales.repository.CarStockRepository;
import com.carSales.carSales.service.CarStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("carStock")
public class CarStockController {

    @Autowired
    private CarStockRepository repository;

    @Autowired
    private CarStockService service;

    @PostMapping
    @Transactional
    public ResponseEntity<CarStock> create(@RequestBody CarStock register) {
        CarStock saved = repository.save(register);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<CarStock> findClients(){
        return service.findClientById();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<CarStock> carStock = repository.findById(id);
        if (carStock.isPresent()) {
            repository.delete(carStock.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
