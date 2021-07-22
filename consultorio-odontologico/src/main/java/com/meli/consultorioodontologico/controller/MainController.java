package com.meli.consultorioodontologico.controller;

import com.meli.consultorioodontologico.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService service;

    @GetMapping("/populate-database")
    public void populateDatabase() {
        service.populateDatabase();
    }

}
