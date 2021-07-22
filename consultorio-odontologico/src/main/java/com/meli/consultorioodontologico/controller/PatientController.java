package com.meli.consultorioodontologico.controller;

import com.meli.consultorioodontologico.entity.Patient;
import com.meli.consultorioodontologico.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public void cadastra(@RequestBody Patient patient) {
        service.cadastra(patient);
    }

    @GetMapping("/{dia}")
    public ResponseEntity<List<Patient>> listaPacientesDeUmDia(@PathVariable String dia) {
        return new ResponseEntity<>(service.listaPacientesDeUmDia(dia), HttpStatus.OK);
    }

}
