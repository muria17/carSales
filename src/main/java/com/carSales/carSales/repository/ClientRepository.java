package com.carSales.carSales.repository;

import com.carSales.carSales.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
