package com.meli.consultorioodontologicojparepo.controller;

import com.meli.consultorioodontologicojparepo.entity.Turn;
import com.meli.consultorioodontologicojparepo.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {

    @Autowired
    private TurnService service;

    @GetMapping("/concluded")
    public ResponseEntity<List<Turn>> listaTurnosConcluidos() {
        return new ResponseEntity<>(service.listarTurnosConcluidos(), HttpStatus.OK);
    }

    @GetMapping("/pendent")
    public ResponseEntity<List<Turn>> listaTurnosPendentesDoDia(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(service.listarTurnosPendentesDoDia(date), HttpStatus.OK);
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
