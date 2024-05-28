package com.carSales.carSales.controller;

import com.carSales.carSales.domain.CarStock;
import com.carSales.carSales.repository.CarStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carStock")
public class carStockController {

    @Autowired
    private CarStockRepository repository;

    @PostMapping
    @Transactional
    public CarStock create(@RequestBody CarStock register) {
        return repository.save(register);
    }
}
