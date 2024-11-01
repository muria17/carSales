package com.carSales.carSales.repositoryCustom;

import com.carSales.carSales.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class UserAccountRepositoryImpl implements UserAccountRepositoryCustom {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserAccount findUserAccountByLogin(UserAccount userAccount) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append(" id                       AS id, ");
        query.append(" login                    AS login, ");
        query.append(" customer_id              AS customer_id, ");
        query.append(" user_account_password    AS user_account_password ");
        query.append(" FROM user_account ua ");
        query.append(" WHERE login = :login ");

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("login", userAccount.getLogin(), Types.VARCHAR);

        List<UserAccount> results = namedParameterJdbcTemplate.query(query.toString(), namedParameters, (rs, rowNum) -> {
            UserAccount newUserAccount = new UserAccount();
            newUserAccount.setId(rs.getLong("id"));
            newUserAccount.setCustomerId(rs.getLong("customer_id"));
            newUserAccount.setLogin(rs.getString("login"));
            newUserAccount.setUserAccountPassword(rs.getString("user_account_password"));
            return newUserAccount;
        });
        return results.isEmpty() ? null : results.get(0);
    }
}

