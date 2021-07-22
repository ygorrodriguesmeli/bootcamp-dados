package com.meli.consultorioodontologico.controller;

import com.meli.consultorioodontologico.entity.Dentist;
import com.meli.consultorioodontologico.entity.Diary;
import com.meli.consultorioodontologico.entity.Turn;
import com.meli.consultorioodontologico.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService service;

    @GetMapping("/turn")
    public ResponseEntity<List<Dentist>> listaDentistasComMaisDeDoisTurnos(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(service.listaDentistasComMaisDeDoisTurnos(date), HttpStatus.OK);
    }

    @GetMapping("/{id}/diary")
    public ResponseEntity<List<Turn>> listaAgendaDentista(@PathVariable Long id) {
        return new ResponseEntity<>(service.listaAgendaDentista(id), HttpStatus.OK);
    }

}
