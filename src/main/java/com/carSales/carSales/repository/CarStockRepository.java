package com.carSales.carSales.repository;

import com.carSales.carSales.domain.CarStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarStockRepository extends JpaRepository<CarStock, Long> {
}
