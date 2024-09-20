package com.carSales.carSales.repositoryCustom;

import com.carSales.carSales.domain.UserAccount;

public interface UserAccountRepositoryCustom {

    UserAccount findUserAccountByLogin(UserAccount userAccount);
}
