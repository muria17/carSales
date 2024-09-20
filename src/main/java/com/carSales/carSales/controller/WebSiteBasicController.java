package com.carSales.carSales.controller;

import com.carSales.carSales.domain.WebSiteBasic;
import com.carSales.carSales.repository.WebSiteBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webSiteBasic")
public class WebSiteBasicController {

    @Autowired
    private WebSiteBasicRepository repository;

    @PostMapping
    @Transactional
    public WebSiteBasic create(@RequestBody WebSiteBasic register) {
        return repository.save(register);
    }
}
