package com.carSales.carSales.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "user_account")
@Entity(name = "UserAccount")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    String name;
    String userAccountPassword;
    Long customerId;
}