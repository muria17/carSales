package com.carSales.carSales.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "web_site_basic")
@Entity(name = "WebSiteBasic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class WebSiteBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "url_localization")
    private String urlLocalization;

    @Column(name = "url_instagram")
    private String urlInstagram;

    @Column(name = "address")
    private String address;
}