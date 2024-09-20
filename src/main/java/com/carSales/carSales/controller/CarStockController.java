package com.carSales.carSales.controller;

import com.carSales.carSales.domain.CarStock;
import com.carSales.carSales.repository.CarStockRepository;
import com.carSales.carSales.service.CarStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carStock")
public class CarStockController {

    @Autowired
    private CarStockRepository repository;

    @Autowired
    private CarStockService service;

    @PostMapping
    @Transactional
    public CarStock create(@RequestBody CarStock register) {
        return repository.save(register);
    }

    @GetMapping
    public List<CarStock> findClients(){
        return service.findClientById();
    }
}
