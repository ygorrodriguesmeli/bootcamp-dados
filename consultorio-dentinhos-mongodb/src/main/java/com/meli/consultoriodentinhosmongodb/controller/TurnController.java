package com.meli.consultoriodentinhosmongodb.controller;

import com.meli.consultoriodentinhosmongodb.entity.Turn;
import com.meli.consultoriodentinhosmongodb.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {

    private final TurnService turnService;

    @Autowired
    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @PostMapping
    public ResponseEntity<String> cadastraTurn(@RequestBody Turn turn) {
        try {
            turnService.cadastraTurn(turn);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Sucesso", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Turn>> listaTurnos() {
        return new ResponseEntity<>(turnService.listaTurnos(), HttpStatus.OK);
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<Turn>> listaTurnosDeDoutor(
            @RequestParam String firstname, @RequestParam String lastname) {
        return new ResponseEntity<>(turnService.listaTurnosDeDoutor(firstname, lastname), HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Turn>> listaTurnosPorEstado(@RequestParam String status) {
        return new ResponseEntity<>(turnService.listaTurnoPorEstado(status), HttpStatus.OK);
    }

}
