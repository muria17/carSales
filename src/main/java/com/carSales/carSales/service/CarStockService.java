package com.carSales.carSales.service;

import com.carSales.carSales.domain.CarStock;
import com.carSales.carSales.repository.CarStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarStockService {

    @Autowired
    private CarStockRepository repository;

    public List<CarStock> findClientById() {
        return repository.findAll();
    }

}
