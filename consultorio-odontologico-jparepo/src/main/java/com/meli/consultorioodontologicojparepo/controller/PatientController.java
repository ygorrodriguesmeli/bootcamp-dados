package com.meli.consultorioodontologicojparepo.controller;

import com.meli.consultorioodontologicojparepo.entity.Patient;
import com.meli.consultorioodontologicojparepo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping
    public ResponseEntity<List<Patient>> listaPacientesDeUmDia(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(service.listaPacientesDeUmDia(date), HttpStatus.OK);
    }

}
