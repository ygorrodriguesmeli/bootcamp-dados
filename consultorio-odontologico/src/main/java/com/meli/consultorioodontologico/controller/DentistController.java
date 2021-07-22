package com.meli.consultorioodontologico.controller;

import com.meli.consultorioodontologico.entity.Dentist;
import com.meli.consultorioodontologico.entity.Diary;
import com.meli.consultorioodontologico.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService service;

    @GetMapping("/turn/{dia}")
    public ResponseEntity<List<Dentist>> listaDentistasComMaisDeDoisTurnos(@PathVariable String dia) {
        return new ResponseEntity<>(service.listaDentistasComMaisDeDoisTurnos(dia), HttpStatus.OK);
    }

    @GetMapping("/{id}/diary")
    public ResponseEntity<List<Diary>> listaAgendaDentista(@PathVariable Long id) {
        return new ResponseEntity<>(service.listaAgendaDentista(id), HttpStatus.OK);
    }

}
