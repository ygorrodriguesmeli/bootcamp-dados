package com.meli.consultorioodontologico.controller;

import com.meli.consultorioodontologico.entity.Turn;
import com.meli.consultorioodontologico.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {

    @Autowired
    private TurnService service;

    @GetMapping
    public ResponseEntity<List<Turn>> listaTurnosConcluidos() {
        return new ResponseEntity<>(service.listarTurnosConcluidos(), HttpStatus.OK);
    }

    @GetMapping("/{dia}")
    public ResponseEntity<List<Turn>> listaTurnosPendentesDoDia(@PathVariable String dia) {
        return new ResponseEntity<>(service.listarTurnosPendentesDoDia(dia), HttpStatus.OK);
    }

    @GetMapping("/reprogram")
    public ResponseEntity<List<Turn>> listaTurnosRemarcados() {
        return new ResponseEntity<>(service.listarTurnosRemarcados(), HttpStatus.OK);
    }

    @GetMapping("/reprogram/dentist/{id}")
    public ResponseEntity<List<Turn>> listaTurnosPendentesDoDia(@PathVariable Long id) {
        return new ResponseEntity<>(service.listaTurnosRemarcadosDeDentista(id), HttpStatus.OK);
    }

}
