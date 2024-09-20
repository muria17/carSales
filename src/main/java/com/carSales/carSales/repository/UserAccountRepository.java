package com.carSales.carSales.repository;

import com.carSales.carSales.domain.UserAccount;
import com.carSales.carSales.repositoryCustom.UserAccountRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>, UserAccountRepositoryCustom {
}
